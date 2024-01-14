package sp.kx.math

import kotlin.math.absoluteValue
import kotlin.math.pow

/**
 * Usage:
 * ```
 * val distance = distanceOf(aX = 1.0, aY = 1.0, bX = 3.0, bY = 1.0)
 * assertEquals(2.0, distance)
 *
 *   ^
 *   |
 * 2 -
 *   |
 * y -   * - - - *
 *   |
 * 0 +---|---|---|---|--->
 *   0   aX  2   bX  4
 * ```
 * @return Distance between point `a` with [aX] and [aY] coordinates and point `b` with [bX] and [bY] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
fun distanceOf(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
): Double {
    return kotlin.math.hypot(x = bX - aX, y = bY - aY)
}

/**
 * Special case of [distanceOf] method.
 *
 * Usage:
 * ```
 * val x = 3.0
 * val y = 0.0
 * val distance = distanceOf(x = x, y = y)
 * assertEquals(distanceOf(aX = 0.0, aY = 0.0, bX = x, bY = y), distance)
 * assertEquals(3.0, distance)
 *
 *   ^
 *   |
 * 0 *---|---|---*---|--->
 *   0   1   2   3   4
 * ```
 * @return Distance between point with x-coordinate `0` and y-coordinate `0` and point with [x] and [y] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun distanceOf(
    x: Double,
    y: Double,
): Double {
    return kotlin.math.hypot(x = x, y = y)
}

/**
 * Usage:
 * ```
 * val angle = angleOf(aX = 1.0, aY = 1.0, bX = 3.0, bY = 3.0)
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * bY-           *
 *   |         /
 * 2 -       /
 *   |     /
 * aY-   *
 *   |
 * 0 +---|---|---|---|--->
 *   0   aX  2   bX  4
 * ```
 * @return The angle in radians between the x-axis and the straight line
 * containing point `a` with [aX] and [aY] coordinates and point `b` with [bX] and [bY] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.2
 */
fun angleOf(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
): Double {
    return kotlin.math.atan2(y = bY - aY, x = bX - aX)
}

/**
 * Special case of [angleOf] method.
 *
 * Usage:
 * ```
 * val angle = angleOf(x = 3.0, y = 3.0)
 * assertEquals(angleOf(aX = 0.0, aY = 0.0, bX = 3.0, bY = 3.0), angle)
 * assertEquals(PI / 4, angle)
 *
 *   ^
 *   |
 * 3 -           *
 *   |         /
 * 2 -       /
 *   |     /
 * 1 -   /
 *   | /
 * 0 *---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The angle in radians between the x-axis and the straight line
 * containing point with x-coordinate `0` and y-coordinate `0` and point with [x] and [y] coordinates.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
fun angleOf(
    x: Double,
    y: Double,
): Double {
    return kotlin.math.atan2(y = y, x = x)
}

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
fun getPerpendicular(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
    cX: Double,
    cY: Double,
): Point {
    if (bX == cX) return pointOf(x = bX, y = aY)
//    if (bY == cY) return pointOf(x = aX, y = bY)
    // y = k * x + b
    // k = (y - b) / x
    val kY = (cY - bY) * (aX - bX) - (cX - bX) * (aY - bY)
    val kX = (cY - bY).pow(2) + (cX - bX).pow(2)
    val k = kY / kX
    return pointOf(
        x = aX - k * (cY - bY),
        y = aY + k * (cX - bX),
    )
//    val b = (bY * cX - bX * cY) / (cX - bX)
//    val k = (bY - b) / bX
//    val kH = -1 / k
//    val bH = aY - kH * aX
//    val hX = (b - bH) / (kH - k)
//    return pointOf(
//        x = hX,
//        y = k * hX + b,
//    )
}

// todo
private fun contains(
    xStart: Double,
    yStart: Double,
    xFinish: Double,
    yFinish: Double,
    xTarget: Double,
    yTarget: Double,
): Boolean {
    val d = distanceOf(aX = xStart, aY = yStart, bX = xFinish, bY = yFinish)
    val dS = distanceOf(aX = xStart, aY = yStart, bX = xTarget, bY = yTarget)
    val dF = distanceOf(aX = xFinish, aY = yFinish, bX = xTarget, bY = yTarget)
    // todo delta
//    val message = """
//        ---
//        xStart: $xStart
//        yStart: $yStart
//        xFinish: $xFinish
//        yFinish: $yFinish
//        xTarget: $xTarget
//        yTarget: $yTarget
//        ---
//        d: $d
//        dS: $dS
//        dF: $dF
//    """.trimIndent() // todo
//    error(message) // todo
//    return d.eq(other = dS + dF, points = 12) // todo
    return d == dS + dF
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
fun getShortest(
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
    // todo
    val dX = xFinish - xStart
    val dY = yFinish - yStart
    val d = kotlin.math.sqrt(dY * dY + dX * dX)
    val shortest = (dY * xTarget - dX * yTarget + xFinish * yStart - yFinish * xStart).absoluteValue / d
//    val dS = kotlin.math.sqrt((yStart - yTarget) * (yStart - yTarget) + (xStart - xTarget) * (xStart - xTarget))
    val dS = distanceOf(aX = xStart, aY = yStart, bX = xTarget, bY = yTarget)
//    val dF = kotlin.math.sqrt((yFinish - yTarget) * (yFinish - yTarget) + (xFinish - xTarget) * (xFinish - xTarget))
    val dF = distanceOf(aX = xFinish, aY = yFinish, bX = xTarget, bY = yTarget)
    val message = """
        ---
        xStart: $xStart
        yStart: $yStart
        xFinish: $xFinish
        yFinish: $yFinish
        xTarget: $xTarget
        yTarget: $yTarget
        ---
        shortest: $shortest
        dS: $dS
        dF: $dF
    """.trimIndent() // todo
//    if (xTarget == 3.0) error(message) // todo
    error(message) // todo
    if (kotlin.math.sqrt(dS * dS - shortest * shortest) > d) return dF
    if (kotlin.math.sqrt(dF * dF - shortest * shortest) > d) return dS
//    if (shortest > dS) return dS
//    if (shortest > dF) return dF
    return shortest
}
