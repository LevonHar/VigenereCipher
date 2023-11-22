fun main() {
    val plaintext = "Kotlin Code"
    val key = "NEWKEY"
    val ciphertext = vigenereCipher(plaintext, key, true)
    println("Encrypted: $ciphertext")
    val decryptedText = vigenereCipher(ciphertext, key, false)
    println("Decrypted: $decryptedText")
}

fun vigenereCipher(input: String, key: String, encrypt: Boolean): String {
    val result = StringBuilder()
    val keyLength = key.length
    for (i in input.indices) {
        val inputChar = input[i]
        val keyChar = key[i % keyLength].toInt() % 256
        val resultChar: Char = if (encrypt) {
            ((inputChar.toInt() + keyChar) % 256).toChar()
        } else {
            ((inputChar.toInt() - keyChar + 256) % 256).toChar()
        }
        result.append(resultChar)
    }
    return result.toString()
}