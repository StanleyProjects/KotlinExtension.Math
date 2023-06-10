package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

/**
 * A mutable implementation of the [Vector] type.
 *
 * Usage:
 * ```
 * val vector = MutableVector(
 *     start = MutablePoint(x = 1.2, y = 3.4),
 *     finish = MutablePoint(x = 5.6, y = 7.8),
 * )
 * vector.start.x = 2.0
 * vector.finish.y = 3.0
 * ```
 * @property start The [MutablePoint] from which the beginning of the [MutableVector] can be counted.
 * @property finish The [MutablePoint] up to which the direction of the [MutableVector] can be computed.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.0
 */
class MutableVector(
    override val start: MutablePoint,
    override val finish: MutablePoint,
) : Vector {
    override fun toString(): String {
        return toString(vector = this, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Vector) return false
        return start.x == other.start.x &&
            finish.x == other.finish.x && start.y == other.start.y && finish.y == other.finish.y
    }

    override fun hashCode(): Int {
        return Objects.hash(start.x, start.y, finish.x, finish.y)
    }

    /**
     * Method for setting both [start] and [finish] points.
     *
     * Usage:
     * ```
     * val vector = MutableVector(start = MutablePoint(1.0, 1.0), finish = MutablePoint(3.0, 1.0))
     * vector.set(start = pointOf(1.0, 2.0), finish = pointOf(3.0, 2.0))
     *
     *   ^
     *   |
     * 3 -
     *   |
     * 2 -   * - - - > new
     *   |
     * 1 -   * - - - > old
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   3   4
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.4.1
     */
    fun set(
        start: Point,
        finish: Point,
    ) {
        this.start.set(start)
        this.finish.set(finish)
    }

    /**
     * Method for setting both [start] and [finish] points from [other] object.
     *
     * Usage:
     * ```
     * val vector = MutableVector(start = MutablePoint(1.0, 1.0), finish = MutablePoint(3.0, 1.0))
     * vector.set(pointOf(1.0, 2.0) + pointOf(3.0, 2.0))
     *
     *   ^
     *   |
     * 3 -
     *   |
     * 2 -   * - - - > new
     *   |
     * 1 -   * - - - > old
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   3   4
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.4.1
     */
    fun set(other: Vector) {
        this.start.set(other.start)
        this.finish.set(other.finish)
    }

    /**
     * Swaps [start] and [finish] points.
     *
     * Usage:
     * ```
     * val vector = MutableVector(start = MutablePoint(1.0, 1.0), finish = MutablePoint(3.0, 1.0))
     * vector.swap()
     * ```
     * ```
     *   ^
     *   |
     * 2 -
     *   |
     * 1 -   * - - - > old
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   3   4
     * ```
     * ```
     *   ^
     *   |
     * 2 -
     *   |
     * 1 -   < - - - * new
     *   |
     * 0 +---|---|---|---|--->
     *   0   1   2   3   4
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.4.1
     */
    fun swap() {
        val x = start.x
        val y = start.y
        start.set(finish)
        finish.set(x = x, y = y)
    }
}
