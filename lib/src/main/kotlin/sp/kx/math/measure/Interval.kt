package sp.kx.math.measure

/**
 * Stores two comparable values. Convenient for 2D calculations. For example, when you need to describe a range.
 *
 * Usage:
 * ```
 * val interval: Interval<Double> = ...
 * assertEquals(1.0, interval.a)
 * assertEquals(3.0, interval.b)
 *
 *       * a     * b
 *
 *   +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
interface Interval<T : Comparable<T>> {
    /**
     * Start of interval value.
     */
    val a: T

    /**
     * End of interval value.
     */
    val b: T
}
