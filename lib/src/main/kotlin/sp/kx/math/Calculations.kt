package sp.kx.math

fun distanceOf(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
): Double {
    val dX = bX - aX
    val dY = bY - aY
    return kotlin.math.sqrt(dY * dY + dX * dX)
}

fun angleOf(
    aX: Double,
    aY: Double,
    bX: Double,
    bY: Double,
): Double {
    return kotlin.math.atan2(y = bY - aY, x = bX - aX)
}
