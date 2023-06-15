package sp.kx.math.measure

import sp.kx.math.unsafe.toString
import java.util.Locale
import kotlin.time.Duration
import kotlin.time.DurationUnit

fun Interval<Duration>.toString(
    durationUnit: DurationUnit = DurationUnit.SECONDS,
    points: Int,
    locale: Locale = Locale.US,
): String {
    return toString(interval = this, points = points, durationUnit = durationUnit, locale = locale)
}

fun Interval<Duration>.diff(): Duration {
    return b - a
}
