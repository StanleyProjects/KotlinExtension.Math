package sp.kx.math.unsafe

import sp.kx.math.Point
import java.util.Locale

internal fun toString(point: Point, points: Int, locale: Locale): String {
    return "{x: ${toString(number = point.x, points, locale)}, y: ${toString(number = point.y, points, locale)}}"
}
