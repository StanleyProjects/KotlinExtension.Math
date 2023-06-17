package sp.kx.math.measure

import sp.kx.math.unsafe.eq
import java.util.concurrent.TimeUnit

/**
 * Determines if the speed is `0.0` in [TimeUnit].
 *
 * Usage:
 * ```
 * assertTrue(speedOf(0.01).isEmpty(points = 1))
 * assertFalse(speedOf(0.01).isEmpty(points = 2))
 * assertFalse(speedOf(0.01, TimeUnit.SECONDS).isEmpty(points = 1, timeUnit = TimeUnit.MINUTES))
 * assertTrue(speedOf(0.01, TimeUnit.SECONDS).isEmpty(points = 1, timeUnit = TimeUnit.SECONDS))
 * ```
 * @param points The number of decimal places to compare coordinates with.
 * @param timeUnit In these [TimeUnit], it is calculated that the speed is `0.0` or higher. Default is [TimeUnit.NANOSECONDS].
 * @return `true` if magnitude is `0.0` to [points] decimal places; `false` otherwise
 * @throws IllegalArgumentException if [points] lower than 1.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun Speed.isEmpty(points: Int, timeUnit: TimeUnit = TimeUnit.NANOSECONDS): Boolean {
    require(points > 0)
    return eq(it = per(timeUnit), other = 0.0, points = points)
}

/**
 * Usage:
 * ```
 * assertTrue(speedOf(0.0).isEmpty())
 * assertFalse(speedOf(1.2).isEmpty())
 * ```
 * @return `true` if magnitude is `0.0`; `false` otherwise
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun Speed.isEmpty(): Boolean {
    return per(TimeUnit.NANOSECONDS) == 0.0
}
