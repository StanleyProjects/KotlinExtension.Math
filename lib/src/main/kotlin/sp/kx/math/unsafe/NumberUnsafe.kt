package sp.kx.math.unsafe

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.Locale
import kotlin.math.absoluteValue
import kotlin.math.pow
import sp.kx.math.toString

internal fun toString(number: Double, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%.${points}f", number)
}

internal fun toString(number: Double, total: Int, points: Int, locale: Locale): String {
    return java.lang.String.format(locale, "%0$total.${points}f", number)
}

internal fun eq(it: Double, other: Double, points: Int): Boolean {
//    val diff = (it - other).absoluteValue
//    val delta = 10.0.pow(points)
//    return Math.floor(diff * delta).toInt() == 0 // todo
    //
//    val arithmetic = Scales
//        .getScaleMetrics(points)
//        .getArithmetic(RoundingMode.FLOOR)
//    val av = arithmetic.fromDouble(it)
//    val ao = arithmetic.fromDouble(other)
////    val avr = arithmetic.round(av, points)
////    val aor = arithmetic.round(ao, points)
////    val message = """
////        points: $points
////        value: ${it.toString(points = 32)}
////        other: ${other.toString(points = 32)}
////        avr: $avr
////        aor: $aor
////    """.trimIndent()
////    error(message)
////    return avr == aor
//    return arithmetic.compare(av, ao) == 0
    //
//    return toString(it, points, Locale.US) == toString(other, points, Locale.US)
//    val df = DecimalFormat("#." + "#".repeat(points))
//    df.roundingMode = RoundingMode.FLOOR
//    return df.format(it) == df.format(other)
//    return Math.abs(it - other) < 10.0.pow(-points) // todo
    //
    val bd1 = BigDecimal(it)
    val bd2 = BigDecimal(other)
    val diff = bd1 - bd2
    val delta = BigDecimal(10).pow(points)
    val d = diff * delta
//    return d.setScale(1, RoundingMode.FLOOR).toLong() == 0L
//    val scaled = d.setScale(1, RoundingMode.FLOOR)
    val scaled = d.setScale(1, RoundingMode.HALF_EVEN)
//    return scaled == BigDecimal.ZERO
    return scaled.toLong() == 0L
//    return s == BigDecimal.ZERO
//    return diff * delta == BigDecimal.ZERO // todo
////    return (diff * delta).longValueExact() == 0L
//    return (diff * delta).toLong() == 0L
//    return (diff * delta).setScale(0, RoundingMode.UNNECESSARY).toLong() == 0L
    //
//    return Math.round(diff * delta).toInt() == 0 // todo
//    return (diff * delta).toInt() == 0 // todo
//    val d = (diff * delta * 10).toInt()
//    return d <= 1 // todo
    //
//    return ((it - other) * 10.0.pow(points)).toInt() == 0
    //
//    return diff * delta == 0.0 // todo
//    return (it * delta).toInt() == (other * delta).toInt() // todo
}

internal fun lt(it: Double, other: Double, points: Int): Boolean {
    TODO("BigDecimal:lt")
    val delta = 10.0.pow(points)
    return (it * delta).toInt() < (other * delta).toInt() // todo
}

internal fun gt(it: Double, other: Double, points: Int): Boolean {
    TODO("BigDecimal:gt")
    val delta = 10.0.pow(points)
    return (it * delta).toInt() > (other * delta).toInt() // todo
}
