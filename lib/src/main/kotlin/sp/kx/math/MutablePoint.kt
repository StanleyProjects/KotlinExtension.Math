package sp.kx.math

/**
 * A mutable implementation of the [Point] type.
 * @property x The coordinate of the x-axis.
 * @property y The coordinate of the y-axis.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
class MutablePoint(
    override var x: Double,
    override var y: Double,
) : Point

/**
 * @return An instance of [Point] built from the [Double] values [x] and [y].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
fun pointOf(
    x: Double,
    y: Double,
): Point {
    return MutablePoint(
        x = x,
        y = y,
    )
}
