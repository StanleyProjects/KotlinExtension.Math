package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Point
import java.util.Locale

private data class PointImpl(
    override val x: Double,
    override val y: Double
) : Point {
    override fun toString(): String {
        val fX = String.format(Locale.US, "%.2f", x)
        val fY = String.format(Locale.US, "%.2f", y)
        return "{x:$fX,y:$fY}"
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
