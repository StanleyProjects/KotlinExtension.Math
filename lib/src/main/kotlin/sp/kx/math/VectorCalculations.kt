package sp.kx.math

fun Vector.getPerpendicular(
    target: Point,
): Point {
    return getPerpendicular(
        aX = target.x,
        aY = target.y,
        bX = start.x,
        bY = start.y,
        cX = finish.x,
        cY = finish.y,
    )
}

fun Vector.getShortest(
    target: Point,
): Double {
    return getShortest(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    )
}
