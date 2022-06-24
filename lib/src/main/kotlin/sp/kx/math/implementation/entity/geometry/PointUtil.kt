package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset
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

fun Point.updated(offset: Offset): Point {
    return updated(dX = offset.dX, dY = offset.dY)
}

fun Point.isSame(that: Point, epsilon: Double): Boolean {
    check(epsilon < 1.0)
    return abs(this.x - that.x) < epsilon && abs(this.y - that.y) < epsilon
}

fun getAngle(start: Point, finish: Point): Double {
    return getAngle(startX = start.x, startY = start.y, finishX = finish.x, finishY = finish.y)
}

fun getDistance(
    start: Point,
    finish: Point
): Double {
    return getDistance(xStart = start.x, yStart = start.y, xFinish = finish.x, yFinish = finish.y)
}

fun getShortest(
    start: Point,
    finish: Point,
    target: Point
): Double {
    return getShortest(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.x,
        xTarget = target.x,
        yTarget = target.y
    )
}

fun getIntersectionPointOrNull(
    a: Point,
    b: Point,
    c: Point,
    d: Point
): Point? {
    return getIntersectionPointOrNull(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
        cX = c.x,
        cY = c.y,
        dX = d.x,
        dY = d.y
    )
}

fun getPerpendicular(
    a: Point,
    b: Point,
    c: Point
): Point {
    return getPerpendicular(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
        cX = c.x,
        cY = c.y
    )
}
