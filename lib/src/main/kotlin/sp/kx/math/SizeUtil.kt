package sp.kx.math

fun Size.toOffset(): Offset {
    return offsetOf(
        dX = width,
        dY = height,
    )
}

fun Size.center(): Offset {
    return offsetOf(
        dX = width / 2,
        dY = height / 2,
    )
}
