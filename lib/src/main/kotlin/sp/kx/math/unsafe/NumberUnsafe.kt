package sp.kx.math.unsafe

import java.util.Locale
import kotlin.math.absoluteValue
import kotlin.math.pow

internal fun toString(number: Double, points: Int, locale: Locale): String {
    return String.format(locale, "%.${points}f", number)
}

internal fun toString(number: Double, total: Int, points: Int, locale: Locale): String {
    return String.format(locale, "%0$total.${points}f", number)
}

internal fun eq(it: Double, other: Double, points: Int): Boolean {
//    val diff = (it - other).absoluteValue
//    val delta = 10.0.pow(points)
//    return (diff * delta).toInt() == 0
    //
    return ((it - other) * 10.0.pow(points)).toInt() == 0
    //
//    return diff * delta == 0.0 // todo
//    return (it * delta).toInt() == (other * delta).toInt() // todo
}

internal fun lt(it: Double, other: Double, points: Int): Boolean {
    val delta = 10.0.pow(points)
    return (it * delta).toInt() < (other * delta).toInt() // todo
}

internal fun gt(it: Double, other: Double, points: Int): Boolean {
    val delta = 10.0.pow(points)
    return (it * delta).toInt() > (other * delta).toInt() // todo
}
