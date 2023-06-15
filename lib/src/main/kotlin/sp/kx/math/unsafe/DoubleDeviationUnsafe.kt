package sp.kx.math.unsafe

import sp.kx.math.measure.Deviation
import java.util.Locale

internal fun toString(deviation: Deviation<Double>, points: Int, locale: Locale): String {
    return "{a: ${toString(number = deviation.actual, points, locale)}, e: ${toString(number = deviation.expected, points, locale)}}"
}
