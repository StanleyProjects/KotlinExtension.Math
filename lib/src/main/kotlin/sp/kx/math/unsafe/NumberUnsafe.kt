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
    if (java.lang.Math.abs(it - other) > 2.0) return false
    val e = java.lang.Math.pow(10.0, points.toDouble())
    val d1 = it * e
    val d2 = other * e
    val l1 = d1.toLong()
    val l2 = d2.toLong()
    val r1 = java.lang.Math.round(d1)
    val r2 = java.lang.Math.round(d2)
    val f1 = java.lang.Math.floor(d1)
    val f2 = java.lang.Math.floor(d2)
    if (f1.toLong() == r1 && f2.toLong() == r2 && l1 == r1 && l2 == r2) {
        if (r1 == r2) return true
    }
    return BigDecimal.valueOf(it)
        .setScale(points, RoundingMode.DOWN) == BigDecimal.valueOf(other)
        .setScale(points, RoundingMode.DOWN)
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
