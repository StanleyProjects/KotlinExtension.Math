package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset

private data class OffsetImpl(
    override val dX: Double,
    override val dY: Double
) : Offset {
    override fun toString(): String {
        val fX = String.format("%.2f", dX)
        val fY = String.format("%.2f", dY)
        return "{dX:$fX,dY:$fY}"
    }
}

fun offsetOf(
    dX: Double,
    dY: Double
): Offset {
    return OffsetImpl(
        dX = dX,
        dY = dY
    )
}
