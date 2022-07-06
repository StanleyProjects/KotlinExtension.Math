package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset
import sp.kx.math.foundation.entity.geometry.Point

fun Point.updated(
    dX: Double,
    dY: Double
): Point {
    return pointOf(
        x = x + dX,
        y = y + dY
    )
}

fun Point.updated(offset: Offset): Point {
    return updated(dX = offset.dX, dY = offset.dY)
}

fun Point.moved(
    length: Double,
    direction: Double
): Point {
    return updated(
        dX = length * kotlin.math.cos(direction),
        dY = length * kotlin.math.sin(direction),
    )
}

fun Point.difference(that: Point): Offset {
    return offsetOf(
        dX = this.x - that.x,
        dY = this.y - that.y
    )
}
