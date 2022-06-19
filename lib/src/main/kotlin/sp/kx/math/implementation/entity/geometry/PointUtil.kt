package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Point
import kotlin.math.abs

fun Point.updated(
    dX: Double,
    dY: Double
): Point {
    return pointOf(
        x = x + dX,
        y = y + dY
    )
}

fun Point.isSame(that: Point, epsilon: Double): Boolean {
    check(epsilon < 1.0)
    return abs(this.x - that.x) < epsilon && abs(this.y - that.y) < epsilon
}
