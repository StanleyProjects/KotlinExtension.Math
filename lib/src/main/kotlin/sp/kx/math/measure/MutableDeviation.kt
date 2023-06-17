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
) : Deviation<T>
