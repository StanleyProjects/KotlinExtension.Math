package sp.kx.math

fun getShortestPoint(
    start: Point,
    xFinish: Double,
    yFinish: Double,
    xTarget: Double,
    yTarget: Double,
): Point {
    return getShortestPoint(
        xStart = start.x,
        yStart = start.y,
        xFinish = xFinish,
        yFinish = yFinish,
        xTarget = xTarget,
        yTarget = yTarget,
    )
}

fun getShortestPoint(
    start: Point,
    finish: Point,
    xTarget: Double,
    yTarget: Double,
): Point {
    return getShortestPoint(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = xTarget,
        yTarget = yTarget,
    )
}

fun getShortestPoint(
    xStart: Double,
    yStart: Double,
    xFinish: Double,
    yFinish: Double,
    target: Point,
): Point {
    return getShortestPoint(
        xStart = xStart,
        yStart = yStart,
        xFinish = xFinish,
        yFinish = yFinish,
        xTarget = target.x,
        yTarget = target.y,
    )
}

fun getShortestPoint(
    start: Point,
    finish: Point,
    target: Point,
): Point {
    return getShortestPoint(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    )
}
