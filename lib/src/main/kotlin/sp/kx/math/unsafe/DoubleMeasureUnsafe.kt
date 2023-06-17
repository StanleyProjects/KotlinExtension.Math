package sp.kx.math.unsafe

import sp.kx.math.measure.Measure
import java.util.Locale

internal fun toString(measure: Measure<*, Double>, points: Int, locale: Locale): String {
    return "{magnitude: ${toString(number = measure.magnitude, points, locale)}}"
}
