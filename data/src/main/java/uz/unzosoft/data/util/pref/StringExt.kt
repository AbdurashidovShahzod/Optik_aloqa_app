package uz.unzosoft.data.util.pref

import kotlin.math.pow


val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
val snakeRegex = "_[a-zA-Z]".toRegex()

// String extensions
fun String.camelToSnakeCase(): String {
    return camelRegex.replace(this) {
        "_${it.value}"
    }.toLowerCase()
}

fun String.snakeToLowerCamelCase(): String {
    return snakeRegex.replace(this) {
        it.value.replace("_", "").toUpperCase()
    }
}

fun String.snakeToUpperCamelCase(): String {
    return this.snakeToLowerCamelCase().capitalize()
}

fun String.camelToUpperSnakeCase(): String {
    return this.camelToSnakeCase().toUpperCase()
}

fun String.isZiraatCard(): Boolean {
    return this.isZiraatUzCard() || this.isZiraatHumoCard()
}

fun String.isZiraatUzCard(): Boolean {
    val pan = this.replace(" ", "")
    return pan.startsWith("860020")
}

fun String.isZiraatHumoCard(): Boolean {
    val pan = this.replace(" ", "")
    return pan.startsWith("986029")
}

fun String.substringMaskedPan(): String {
    val start = this.substring(0, 6)
    val end = this.substring(12)
    return start + end
}

fun String?.equalsPanMaskedPan(maskedPan: String?): Boolean {
    if (this.isNullOrBlank())
        return false
    if (maskedPan.isNullOrBlank())
        return false
    val start = this.substring(0, 6) == maskedPan.substring(0, 6)
    val end = this.substring(12) == maskedPan.substring(12)
    return start && end
}

fun String.toSumString(): String {
    val a = this.reversed()
    var count = 1
    var b = ""
    a.forEachIndexed { index, c ->
        b += c
        if (count % 3 == 0) {
            b += " "
        }
        count++
    }
    return b.reversed().trim()
}

fun Long?.toSumString(): String {
    if (this == null) return "0"
    val a = this.toString().reversed()
    var count = 1
    var b = ""
    a.forEachIndexed { index, c ->
        b += c
        if (count % 3 == 0) {
            b += " "
        }
        count++
    }
    return b.reversed().trim()
}

fun Double?.toSumString(): String {
    if (this == null) return "0"
    val a = this.toLong().toString().reversed()
    var count = 1
    var b = ""
    a.forEachIndexed { index, c ->
        b += c
        if (count % 3 == 0) {
            b += " "
        }
        count++
    }
    return b.reversed().trim()
}

fun Int.toSumString(): String {
    val a = this.toString().reversed()
    var count = 1
    var b = ""
    a.forEachIndexed { index, c ->
        b += c
        if (count % 3 == 0) {
            b += " "
        }
        count++
    }
    return b.reversed().trim()
}

fun Long?.toFractionalPart(count: Int): String {
    if (this == null) {
        return "00"
    }
    val divSum = 10.0.pow(count.toDouble())
    val textTemp = String.format("%.${count}f", this.div(divSum))
    val f = textTemp.length.minus(count)
    return textTemp.substring(f)
}

fun Double?.toFractionalPart(count: Int): String {
    if (this == null) {
        return "00"
    }
    val divSum = 10.0.pow(count.toDouble())
    val textTemp = String.format("%.${count}f", this.div(divSum))
    val f = textTemp.length.minus(count)
    return textTemp.substring(f)
}

