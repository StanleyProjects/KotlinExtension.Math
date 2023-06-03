package sp.kx.math

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
        return mapOf(
            "x" to String.format(Locale.US, "%.2f", x),
            "y" to String.format(Locale.US, "%.2f", y),
        ).toList().joinToString(prefix = "{", separator = ", ", postfix = "}") { (k, v) ->
            "$k: $v"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Point) return false
        return x == other.x && y == other.y
    }

    override fun hashCode(): Int {
        return Objects.hash(x, y)
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
