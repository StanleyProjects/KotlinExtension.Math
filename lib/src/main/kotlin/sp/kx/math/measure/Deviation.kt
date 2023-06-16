package sp.kx.math.measure

/**
 * Stores two comparable values. Convenient for calculations. It is possible to keep the current value close to the expected one.
 *
 * Usage:
 * ```
 * val deviation: Deviation<Double> = ...
 * if (deviation.actual != deviation.expected) {
 *     println("Value is not expected!")
 * }
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
interface Deviation<T : Comparable<T>> {
    /**
     * Actual value.
     */
    val actual: T

    /**
     * Expected value.
     */
    val expected: T
}
