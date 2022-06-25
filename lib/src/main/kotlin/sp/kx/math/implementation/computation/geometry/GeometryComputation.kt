package sp.kx.math.implementation.computation.geometry

import sp.kx.math.foundation.entity.geometry.Point
import sp.kx.math.implementation.entity.geometry.pointOf
import kotlin.math.absoluteValue

fun getAngle(startX: Double, startY: Double, finishX: Double, finishY: Double): Double {
    return kotlin.math.atan2(y = finishY - startY, x = finishX - startX)
}

fun getDistance(
    xStart: Double,
    yStart: Double,
    xFinish: Double,
    yFinish: Double
): Double {
    val dX = xFinish - xStart
    val dY = yFinish - yStart
    return kotlin.math.sqrt(dY * dY + dX * dX)
}

fun getShortest(
    xStart: Double,
    yStart: Double,
    xFinish: Double,
    yFinish: Double,
    xTarget: Double,
    yTarget: Double
): Double {
    val dX = xFinish - xStart
    val dY = yFinish - yStart
    val d = kotlin.math.sqrt(dY * dY + dX * dX)
    val dS = kotlin.math.sqrt((yStart - yTarget) * (yStart - yTarget) + (xStart - xTarget) * (xStart - xTarget))
    val dF = kotlin.math.sqrt((yFinish - yTarget) * (yFinish - yTarget) + (xFinish - xTarget) * (xFinish - xTarget))
    val shortest = (dY * xTarget - dX * yTarget + xFinish * yStart - yFinish * xStart).absoluteValue / d
    if (kotlin.math.sqrt(dS * dS - shortest * shortest) > d) return dF
    if (kotlin.math.sqrt(dF * dF - shortest * shortest) > d) return dS
    return shortest
}

fun getIntersectionPointOrNull(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
    cX: Double,
    cY: Double,
    dX: Double,
    dY: Double
): Point? {
    val iX: Double
    val a1 = (aY - bY) / (aX - bX)
    val b1 = aY - a1 * aX
    val a2 = (cY - dY) / (cX - dX)
    val b2 = cY - a2 * cX
    if (aX == bX) {
        if (cX == dX) {
            if (aY == cY) return pointOf(x = aX, y = aY)
            return null
        }
        iX = aX
    } else if (cX == dX) {
        iX = cX
    } else {
        iX = (b2 - b1) / (a1 - a2)
    }
    return pointOf(
        x = iX,
        y = a2 * aX + b2
    )
}

fun getPerpendicular(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
    cX: Double,
    cY: Double
): Point {
    if (bX == cX) return pointOf(x = bX, y = aY)
    if (bY == cY) return pointOf(x = aX, y = bY)
    val b = (bY * cX - cY * bX) / (cX - bX)
    val k = (bY - b) / bX
    val kH = -1 / k
    val bH = aY - kH * aX
    val hX = (b - bH) / (kH - k)
    return pointOf(
        x = hX,
        y = k * hX + b
    )
}
