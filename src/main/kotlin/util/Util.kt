package util

fun toIntOrThrowException(value: String): Int =
    value.toIntOrNull()?.let { value.toInt() }
        ?: throw IllegalArgumentException("$value must be numeric!")


fun readConsoleLine(message: String): String =
    readLine()
        ?: throw IllegalArgumentException(message)
