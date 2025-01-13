package sp.kx.math.unsafe

import java.util.Locale

internal fun toString(number: Double, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%.${points}f", number)
}

internal fun toString(number: Double, total: Int, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%0$total.${points}f", number)
}

internal fun eq(it: Double, other: Double, points: Int): Boolean {
    return java.lang.Math.round((it - other) * java.lang.Math.pow(10.0, points.toDouble())) == 0L
}

internal fun gt(it: Double, other: Double, points: Int): Boolean {
    return java.lang.Math.round((it - other) * java.lang.Math.pow(10.0, points.toDouble())) > 0
}

internal fun lt(it: Double, other: Double, points: Int): Boolean {
    return java.lang.Math.round((it - other) * java.lang.Math.pow(10.0, points.toDouble())) < 0
}
