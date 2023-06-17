package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

/**
 * A mutable implementation of the [Size] type.
 *
 * Usage:
 * ```
 * val size = MutableSize(width = 3.0, height = 2.0)
 * size.dX = 2.0
 * size.dY = 3.0
 * ```
 * @property width Width size. Horizontal size. Parallel to the x-axis.
 * @property height Height size. Vertical size. Parallel to the y-axis.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
class MutableSize(
    override var width: Double,
    override var height: Double,
) : Size {
    override fun toString(): String {
        return toString(size = this, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Size) return false
        return width == other.width && height == other.height
    }

    override fun hashCode(): Int {
        return Objects.hash(width, height)
    }
}

/**
 * Usage:
 * ```
 * val size = sizeOf(width = 2.0, height = 1.0)
 * val foo = pointOf(1, 1)
 * val bar = pointOf(x = foo.x + size.width, y = foo.y + size.height)
 *
 *   ^
 *   |
 * 3 -
 *   |
 * 2 -            * bar
 *   |
 * 1 -   * foo
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return An instance of [Size] built from the [Double] values [width] and [height].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun sizeOf(
    width: Double,
    height: Double,
): Size {
    return MutableSize(
        width = width,
        height = height,
    )
}
