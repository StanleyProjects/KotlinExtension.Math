package sp.kx.math

import sp.kx.math.measure.Measure

// todo doc
operator fun Size.times(value: Double): Size {
    return sizeOf(
        width = width * value,
        height = height * value,
    )
}

// todo doc
operator fun Size.div(value: Double): Size {
    return sizeOf(
        width = width / value,
        height = height / value,
    )
}

// todo doc
operator fun Size.times(measure: Measure<Double, Double>): Size {
    return sizeOf(
        width = measure.transform(width),
        height = measure.transform(height),
    )
}

// todo doc
operator fun Size.div(measure: Measure<Double, Double>): Size {
    return sizeOf(
        width = measure.units(width),
        height = measure.units(height),
    )
}

// todo doc
operator fun Size.plus(other: Size): Size {
    return sizeOf(
        width = width + other.width,
        height = height + other.height,
    )
}

// todo doc
operator fun Size.minus(other: Size): Size {
    return sizeOf(
        width = width - other.width,
        height = height - other.height,
    )
}
