package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset
import sp.kx.math.foundation.entity.geometry.Point
import sp.kx.math.foundation.entity.geometry.Vector

fun Vector.isEmpty(epsilon: Double): Boolean {
    return start.isSame(finish, epsilon = epsilon)
}

fun Vector.getAngle(): Double {
    return getAngle(start = start, finish = finish)
}

fun Vector.updated(
    dX: Double,
    dY: Double
): Vector {
    return vectorOf(
        start = start.updated(dX = dX, dY = dY),
        finish = finish.updated(dX = dX, dY = dY)
    )
}

fun Vector.updated(offset: Offset): Vector {
    return updated(dX = offset.dX, dY = offset.dY)
}

fun Vector.getDistance(): Double {
    return getDistance(start = start, finish = finish)
}

fun Vector.getShortest(target: Point): Double {
    return getShortest(
        start = start,
        finish = finish,
        target = target
    )
}

fun Vector.getPerpendicular(target: Point): Point {
    return getPerpendicular(
        a = target,
        b = start,
        c = finish
    )
}

fun Vector.getIntersectionPointOrNull(that: Vector): Point? {
    return getIntersectionPointOrNull(
        a = this.start,
        b = this.finish,
        c = that.start,
        d = that.finish
    )
}
