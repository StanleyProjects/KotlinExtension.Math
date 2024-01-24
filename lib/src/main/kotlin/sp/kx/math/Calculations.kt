package sp.kx.math

import sp.kx.math.unsafe.eq
import kotlin.math.pow

/**
 * Usage:
 * ```
 * val a = pointOf(x = 2, y = 3)
 * val b = pointOf(x = 1, y = 1)
 * val c = pointOf(x = 3, y = 1)
 * val p = getPerpendicular(
 *     aX = a.x,
 *     aY = a.y,
 *     bX = b.x,
 *     bY = b.y,
 *     cX = c.x,
 *     cY = c.y,
 * )
 * assertEquals(p.x, a.x)
 * assertEquals(p.y, b.y)
 * assertEquals(p.y, c.y)
 * assertEquals(p.x, 2)
 * assertEquals(p.y, 1)
 *
 *   ^
 *   |        a
 * 3 -       *
 *   |       |
 * 2 -       |
 *   |    b  |    c
 * 1 -   *---*---*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The point of intersection of the perpendicular dropped the [aX] and [aY] coordinates to the line described by the [bX], [bY] and [cX], [cY] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
@Suppress("LongParameterList")
fun getPerpendicular(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
    cX: Double,
    cY: Double,
): Point {
    if (bX == cX) return pointOf(x = bX, y = aY)
    val kY = (cY - bY) * (aX - bX) - (cX - bX) * (aY - bY)
    val kX = (cY - bY).pow(2) + (cX - bX).pow(2)
    val k = kY / kX
    return pointOf(
        x = aX - k * (cY - bY),
        y = aY + k * (cX - bX),
    )
}

/**
 * Usage:
 * ```
 * val vector = pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)
 * val target = pointOf(x = 2, y = 1)
 * val contains = contains(
 *     xStart = vector.start.x,
 *     yStart = vector.start.y,
 *     xFinish = vector.finish.x,
 *     yFinish = vector.finish.y,
 *     xTarget = target.x,
 *     yTarget = target.y,
 * )
 * assertTrue(contains)
 *
 *   ^
 *   |
 * 2 -
 *   |    s   t   f
 * 1 -   *---*---*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return Returns `true` if the point by coordinates [[xTarget], [yTarget]] lies on the segment by coordinates [[xStart], [yStart]] and [[xFinish], [yFinish]] or `false` otherwise.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
@Suppress("LongParameterList")
fun contains(
    xStart: Double,
    yStart: Double,
    xFinish: Double,
    yFinish: Double,
    xTarget: Double,
    yTarget: Double,
): Boolean {
    val dSF = distanceOf(aX = xStart, aY = yStart, bX = xFinish, bY = yFinish)
    val dST = distanceOf(aX = xStart, aY = yStart, bX = xTarget, bY = yTarget)
    val dFT = distanceOf(aX = xFinish, aY = yFinish, bX = xTarget, bY = yTarget)
    return eq(it = dSF, other = dST + dFT, points = 12)
}

/**
 * The function calculates the shortest distance from point to segment.
 * It is up to the segment, and not the length of the perpendicular to the straight line!
 *
 * Usage:
 * ```
 * val a = pointOf(x = 2, y = 3)
 * val b = pointOf(x = 1, y = 1)
 * val c = pointOf(x = 3, y = 1)
 * val value = getShortest(
 *     xStart = b.x,
 *     yStart = b.y,
 *     xFinish = c.x,
 *     yFinish = c.y,
 *     xTarget = a.x,
 *     yTarget = a.y,
 * )
 * assertEquals(2.0, value)
 *
 *   ^
 *   |        a
 * 3 -       *
 *   |
 * 2 -
 *   |    b       c
 * 1 -   *-------*
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The shortest distance from the coordinates [xTarget] and [yTarget] to the segment described by the coordinates [xStart], [yStart] and [xFinish], [yFinish].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.2
 */
@Suppress("LongParameterList")
fun getShortestDistance(
    xStart: Double,
    yStart: Double,
    xFinish: Double,
    yFinish: Double,
    xTarget: Double,
    yTarget: Double,
): Double {
    val p = getPerpendicular(
        aX = xTarget,
        aY = yTarget,
        bX = xStart,
        bY = yStart,
        cX = xFinish,
        cY = yFinish,
    )
    val contains = contains(
        xStart = xStart,
        yStart = yStart,
        xFinish = xFinish,
        yFinish = yFinish,
        xTarget = p.x,
        yTarget = p.y,
    )
    if (contains) return distanceOf(aX = xTarget, aY = yTarget, bX = p.x, bY = p.y)
    return kotlin.math.min(
        distanceOf(aX = xStart, aY = yStart, bX = xTarget, bY = yTarget),
        distanceOf(aX = xFinish, aY = yFinish, bX = xTarget, bY = yTarget),
    )
}

