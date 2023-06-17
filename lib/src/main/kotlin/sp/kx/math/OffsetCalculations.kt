package sp.kx.math

fun angleOf(offset: Offset): Double {
    return angleOf(
        x = offset.dX,
        y = offset.dY,
    )
}

fun distanceOf(offset: Offset): Double {
    return distanceOf(
        x = offset.dX,
        y = offset.dY,
    )
}
