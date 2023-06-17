package sp.kx.math.measure

import sp.kx.math.unsafe.toString
import java.util.Locale
import kotlin.time.Duration
import kotlin.time.DurationUnit

/**
 * Usage:
 * ```
 * val foo = intervalOf(a = 2.minutes, b = 5.minutes)
 * assertEquals("{120.0s..300.0s}", foo.toString(points = 1))
 * ```
 * @return Receiver's [Interval.a] and [Interval.b] durations in formatted form.
 * @param durationUnit Used to refine the measure.
 * @param points The number of decimal places that each coordinate will have.
 * @param locale To apply during formatting. Default is [Locale.US].
 * @throws IllegalStateException if [points] count is negative.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun Interval<Duration>.toString(
    durationUnit: DurationUnit = DurationUnit.SECONDS,
    points: Int,
    locale: Locale = Locale.US,
): String {
    if (points < 0) error("Points count is negative!")
    return toString(interval = this, points = points, durationUnit = durationUnit, locale = locale)
}

/**
 * Usage:
 * ```
 * val foo = intervalOf(a = 1.minutes, b = 3.minutes)
 * assertEquals(2.minutes, foo.diff())
 *
 *       * a     * b
 *
 *   +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The difference between the extreme [Interval.b] and [Interval.a] values of durations.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun Interval<Duration>.diff(): Duration {
    return b - a
}
