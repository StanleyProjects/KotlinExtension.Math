package sp.kx.math.measure

/**
 * A type for convenient conversion of values with respect to the measurement system.
 *
 * Usage:
 * ```
 * val measure: Measure<Double, Double> = ...
 * assertEquals(2.0, measure.magnitude)
 * assertEquals(6.0, measure.transform(3.0))
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
interface Measure<T : Comparable<T>, U : Comparable<U>> {
    /**
     * This value will be used for transformations.
     */
    val magnitude: U

    /**
     * Transform [units] using [magnitude].
     */
    fun transform(units: T): U

    /**
     * Returns the original units by transformed [value].
     */
    fun units(value: U): T

    /**
     * Transform `1` unit using [magnitude].
     */
    fun value(): U
}
