package sp.kx.math.measure

/**
 * Usage:
 * ```
 * assertTrue(intervalOf(a = 1.minutes, b = 1.minutes))
 * assertFalse(intervalOf(a = 1.minutes, b = 3.minutes))
 * ```
 * @return `true` if the extreme [Interval.a] and [Interval.b] values of the durations are equal. `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun <T : Comparable<T>> Interval<T>.isEmpty(): Boolean {
    return a == b
}
