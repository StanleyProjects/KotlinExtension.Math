package sp.kx.math.unsafe

import sp.kx.math.Vector
import java.util.Locale

internal fun toString(vector: Vector, points: Int, locale: Locale): String {
    return "${toString(point = vector.start, points, locale)} -> ${toString(point = vector.finish, points, locale)}"
}

internal fun eq(it: Vector, other: Vector, points: Int): Boolean {
    return eq(it.start.x, other.start.x, points)
            && eq(it.start.y, other.start.y, points)
            && eq(it.finish.x, other.finish.x, points)
            && eq(it.finish.y, other.finish.y, points)
}
