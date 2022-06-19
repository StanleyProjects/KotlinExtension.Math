package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Point
import sp.kx.math.foundation.entity.geometry.Vector

fun getAngle(startX: Double, startY: Double, finishX: Double, finishY: Double): Double {
    return kotlin.math.atan2(y = finishY - startY, x = finishX - startX)
}

fun getAngle(start: Point, finish: Point): Double {
    return getAngle(startX = start.x, startY = start.y, finishX = finish.x, finishY = finish.y)
}

fun Vector.getAngle(): Double {
    return getAngle(start = start, finish = finish)
}
