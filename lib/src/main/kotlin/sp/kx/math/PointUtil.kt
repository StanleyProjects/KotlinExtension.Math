package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale

fun Point.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return toString(point = this, points, locale)
}
