import com.fasterxml.jackson.databind.ObjectMapper
import java.net.HttpURLConnection
import java.net.URL
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.Cipher

val mapper = ObjectMapper()

fun main() {

}

fun login(id: String, pass: String): Pair<String, String>? {
    val (verify, enc) = key()
    val pw = encrypt(enc, pass)
    val con = URL("https://localhost:2096/api/v1/sign/in").openConnection() as HttpURLConnection
    con.requestMethod = "POST"
    con.doOutput = true
    con.outputStream.use {
        val body = mapper.writeValueAsBytes(mapOf(
            "username" to id,
            "password" to pw,
            "verificationToken" to verify
        ))
    }
    con.connect()
    return if (con.responseCode != 200) {
        println(String(con.errorStream.readBytes()))
        con.disconnect()
        null
    } else {
        val j = mapper.readTree(con.inputStream)
        con.disconnect()
        j["accessToken"].asText() to j["refreshToken"].asText()
    }

}

fun register(id: String, pass: String, email: String) {
    val (verify, enc) = key()
    val pw = encrypt(enc, pass)
    val con = URL("https://localhost:2096/api/v1/sign/up").openConnection() as HttpURLConnection
    con.requestMethod = "POST"
    con.doOutput = true
    con.outputStream.use {
        val body = mapper.writeValueAsBytes(mapOf(
            "username" to id,
            "password" to pw,
            "email" to email,
            "verificationToken" to verify
        ))
    }
    con.connect()
    if (con.responseCode != 200)
        println(String(con.errorStream.readBytes()))
    con.disconnect()
}


fun key(): Pair<String, String> {
    val con = URL("https://localhost:2096/api/v1/verify/key").openConnection() as HttpURLConnection
    con.requestMethod = "GET"
    con.connect()
    val t = mapper.readTree(con.inputStream)
    val publicKey = t["publicKey"].asText()
    val verifyKey = t["verificationToken"].asText()
    return verifyKey to publicKey
}

fun encrypt(publicKey: String, message: String): String {
    val public = KeyFactory.getInstance("RSA").generatePublic(X509EncodedKeySpec(Base64.getDecoder().decode(publicKey.toByteArray())))
    val cipher = Cipher.getInstance("RSA")
    cipher.init(Cipher.ENCRYPT_MODE, public)
    return Base64.getEncoder().encodeToString(cipher.doFinal(message.toByteArray()))
}