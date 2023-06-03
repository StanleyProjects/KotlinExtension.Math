package sp.kx.math

import java.util.Locale

fun Point.toString(points: Int, locale: Locale = Locale.US): String {
    if (points < 0) error("Points count is negative!")
    return mapOf(
        "x" to String.format(locale, "%.${points}f", x),
        "y" to String.format(locale, "%.${points}f", y),
    ).toList().joinToString(prefix = "{", separator = ", ", postfix = "}") { (k, v) ->
        "$k: $v"
    }
}
