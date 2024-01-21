package sp.kx.math.unsafe

import java.util.Locale
import kotlin.math.pow

internal fun toString(number: Double, points: Int, locale: Locale): String {
    return String.format(locale, "%.${points}f", number)
}

internal fun toString(number: Double, total: Int, points: Int, locale: Locale): String {
    return String.format(locale, "%0$total.${points}f", number)
}

internal fun eq(it: Double, other: Double, points: Int): Boolean {
    val delta = 10.0.pow(points)
    return (it * delta).toInt() == (other * delta).toInt()
}

internal fun lt(it: Double, other: Double, points: Int): Boolean {
    val delta = 10.0.pow(points)
    return (it * delta).toInt() < (other * delta).toInt()
}

internal fun gt(it: Double, other: Double, points: Int): Boolean {
    val delta = 10.0.pow(points)
    return (it * delta).toInt() > (other * delta).toInt()
}
