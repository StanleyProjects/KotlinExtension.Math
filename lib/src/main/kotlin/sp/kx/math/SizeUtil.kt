package sp.kx.math

import sp.kx.math.unsafe.eq
import sp.kx.math.unsafe.toString
import java.util.Locale

fun Size.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return toString(size = this, points = points, locale = locale)
}

fun Size.eq(other: Size, points: Int): Boolean {
    require(points > 0)
    return eq(it = this, other = other, points = points)
}

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

fun Size.isEmpty(points: Int): Boolean {
    require(points > 0)
    return eq(it = width, other = 0.0, points = points) && eq(it = height, other = 0.0, points = points)
}

fun Size.isEmpty(): Boolean {
    return width == 0.0 && height == 0.0
}
