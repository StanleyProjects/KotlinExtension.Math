package sp.kx.math

// todo doc
fun Vector.lt(
    xTarget: Double,
    yTarget: Double,
    minDistance: Double,
    points: Int,
): Boolean {
    return getShortestDistance(
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
    return getShortestDistance(target = target).lt(other = minDistance, points = points)
}

// todo doc
fun Iterable<Vector>.lt(
    xTarget: Double,
    yTarget: Double,
    minDistance: Double,
    points: Int,
): Boolean {
    for (vector in this) {
        val less = vector.getShortestDistance(
            xTarget = xTarget,
            yTarget = yTarget,
        ).lt(
            other = minDistance,
            points = points,
        )
        if (less) return true
    }
    return false
}

// todo doc
fun Iterable<Vector>.lt(
    target: Point,
    minDistance: Double,
    points: Int,
): Boolean {
    for (vector in this) {
        val less = vector.getShortestDistance(
            target = target,
        ).lt(
            other = minDistance,
            points = points,
        )
        if (less) return true
    }
    return false
}
