package sp.kx.math

import sp.kx.math.measure.Measure

operator fun Size.times(value: Double): Size {
    return sizeOf(
        width = width * value,
        height = height * value,
    )
}

operator fun Size.div(value: Double): Size {
    return sizeOf(
        width = width / value,
        height = height / value,
    )
}

operator fun Size.plus(other: Size): Size {
    return sizeOf(
        width = width + other.width,
        height = height + other.height,
    )
}

operator fun Size.plus(measure: Measure<Double, Double>): Size {
    return sizeOf(
        width = measure.transform(width),
        height = measure.transform(height),
    )
}

operator fun Size.minus(measure: Measure<Double, Double>): Size {
    return sizeOf(
        width = measure.units(width),
        height = measure.units(height),
    )
}
