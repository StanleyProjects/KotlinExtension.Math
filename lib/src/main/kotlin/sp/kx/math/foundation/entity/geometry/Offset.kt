package sp.kx.math.foundation.entity.geometry

/**
 * Stores two values. Convenient for 2D calculations. For example, when you need to shift all points on the plane.
 * @see sp.kx.math.implementation.entity.geometry.updated
 * @see sp.kx.math.implementation.entity.geometry.toVector
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
interface Offset {
    /**
     * Offset along the x-axis.
     */
    val dX: Double

    /**
     * Offset along the y-axis.
     */
    val dY: Double
}
