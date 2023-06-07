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

operator fun Point.plus(finish: Point): Vector {
    return ImmutableVector(
        start = this,
        finish = finish,
    )
}

fun Point.toVector(
    finishX: Double,
    finishY: Double,
): Vector {
    return ImmutableVector(
        start = this,
        finish = pointOf(x = finishX, y = finishY),
    )
}
