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
    val diff = it - other
    return (diff * e).toLong() == 0L || (it * e).toLong() == 0L && (other * e).toLong() == 0L
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
