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

fun Point.toVector(offset: Offset): Vector {
    return ImmutableVector(
        start = this,
        finish = this + offset,
    )
}

fun Point.toVector(finish: Point, offset: Offset): Vector {
    return ImmutableVector(
        start = this + offset,
        finish = finish + offset,
    )
}

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

fun vectorOf(
    start: Point,
    length: Double,
): Vector {
    return ImmutableVector(
        start = start,
        finish = start.moved(length = length),
    )
}
