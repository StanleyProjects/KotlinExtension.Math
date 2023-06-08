package sp.kx.math

import sp.kx.math.unsafe.eq
import sp.kx.math.unsafe.toString
import java.util.Locale

fun Vector.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return toString(vector = this, points = points, locale = locale)
}

fun Vector.eq(other: Vector, points: Int): Boolean {
    require(points > 0)
    return eq(it = this, other = other, points = points)
}
