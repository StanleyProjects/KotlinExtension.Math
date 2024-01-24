package sp.kx.math.unsafe

import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Locale
import kotlin.math.pow

internal fun toString(number: Double, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%.${points}f", number)
}

internal fun toString(number: Double, total: Int, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%0$total.${points}f", number)
}

internal fun eq(it: Double, other: Double, points: Int): Boolean {
    return BigDecimal((it - other) * 10.0.pow(points))
        .setScale(1, RoundingMode.HALF_EVEN)
        .toLong() == 0L
}

internal fun gt(it: Double, other: Double, points: Int): Boolean {
    return BigDecimal((it - other) * 10.0.pow(points))
        .setScale(1, RoundingMode.HALF_EVEN)
        .toLong() > 0L
}

internal fun lt(it: Double, other: Double, points: Int): Boolean {
    return BigDecimal((it - other) * 10.0.pow(points))
        .setScale(1, RoundingMode.HALF_EVEN)
        .toLong() < 0L
}
