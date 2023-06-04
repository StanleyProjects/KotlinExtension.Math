package sp.kx.math

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
) : Offset

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
