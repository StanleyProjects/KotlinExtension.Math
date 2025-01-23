package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

/**
 * A mutable implementation of the [Offset] type.
 *
 * Usage:
 * ```
 * val offset = MutableOffset(dX = 3.0, dY = 2.0)
 * offset.dX = 2.0
 * offset.dY = 3.0
 * ```
 * @property dX Offset along the x-axis.
 * @property dY Offset along the y-axis.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.0
 */
class MutableOffset(
    override var dX: Double,
    override var dY: Double,
) : Offset {
    override fun toString(): String {
        return toString(offset = this, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Offset) return false
        return dX == other.dX && dY == other.dY
    }

    override fun hashCode(): Int {
        return Objects.hash(dX, dY)
    }

    /**
     * Method for setting both [dX] and [dY] offsets.
     *
     * Usage:
     * ```
     * val offset = MutableOffset(dX = 3.0, dY = 2.0)
     * offset.set(dX = 2.0, dY = 3.0)
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.3.0
     */
    fun set(
        dX: Double,
        dY: Double,
    ) {
        this.dX = dX
        this.dY = dY
    }

    /**
     * Method for setting both [dX] and [dY] offsets from [other] object.
     *
     * Usage:
     * ```
     * val offset = MutableOffset(dX = 3.0, dY = 2.0)
     * offset.set(offsetOf(dX = 2.0, dY = 3.0))
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.3.0
     */
    fun set(other: Offset) {
        dX = other.dX
        dY = other.dY
    }

    /**
     * Method for adding offset to [dX] and [dY] values.
     *
     * Usage:
     * ```
     * val offset = MutableOffset(dX = 1.0, dY = 2.0)
     * offset.add(dX = 2.0, dY = 1.0)
     * assertEquals(3.0, offset.dX)
     * assertEquals(3.0, offset.dY)
     * ```
     * @param dX This offset will be added to the [dX] value.
     * @param dY This offset will be added to the [dY] value.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    fun add(
        dX: Double,
        dY: Double,
    ) {
        this.dX += dX
        this.dY += dY
    }

    /**
     * Swaps [dX] and [dY] offsets.
     *
     * Usage:
     * ```
     * val offset = MutableOffset(dX = 3.0, dY = 2.0)
     * offset.swap()
     * assertEquals(2.0, offset.dX)
     * assertEquals(3.0, offset.dY)
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.3.0
     */
    fun swap() {
        val dX = dX
        this.dX = dY
        dY = dX
    }

    /**
     * Sets [dX] and [dY] values to `0.0`.
     *
     * Usage:
     * ```
     * val offset = MutableOffset(dX = 1.0, dY = 2.0)
     * offset.clear()
     * assertEquals(0.0, offset.dX)
     * assertEquals(0.0, offset.dX)
     * assertTrue(offset.isEmpty())
     * ```
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    fun clear() {
        dX = 0.0
        dY = 0.0
    }

    /**
     * Usage:
     * ```
     * val offset = MutableOffset(dX = 1.0, dY = 2.0)
     * offset *= 2
     * assertEquals(2.0, offset.dX)
     * assertEquals(4.0, offset.dY)
     * ```
     * @param value The [dX] and [dY] values will be multiplied by this value.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    operator fun timesAssign(value: Double) {
        dX *= value
        dY *= value
    }

    /**
     * Usage:
     * ```
     * val offset = MutableOffset(dX = 2.0, dY = 4.0)
     * offset /= 2
     * assertEquals(1.0, offset.dX)
     * assertEquals(2.0, offset.dY)
     * ```
     * @param value The [dX] and [dY] values will be divided by this value.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    operator fun divAssign(value: Double) {
        dX /= value
        dY /= value
    }

    /**
     * Usage:
     * ```
     * val offset = MutableOffset(dX = 4.0, dY = 3.0)
     * val other = offsetOf(dX = 2.0, dY = 1.0)
     * offset += other
     * assertEquals(6.0, offset.dX)
     * assertEquals(4.0, offset.dY)
     * ```
     * @param other These values will be added to the [dX] and [dY] values.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    operator fun plusAssign(other: Offset) {
        dX += other.dX
        dY += other.dY
    }

    /**
     * Usage:
     * ```
     * val offset = MutableOffset(dX = 4.0, dY = 3.0)
     * val other = offsetOf(dX = 2.0, dY = 1.0)
     * offset -= other
     * assertEquals(2.0, offset.dX)
     * assertEquals(2.0, offset.dY)
     * ```
     * @param other These values will be subtracted from the [dX] and [dY] values.
     * @author [Stanley Wintergreen](https://github.com/kepocnhh)
     * @since 0.8.1
     */
    operator fun minusAssign(other: Offset) {
        dX -= other.dX
        dY -= other.dY
    }
}

/**
 * Usage:
 * ```
 * val offset = offsetOf(dX = 3.0, dY = 2.0)
 *
 *   ^
 *   |
 * 3 -
 *   |
 * dY-   -   -   *
 *   |
 * 1 -           |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   dX  4
 * ```
 * @return An instance of [Offset] built from the [Double] values [dX] and [dY].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.3.0
 */
fun offsetOf(
    dX: Double,
    dY: Double,
): Offset {
    return MutableOffset(dX = dX, dY = dY)
}

/**
 * An integer version of the `offsetOf` method with [Double]s.
 *
 * Usage:
 * ```
 * val offset = offsetOf(dX = 3, dY = 2)
 *
 *   ^
 *   |
 * 3 -
 *   |
 * dY-   -   -   *
 *   |
 * 1 -           |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   dX  4
 * ```
 * @return An instance of [Offset] built from the [Double] values [dX] and [dY].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun offsetOf(
    dX: Int,
    dY: Int,
): Offset {
    return offsetOf(dX = dX.toDouble(), dY = dY.toDouble())
}

/**
 * Creates a new [MutableOffset] object with a copy of [this] receiver's values.
 *
 * Usage:
 * ```
 * val foo = offsetOf(dX = 3.0, dY = 2.0)
 * val bar = foo.mut()
 * bar.y = 3.0
 * ```
 *
 * ```
 *   ^
 *   |
 * 3 -   -   -   * bar
 *   |
 *dY -   -   -   * foo
 *   |
 * 1 -           |
 *   |
 * 0 +---|---|---|---|--->
 *   0   1   2   dX  4
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
fun Offset.mut(): MutableOffset {
    return MutableOffset(
        dX = dX,
        dY = dY,
    )
}