@Suppress("LongParameterList")
fun getShortestPoint(
    xStart: Double,
    yStart: Double,
    xFinish: Double,
    yFinish: Double,
    xTarget: Double,
    yTarget: Double,
): Point {
    val perpendicular = getPerpendicular(
        aX = xTarget,
        aY = yTarget,
        bX = xStart,
        bY = yStart,
        cX = xFinish,
        cY = yFinish,
    )
    val contains = contains(
        xStart = xStart,
        yStart = yStart,
        xFinish = xFinish,
        yFinish = yFinish,
        xTarget = perpendicular.x,
        yTarget = perpendicular.y,
    )
    if (contains) return perpendicular
    val dS = distanceOf(aX = xStart, aY = yStart, bX = xTarget, bY = yTarget)
    val dF = distanceOf(aX = xFinish, aY = yFinish, bX = xTarget, bY = yTarget)
    return if (dS < dF) pointOf(x = xStart, y = yStart) else pointOf(x = xFinish, y = yFinish)
}

/**
 * A line's steepness is measured by the absolute value of its slope.
 * The larger the value is, the steeper the line.
 * Given a slope, it is possible to determine the direction of the line that a slope describes based on its sign and value.
 *
 * Usage:
 * ```
 * val a = pointOf(x = 1, y = 1)
 * val b = pointOf(x = 3, y = 2)
 * val value = getSlope(
 *     aX = a.x,
 *     aY = a.y,
 *     bX = b.x,
 *     bY = b.y,
 * )
 * assertEquals(0.5, value)
 *
 *   ^
 *   |            b
 * 2 -           *
 *   |    a
 * 1 -   *
 *   |
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special cases:
 * ```
 * val a = pointOf(x = 1, y = 0)
 * val b = pointOf(x = 3, y = 0)
 * check(a.x != b.x)
 * check(a.y == b.y)
 * val value = getSlope(
 *     aX = a.x,
 *     aY = a.y,
 *     bX = b.x,
 *     bY = b.y,
 * )
 * assertEquals(0.0, actual)
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 0)
 * check(a.x == b.x)
 * check(a.y != b.y)
 * val value = getSlope(
 *     aX = a.x,
 *     aY = a.y,
 *     bX = b.x,
 *     bY = b.y,
 * )
 * assertTrue(value.isInfinite())
 * ```
 * ```
 * val a = pointOf(x = 1, y = 3)
 * val b = pointOf(x = 1, y = 3)
 * check(a == b)
 * val value = getSlope(
 *     aX = a.x,
 *     aY = a.y,
 *     bX = b.x,
 *     bY = b.y,
 * )
 * assertTrue(value.isNaN())
 * ```
 * @return A number that measures the steepness and direction of the segment described by the coordinates [[aX], [aY]] and [[bX], [bY]].
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.7.3
 */
fun getSlope(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
): Double {
    return (bY - aY) / (bX - aX)
}

@Suppress("LongParameterList")
fun isParallel(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
    cX: Double,
    cY: Double,
    dX: Double,
    dY: Double,
): Boolean {
    val abx = bX - aX
    val cdx = dX - cX
    return if (abx == 0.0) cdx == 0.0 else (bY - aY) / abx == (dY - cY) / cdx
}

@Suppress("LongParameterList")
fun isCollinear(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
    cX: Double,
    cY: Double,
): Boolean {
    return (bY - aY) * (cX - bX) - (bX - aX) * (cY - bY) == 0.0
}

@Suppress("LongParameterList")
fun isCollinear(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
    cX: Double,
    cY: Double,
    dX: Double,
    dY: Double,
): Boolean {
    return (bY - aY) * (cX - bX) - (bX - aX) * (cY - bY) == 0.0 && (bY - aY) * (dX - bX) - (bX - aX) * (dY - bY) == 0.0
}

@Suppress("LongParameterList")
fun getIntersection(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
    cX: Double,
    cY: Double,
    dX: Double,
    dY: Double,
): Point? {
    val isCollinear = isCollinear(
        aX = aX,
        aY = aY,
        bX = bX,
        bY = bY,
        cX = cX,
        cY = cY,
        dX = dX,
        dY = dY,
    )
    if (isCollinear) return null
    val isParallel = isParallel(
        aX = aX,
        aY = aY,
        bX = bX,
        bY = bY,
        cX = cX,
        cY = cY,
        dX = dX,
        dY = dY,
    )
    if (isParallel) return null
    val xT = (aX * bY - aY * bX) * (cX - dX) - (aX - bX) * (cX * dY - cY * dX)
    val xB = (aX - bX) * (cY - dY) - (aY - bY) * (cX - dX)
    val yT = (aX * bY - aY * bX) * (cY - dY) - (aY - bY) * (cX * dY - cY * dX)
    val yB = (aX - bX) * (cY - dY) - (aY - bY) * (cX - dX)
    return pointOf(x = xT / xB, y = yT / yB)
}
