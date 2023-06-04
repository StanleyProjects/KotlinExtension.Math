package sp.kx.math

import sp.kx.math.unsafe.eq
import sp.kx.math.unsafe.toString
import java.util.Locale

fun Offset.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return toString(offset = this, points = points, locale = locale)
}

fun Offset.eq(other: Offset, points: Int): Boolean {
    if (points < 0) error("Points count is negative!")
    return eq(it = this, other = other, points = points)
}

fun Offset.copy(
    dX: Double = this.dX,
    dY: Double = this.dY,
): Offset {
    return offsetOf(dX = dX, dY = dY)
}

fun Offset.swapped(): Offset {
    return offsetOf(dX = dY, dY = dX)
}
