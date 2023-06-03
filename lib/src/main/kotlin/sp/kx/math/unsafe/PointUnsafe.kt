package sp.kx.math.unsafe

import sp.kx.math.Point
import java.util.Locale

internal fun toString(point: Point, points: Int, locale: Locale): String {
    return "{x: ${toString(number = point.x, points, locale)}, y: ${toString(number = point.y, points, locale)}}"
}

internal fun eq(it: Point, other: Point, points: Int): Boolean {
    return eq(it.x, other.x, points) && eq(it.y, other.y, points)
}
