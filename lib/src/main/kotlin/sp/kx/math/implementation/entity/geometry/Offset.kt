package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset
import java.util.Locale

private data class OffsetImpl(
    override val dX: Double,
    override val dY: Double,
) : Offset {
    override fun toString(): String {
        val fX = String.format(Locale.US, "%.2f", dX)
        val fY = String.format(Locale.US, "%.2f", dY)
        return "{dX:$fX,dY:$fY}"
    }
}

/**
 * @return An instance of [Offset] built from the [Double] values [dX] and [dY].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
fun offsetOf(
    dX: Double,
    dY: Double,
): Offset {
    return OffsetImpl(
        dX = dX,
        dY = dY,
    )
}
