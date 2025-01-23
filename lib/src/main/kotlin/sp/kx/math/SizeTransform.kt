package sp.kx.math

fun sizeOf(
    width: Double,
    height: Double,
    transform: (Double) -> Double,
): Size {
    return sizeOf(
        width = transform(width),
        height = transform(height),
    )
}

fun Size.map(
    transform: (Double) -> Double,
): Size {
    return sizeOf(
        width = transform(width),
        height = transform(height),
    )
}

fun sizeOf(
    width: Double,
    height: Double,
    multiplier: Double,
): Size {
    return sizeOf(
        width = width * multiplier,
        height = height * multiplier,
    )
}
