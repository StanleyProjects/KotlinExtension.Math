package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

internal class ImmutableVector(
    override val start: Point,
    override val finish: Point,
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
}

/**
 * Usage:
 * ```
 * val vector = vectorOf(
 *     startX = 1.0,
 *     startY = 2.0,
 *     finishX = 3.0,
 *     finishY = 3.0,
 * )
 *
 *   ^
 *   |
 * y -   -   -   * vector.finish
 *   |
 * 2 -   * vector.start
 *   |
 * 1 -   |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @return An instance of [Vector] built from the [Double] values.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.0
 */
fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = startX, y = startY),
        finish = pointOf(x = finishX, y = finishY),
    )
}

/**
 * Usage:
 * ```
 * val vector = vectorOf(
 *     startX = 1.0,
 *     startY = 2.0,
 *     finish = pointOf(x = 3.0, y = 3.0),
 * )
 *
 *   ^
 *   |
 * y -   -   -   * vector.finish
 *   |
 * 2 -   * vector.start
 *   |
 * 1 -   |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @param startX This value will become the x-coordinate of the [Vector.start] point.
 * @param startY This value will become the y-coordinate of the [Vector.start] point.
 * @param finish This [Point] will become the [Vector.finish] point.
 * @return An instance of [Vector] built from the [Double] values and [Point].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.0
 */
fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
): Vector {
    return ImmutableVector(
        start = pointOf(x = startX, y = startY),
        finish = finish,
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0)
 * val bar = pointOf(x = 3.0, y = 3.0)
 * val vector = foo + bar
 *
 *   ^
 *   |
 * y -   -   -   * vector.finish
 *   |
 * 2 -   * vector.start
 *   |
 * 1 -   |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @receiver This [Point] will become the [Vector.start] point.
 * @param finish This [Point] will become the [Vector.finish] point.
 * @return An instance of [Vector] built from the two [Point]s passed to the method.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.0
 */
operator fun Point.plus(finish: Point): Vector {
    return ImmutableVector(
        start = this,
        finish = finish,
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(x = 1.0, y = 2.0)
 * val vector = foo.toVector(x = 3.0, y = 3.0)
 *
 *   ^
 *   |
 * y -   -   -   * vector.finish
 *   |
 * 2 -   * vector.start
 *   |
 * 1 -   |       |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   x   4
 * ```
 * @receiver This [Point] will become the [Vector.start] point.
 * @param x This value will become the x-coordinate of the [Vector.finish] point.
 * @param y This value will become the y-coordinate of the [Vector.finish] point.
 * @return An instance of [Vector] built from the [Double] values and [Point].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.0
 */
fun Point.toVector(
    x: Double,
    y: Double,
): Vector {
    return ImmutableVector(
        start = this,
        finish = pointOf(x = x, y = y),
    )
}

/**
 * Usage:
 * ```
 * val offset = offsetOf(2.0, 0.0)
 * val vector = pointOf(1, 1).toVector(offset = offset)
 *
 *   ^
 *   |
 * 2 -
 *   |    a       b
 * 1 -   * - - - >
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @receiver This [Point] will become the [Vector.start] point.
 * @param offset This values will be added to [this] receiver's [Point.x] and [Point.y] coordinates.
 * @return An instance of [Vector] built from the [Point] passed to the method and the [Point] constructed using the [offset].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.3
 */
fun Point.toVector(offset: Offset): Vector {
    return ImmutableVector(
        start = this,
        finish = this + offset,
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(0.0, 0.0)
 * val bar = pointOf(2.0, 0.0)
 * val offset = offsetOf(1.0, 1.0)
 * val vector = foo.toVector(finish = bar, offset = offset)
 *
 *   ^
 *   |
 * 2 -
 *   |    a       b
 * 1 -   * - - - >
 *   |
 * 0 x---|---x---|---|--->
 *   0   1   2   3   4
 * ```
 * @receiver This [Point] modified with an [offset] will become the [Vector.start] point.
 * @param finish This [Point] modified with an [offset] will become the [Vector.finish] point.
 * @param offset This values will be added to [this] receiver [Point] and [finish] point.
 * @return An instance of [Vector] built from [this] receiver [Point] and the [finish] point constructed using the [offset].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.3
 */
fun Point.toVector(finish: Point, offset: Offset): Vector {
    return ImmutableVector(
        start = this + offset,
        finish = finish + offset,
    )
}

/**
 * Usage:
 * ```
 * val foo = pointOf(1, 2)
 * val vector = vectorOf(start = foo, length = 1.0, angle = kotlin.math.PI / 4)
 *
 *   ^
 *   |
 *   |             *
 *   |           /
 *   |        /
 *   |     /  PI/4
 *   |   * foo - - - - -
 *   |
 * 0 +------------------->
 *   0
 * ```
 *
 * Special cases:
 * ```
 * val vector = vectorOf(start = pointOf(x = 1.2, y = 3.4), length = 1.0, angle = 0.0)
 * assertEquals(2.2, vector.finish.x, 0.01)
 * assertEquals(3.4, vector.finish.y, 0.01)
 * ```
 * ```
 * val vector = vectorOf(start = pointOf(x = 1.2, y = 3.4), length = 1.0, angle = kotlin.math.PI / 2)
 * assertEquals(1.2, vector.finish.x, 0.01)
 * assertEquals(4.4, vector.finish.y, 0.01)
 * ```
 * ```
 * val vector = vectorOf(start = pointOf(x = 1.2, y = 3.4), length = 1.0, angle = kotlin.math.PI)
 * assertEquals(0.2, vector.finish.x, 0.01)
 * assertEquals(3.4, vector.finish.y, 0.01)
 * ```
 * @param start This [Point] will become the [Vector.start] point.
 * @param length The coordinates of [start] will be shifted by this distance (taking into account the rotation [angle]).
 * @param angle The angle of rotation around the [start] coordinates, given in radians.
 * @return An instance of [Vector] built from [start] point and the [Point] constructed using the [length] and [angle].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.3
 */
fun vectorOf(
    start: Point,
    length: Double,
    angle: Double,
): Vector {
    return ImmutableVector(
        start = start,
        finish = start.moved(length = length, angle = angle),
    )
}

/**
 * Special case of [vectorOf] method with zero angle.
 *
 * Usage:
 * ```
 * val foo = pointOf(1, 1)
 * val vector = vectorOf(start = foo, length = 2.0)
 *
 *   ^
 *   |
 * 2 -
 *   |    a       b
 * 1 -   * - - - >
 *   |
 * 0 x---|---x---|---|--->
 *   0   1   2   3   4
 * ```
 * @param start This [Point] will become the [Vector.start] point.
 * @param length The x-coordinate of [start] will be shifted by this distance.
 * @return An instance of [Vector] built from [start] point and the [Point] constructed using the [length].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.3
 */
fun vectorOf(
    start: Point,
    length: Double,
): Vector {
    return ImmutableVector(
        start = start,
        finish = start.moved(length = length),
    )
}
