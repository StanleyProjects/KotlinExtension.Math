package sp.kx.math

fun distanceOf(
    a: Point,
    b: Point,
): Double {
    return distanceOf(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
    )
}

fun angleOf(
    a: Point,
    b: Point,
): Double {
    return angleOf(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
    )
}

@Suppress("MagicNumber")
fun centerOf(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
): Point {
    return pointOf(
        x = aX + (bX - aX) * 0.5,
        y = aY + (bY - aY) * 0.5,
    )
}

fun centerOf(
    a: Point,
    b: Point,
): Point {
    return centerOf(
        aX = a.x,
        aY = a.y,
        bX = b.x,
        bY = b.y,
    )
}
