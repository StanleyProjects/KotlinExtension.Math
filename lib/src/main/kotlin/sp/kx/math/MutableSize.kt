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

    /**
     * Method for setting both [width] and [height] values.
     *
     * Usage:
     * ```
     * val size = MutableSize(width = 3.0, height = 2.0)
     * assertEquals(size.width, 3.0)
     * assertEquals(size.height, 2.0)
     * size.set(width = 2.0, height = 3.0)
     * assertEquals(size.width, 2.0)
     * assertEquals(size.height, 3.0)
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.6.0
     */
    fun set(
        width: Double,
        height: Double,
    ) {
        this.width = width
        this.height = height
    }

    /**
     * Method for setting both [width] and [height] values from [other] object.
     *
     * Usage:
     * ```
     * val size = MutableSize(width = 3.0, height = 2.0)
     * assertEquals(size.width, 3.0)
     * assertEquals(size.height, 2.0)
     * size.set(sizeOf(width = 2.0, height = 3.0))
     * assertEquals(size.width, 2.0)
     * assertEquals(size.height, 3.0)
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.6.0
     */
    fun set(other: Size) {
        width = other.width
        height = other.height
    }

    fun add(
        dX: Double,
        dY: Double,
    ) {
        width += dX
        height += dY
    }

    fun swap() {
        val width = width
        this.width = height
        height = width
    }

    fun clear() {
        width = 0.0
        height = 0.0
    }

    /**
     * Usage:
     * ```
     * val size = MutableSize(width = 1.0, height = 2.0)
     * size *= 2
     * assertEquals(2.0, size.width)
     * assertEquals(4.0, size.height)
     * ```
     * @param value The [width] and [height] values will be multiplied by this value.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    operator fun timesAssign(value: Double) {
        width *= value
        height *= value
    }

    /**
     * Usage:
     * ```
     * val size = MutableSize(width = 2.0, height = 4.0)
     * size /= 2
     * assertEquals(1.0, size.width)
     * assertEquals(2.0, size.height)
     * ```
     * @param value The [width] and [height] values will be divided by this value.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    operator fun divAssign(value: Double) {
        width /= value
        height /= value
    }

    /**
     * Usage:
     * ```
     * val size = MutableSize(width = 4.0, height = 3.0)
     * val offset = offsetOf(dX = 2.0, dY = 1.0)
     * size += offset
     * assertEquals(6.0, size.width)
     * assertEquals(4.0, size.height)
     * ```
     * @param offset This values will be added to the [width] and [height] values.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    operator fun plusAssign(offset: Offset) {
        width += offset.dX
        height += offset.dY
    }

    /**
     * Usage:
     * ```
     * val size = MutableSize(width = 4.0, height = 3.0)
     * val offset = offsetOf(dX = 2.0, dY = 1.0)
     * size -= offset
     * assertEquals(2.0, size.width)
     * assertEquals(2.0, size.height)
     * ```
     * @param offset This values will be subtracted from the [width] and [height] values.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    operator fun minusAssign(offset: Offset) {
        width -= offset.dX
        height -= offset.dY
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

/**
 * An integer version of the `sizeOf` method with [Double]s.
 *
 * Usage:
 * ```
 * val size = sizeOf(width = 2, height = 1)
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
 * @return An instance of [Size] built from the [Int] values [width] and [height].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.6.0
 */
fun sizeOf(
    width: Int,
    height: Int,
): Size {
    return MutableSize(
        width = width.toDouble(),
        height = height.toDouble(),
    )
}

/**
 * Creates a new [MutableSize] object with a copy of [this] receiver's values.
 *
 * Usage:
 * ```
 * val foo = sizeOf(width = 3.0, height = 2.0)
 * val bar = foo.mut()
 * bar.y = 3.0
 * ```
 *
 * ```
 *   ^
 *   |
 * 3 -   -   -   * bar
 *   |
 * h -   -   -   * foo
 *   |
 * 1 -           |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   w   4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
fun Size.mut(): MutableSize {
    return MutableSize(width = width, height = height)
}
