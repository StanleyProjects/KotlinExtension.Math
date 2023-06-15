package sp.kx.math.unsafe

import sp.kx.math.measure.Deviation
import java.util.Locale

internal fun toString(deviation: Deviation<Double>, points: Int, locale: Locale): String {
    return StringBuilder("{")
        .append("a: ")
        .append(toString(number = deviation.actual, points, locale))
        .append("e: ")
        .append(toString(number = deviation.expected, points, locale))
        .append("}")
        .toString()
}
