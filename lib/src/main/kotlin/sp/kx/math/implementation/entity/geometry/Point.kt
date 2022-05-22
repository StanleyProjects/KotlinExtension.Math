package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Point

private class PointImpl(
    override val x: Double,
    override val y: Double
): Point {
    override fun toString(): String {
        val fX = String.format("%.2f", x)
        val fY = String.format("%.2f", y)
        return "{x:$fX,y:$fY}"
    }

    override fun hashCode(): Int {
        return (x + y * 13).toInt()
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Point -> x == other.x && y == other.y
            else -> false
        }
    }
}

fun pointOf(
    x: Double,
    y: Double
): Point {
    return PointImpl(
        x = x,
        y = y
    )
}

fun pointOf(
    x: Int,
    y: Int
): Point {
    return pointOf(x = x.toDouble(), y = y.toDouble())
}

fun Point.updated(
    dX: Double,
    dY: Double
): Point {
    return pointOf(
        x = x + dX,
        y = y + dY
    )
}
