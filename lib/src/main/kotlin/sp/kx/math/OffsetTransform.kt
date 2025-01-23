package sp.kx.math

fun offsetOf(
    dX: Double,
    dY: Double,
    transform: (Double) -> Double,
): Offset {
    return offsetOf(
        dX = transform(dX),
        dY = transform(dY),
    )
}

fun Offset.map(
    transform: (Double) -> Double,
): Offset {
    return offsetOf(
        dX = transform(dX),
        dY = transform(dY),
    )
}

fun offsetOf(
    dX: Double,
    dY: Double,
    multiplier: Double,
): Offset {
    return offsetOf(
        dX = dX * multiplier,
        dY = dY * multiplier,
    )
}
