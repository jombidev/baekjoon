fun main() {
    val parser = XmlParser()
    for (s in String(System.`in`.readBytes()).split("\n").dropLastWhile { it.isBlank() }) {
        try {
            println(if (parser.valid(s)) "valid" else "invalid")
        } catch (e: ParseException) {
            println("invalid")
        }
        parser.clear()
    }
}

class ParseException(message: String) : RuntimeException(message)

class XmlParser {
    private val bracketKeeper = StringBuilder()
    private val ampKeeper = StringBuilder()
    private val context = arrayListOf<String>()
    private val alphabet = ('a'..'z') + ('0'..'9')
    private val hexadecimal = ('0'..'9') + ('A'..'F') + ('a'..'f')

    private val availableAmpCommand = listOf("amp", "gt", "lt")

    fun clear() {
        bracketKeeper.clear()
        ampKeeper.clear()
        context.clear()
    }

    private fun checkAndPop(tag: String): Boolean {
        val last = context.lastOrNull()
        if (last != tag.replace("/", "")) {
            return false
        }
        context.removeLast()
        return true
    }

    private fun validateTag() {
        val tag = bracketKeeper.toString()
        bracketKeeper.clear()
        val startsWith = tag.startsWith("/")
        val endsWith = tag.endsWith("/")
        if (startsWith && endsWith)
            throw ParseException("tag is available for only one slash")
        else if (startsWith) { // </tag>, tag pop action
            // pop
            val popResult = checkAndPop(tag)
            if (!popResult) throw ParseException("pop fail") // invalid: tag is not matching with last opening tag
        } else if (endsWith) // <tag/> pattern, do nothing
        else context.add(tag) // no slash. add to context
    }

    fun valid(text: String): Boolean {
        val e = text.iterator()
        var checkTag = false
        var checkAmp = false
        while (e.hasNext()) {
            val c = e.nextChar()
            if (c == '<') {
                if (checkTag) throw ParseException("< open check") // invalid: tag already checking. '<<' like pattern
                checkTag = true
                continue
            } else if (c == '&') {
                if (checkAmp) throw ParseException("double & check") // invalid: amp mod is already opened
                checkAmp = true
                continue
            }

            if (c == '>' && !checkTag) // invalid: tag check finished or not started. '>>' like pattern
                throw ParseException("> close check")

            if (c == '>') {
                checkTag = false
                validateTag()
                continue
            }

            if (checkTag && checkAmp) throw ParseException("both amp and tag checking is invalid pattern")

            if (checkAmp) {
                if (c == ';') {
                    checkAmp = false // closing
                    val amp = ampKeeper.toString()
                    ampKeeper.clear()
                    if (amp.startsWith('x')) {
                        val num = amp.drop(1)
                        if (num.isEmpty() || num.length % 2 != 0)
                            throw ParseException("num is not even")
                        if (num.any { it !in hexadecimal })
                            throw ParseException("not hexadecimal number")
                    } else if (amp !in availableAmpCommand)
                        throw ParseException("invalid amp command: $amp (available: ${availableAmpCommand.joinToString(", ")}, hex)")
                    continue
                }
                ampKeeper.append(c)
            }

            // check: tag open
            if (checkTag) {
                if (c !in alphabet && c != '/') // invalid: not lower alphabet or slash
                    throw ParseException("not alphabet: $c")
                bracketKeeper.append(c)
            }
        }

        if (checkAmp) throw ParseException("amp is not closed when it end.")
        if (checkTag) throw ParseException("tag is not closed when it end.")

        return context.isEmpty()
    }
}
