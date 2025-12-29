fun main() {
    readln()

    val conscious = readln().split(' ').drop(1).map { it.toInt() }.toMutableSet()
    val parties = ArrayList<Set<Int>>()

    var l: String?
    while (readLine().also { l = it } != null) {
        val set = l!!.split(' ').drop(1).map { it.toInt() }.toSet()
        var mut = false
        for (i in conscious) {
            if (i in set) {
                mut = true
                conscious.addAll(set)
                break
            }
        }
        if (!mut)
            parties.add(set)
    }

    while (true) {
        var mut = false

        val it = parties.iterator()
        while (it.hasNext()) {
            val party = it.next()
            var add = false
            for (i in conscious) {
                if (i in party) {
                    mut = true
                    add = true
                    it.remove()
                    break
                }
            }
            if (add)
                conscious.addAll(party)
        }

        if (!mut)
            break
    }

    print(parties.size)
}
