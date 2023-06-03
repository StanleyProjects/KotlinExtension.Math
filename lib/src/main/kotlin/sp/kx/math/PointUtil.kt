package sp.kx.math

import java.util.Locale

fun Point.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return "{x: ${String.format(locale, "%.${points}f", x)}, y: ${String.format(locale, "%.${points}f", y)}}"
}
