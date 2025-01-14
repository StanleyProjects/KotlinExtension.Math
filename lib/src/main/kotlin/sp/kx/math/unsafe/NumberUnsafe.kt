package sp.kx.math.unsafe

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import java.util.Locale
import kotlin.math.absoluteValue

internal fun toString(number: Double, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%.${points}f", number)
}

internal fun toString(number: Double, total: Int, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%0$total.${points}f", number)
}

internal fun eq(it: Double, other: Double, points: Int): Boolean {
    val diff = it - other
    val de = diff * java.lang.Math.pow(10.0, points.toDouble())
    if (de > 2.0 || de < -2.0) return false
    return BigDecimal.valueOf(it)
        .scaleByPowerOfTen(points)
        .toBigInteger() == BigDecimal.valueOf(other)
        .scaleByPowerOfTen(points)
        .toBigInteger()
//    return java.lang.Math.ceil((it - other) * java.lang.Math.pow(10.0, points.toDouble())).toLong() == 0L
//    return java.lang.Math.round((it - other) * java.lang.Math.pow(10.0, points.toDouble())) == 0L
}

internal fun gt(it: Double, other: Double, points: Int): Boolean {
    return java.lang.Math.round((it - other) * java.lang.Math.pow(10.0, points.toDouble())) > 0
}

internal fun lt(it: Double, other: Double, points: Int): Boolean {
    return java.lang.Math.round((it - other) * java.lang.Math.pow(10.0, points.toDouble())) < 0
}
