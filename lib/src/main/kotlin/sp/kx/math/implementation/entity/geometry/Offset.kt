package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset

private class OffsetImpl(
    override val dX: Double,
    override val dY: Double
) : Offset {
    override fun toString(): String {
        val fX = String.format("%.2f", dX)
        val fY = String.format("%.2f", dY)
        return "{dX:$fX,dY:$fY}"
    }

    override fun hashCode(): Int {
        return (dX + dY * 13).toInt()
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Offset -> dX == other.dX && dY == other.dY
            else -> false
        }
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
