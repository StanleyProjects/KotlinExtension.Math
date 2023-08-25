package sp.kx.math.measure

/**
 * A mutable implementation of the [Deviation] type.
 *
 * Usage:
 * ```
 * val deviation = MutableDeviation(actual = 3.0, expected = 2.0)
 * deviation.actual = 2.0
 * deviation.expected = 3.0
 * ```
 * @param T The type to compare values.
 * @property actual Actual value.
 * @property expected Expected value.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
class MutableDeviation<T : Comparable<T>>(
    override var actual: T,
    override var expected: T,
) : Deviation<T> {
    /**
     * Sets [expected] value to [actual] variable.
     *
     * Usage:
     * ```
     * val deviation = MutableDeviation(actual = 1.0, expected = 2.0)
     * assertNotEquals(deviation.actual, deviation.expected)
     * assertEquals(deviation.actual, 1.0)
     * assertEquals(deviation.expected, 2.0)
     * deviation.commit()
     * assertEquals(deviation.actual, deviation.expected)
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.6.0
     */
    fun commit() {
        actual = expected
    }
}
