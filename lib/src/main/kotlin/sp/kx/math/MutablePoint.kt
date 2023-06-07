package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

/**
 * A mutable implementation of the [Point] type.
 *
 * Usage:
 * ```
 * val point = MutablePoint(x = 3.0, y = 2.0)
 * point.x = 2.0
 * point.y = 3.0
 * ```
 * @property x The coordinate of the x-axis.
 * @property y The coordinate of the y-axis.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
class MutablePoint(
    override var x: Double,
    override var y: Double,
) : Point {
    override fun toString(): String {
        return toString(point = this, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Point) return false
        return x == other.x && y == other.y
    }

    override fun hashCode(): Int {
        return Objects.hash(x, y)
    }

    /**
     * Method for setting both [x] and [y] coordinates.
     *
     * Usage:
     * ```
     * val point = MutablePoint(x = 3.0, y = 2.0)
     * point.set(x = 2.0, y = 3.0)
     *
     *   ^
     *   |
     * 3 -   -   * new
     *   |       |
     * y -   -   -   * old
     *   |
     * 1 -       |   |
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   x   4
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.2.2
     */
    fun set(
        x: Double,
        y: Double,
    ) {
        this.x = x
        this.y = y
    }

    /**
     * Method for setting both [x] and [y] coordinates from [other] object.
     *
     * Usage:
     * ```
     * val point = MutablePoint(x = 3.0, y = 2.0)
     * point.set(pointOf(x = 2.0, y = 3.0))
     *
     *   ^
     *   |
     * 3 -   -   * new
     *   |       |
     * y -   -   -   * old
     *   |
     * 1 -       |   |
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   x   4
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.3.0
     */
    fun set(other: Point) {
        x = other.x
        y = other.y
    }

    /**
     * Swaps [x] and [y] coordinates.
     *
     * Usage:
     * ```
     * val point = MutablePoint(x = 3.0, y = 2.0)
     * point.swap()
     *
     *   ^
     *   |
     * 3 -   -   * new
     *   |       |
     * y -   -   -   * old
     *   |
     * 1 -       |   |
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   x   4
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.2.2
     */
    fun swap() {
        val x = x
        this.x = y
        y = x
    }

    /**
     * Method for adding offset to [x] and [y] coordinates.
     *
     * Usage:
     * ```
     * val point = MutablePoint(x = 1.0, y = 2.0)
     * point.add(dX = 2.0, dY = 1.0)
     *
     *   ^
     *   |
     * y -   -   -   * new
     *   |
     * 2 -   * old   |
     *   |
     * 1 -   |       |
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   x   4
     * ```
     * @param dX This offset will be added to the [x]-coordinate.
     * @param dY This offset will be added to the [y]-coordinate.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.3.1
     */
    fun add(
        dX: Double,
        dY: Double,
    ) {
        x += dX
        y += dY
    }

    /**
     * Method for adding offset to [x] and [y] coordinates.
     *
     * Usage:
     * ```
     * val point = MutablePoint(x = 1.0, y = 2.0)
     * val offset = offsetOf(dX = 2.0, dY = 1.0)
     * point.add(offset)
     *
     *   ^
     *   |
     * y -   -   -   * new
     *   |
     * 2 -   * old   |
     *   |
     * 1 -   |       |
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   x   4
     * ```
     * @param offset The [Offset.dX] and [Offset.dY] from here will be added to the [x] and [y] coordinates respectively.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.3.1
     */
    fun add(offset: Offset) {
        x += offset.dX
        y += offset.dY
    }

    /**
     * The method changes the [x] and [y] coordinates of this point
     * to the coordinates of a point that lies at a distance [length].
     *
     * Usage:
     * ```
     * val point = MutablePoint(x = 1.0, y = 2.0)
     * point.move(length = 1.0, angle = kotlin.math.PI / 4)
     *
     *   ^
     *   |
     *   |             * new
     *   |           /
     *   |        /
     *   |     /  PI/4
     *   |   * old - - - - -
     *   |
     * 0 +------------------->
     *   0
     * ```
     *
     * Special cases:
     * ```
     * MutablePoint(x = 1.2, y = 3.4)
     *     .move(length = 1.0, angle = 0.0)
     *     .also { point: Point ->
     *         assertEquals(2.2, point.x, 0.01)
     *         assertEquals(3.4, point.y, 0.01)
     *     }
     * ```
     * ```
     * MutablePoint(x = 1.2, y = 3.4)
     *     .move(length = 1.0, angle = kotlin.math.PI / 2)
     *     .also { point: Point ->
     *         assertEquals(1.2, point.x, 0.01)
     *         assertEquals(4.4, point.y, 0.01)
     *     }
     * ```
     * ```
     * MutablePoint(x = 1.2, y = 3.4)
     *     .move(length = 1.0, angle = kotlin.math.PI)
     *     .also { point: Point ->
     *         assertEquals(0.2, point.x, 0.01)
     *         assertEquals(3.4, point.y, 0.01)
     *     }
     * ```
     * @param length The coordinates will be shifted by this distance (taking into account the rotation [angle]).
     * @param angle The angle of rotation around the [x] and [y] coordinates, given in radians.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.3.1
     */
    fun move(
        length: Double,
        angle: Double,
    ) {
        x += length * kotlin.math.cos(angle)
        y += length * kotlin.math.sin(angle)
    }

    /**
     * Special case of [move] method with zero angle.
     *
     * Usage:
     * ```
     * val point = MutablePoint(x = 1.0, y = 2.0)
     * point.move(length = 3.0)
     *
     *   ^
     *   |
     * y -
     *   |
     * 2 -   * old   * new
     *   |
     * 1 -   |       |
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   3   x
     * ```
     * @param length The [x]-coordinate will be shifted by this distance.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.3.1
     */
    fun move(length: Double) {
        x += length
    }
}

/**
 * Usage:
 * ```
 * val point = pointOf(x = 3.0, y = 2.0)
 *
 *   ^
 *   |
 * 3 -
 *   |
 * y -   -   -   *
 *   |
 * 1 -           |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
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
