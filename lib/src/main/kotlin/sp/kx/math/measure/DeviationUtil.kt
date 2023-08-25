package sp.kx.math.measure

/**
 * Usage:
 * ```
 * val deviation = MutableDeviation(actual = 3.0, expected = 1.0)
 * assertEquals(2.0, deviation.diff())
 *
 *         e       a
 *       *       *
 *
 *   +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The difference between the [Deviation.actual] value and the [Deviation.expected] value.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
fun Deviation<Double>.diff(): Double {
    return actual - expected
}
