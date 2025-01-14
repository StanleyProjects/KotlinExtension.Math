package sp.kx.math

// todo doc
fun Vector.lt(
    xTarget: Double,
    yTarget: Double,
    minDistance: Double,
    points: Int,
): Boolean {
    return getShortestDistance(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = xTarget,
        yTarget = yTarget,
    ).lt(other = minDistance, points = points)
}

// todo doc
fun Vector.lt(
    target: Point,
    minDistance: Double,
    points: Int,
): Boolean {
    return getShortestDistance(
        xStart = start.x,
        yStart = start.y,
        xFinish = finish.x,
        yFinish = finish.y,
        xTarget = target.x,
        yTarget = target.y,
    ).lt(other = minDistance, points = points)
}

// todo doc
fun Iterable<Vector>.lt(
    xTarget: Double,
    yTarget: Double,
    minDistance: Double,
    points: Int,
): Boolean {
    return any { vector ->
        getShortestDistance(
            xStart = vector.start.x,
            yStart = vector.start.y,
            xFinish = vector.finish.x,
            yFinish = vector.finish.y,
            xTarget = xTarget,
            yTarget = yTarget,
        ).lt(
            other = minDistance,
            points = points,
        )
    }
}

// todo doc
fun Iterable<Vector>.lt(
    target: Point,
    minDistance: Double,
    points: Int,
): Boolean {
    return any { vector ->
        getShortestDistance(
            xStart = vector.start.x,
            yStart = vector.start.y,
            xFinish = vector.finish.x,
            yFinish = vector.finish.y,
            xTarget = target.x,
            yTarget = target.y,
        ).lt(
            other = minDistance,
            points = points,
        )
    }
}
