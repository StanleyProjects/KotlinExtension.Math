package sp.kx.math.unsafe

import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Locale

internal fun toString(number: Double, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%.${points}f", number)
}

internal fun toString(number: Double, total: Int, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%0$total.${points}f", number)
}

internal fun eq(it: Double, other: Double, points: Int): Boolean {
    val e = java.lang.Math.pow(10.0, points.toDouble())
    val diff = java.lang.Math.abs(it - other)
    val de = diff * e
//    return de.toLong() == 0L
    if (de.toLong() == 0L) return true
    if (java.lang.Math.abs(it * e) < 1 && java.lang.Math.abs(other * e) < 1) return true
    return false
}

internal fun gt(it: Double, other: Double, points: Int): Boolean {
    return BigDecimal.valueOf(it)
        .setScale(points, RoundingMode.DOWN) > BigDecimal.valueOf(other)
        .setScale(points, RoundingMode.DOWN)
}

internal fun lt(it: Double, other: Double, points: Int): Boolean {
    return BigDecimal.valueOf(it)
        .setScale(points, RoundingMode.DOWN) < BigDecimal.valueOf(other)
        .setScale(points, RoundingMode.DOWN)
}
