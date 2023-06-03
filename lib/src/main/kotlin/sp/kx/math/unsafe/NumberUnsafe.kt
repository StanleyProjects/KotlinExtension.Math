package sp.kx.math.unsafe

import java.util.Locale

internal fun toString(number: Double, points: Int, locale: Locale): String {
    return String.format(locale, "%.${points}f", number)
}
