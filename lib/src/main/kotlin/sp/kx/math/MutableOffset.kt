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
