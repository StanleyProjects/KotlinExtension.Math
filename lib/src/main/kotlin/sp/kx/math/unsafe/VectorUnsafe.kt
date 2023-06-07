package sp.kx.math.unsafe

import sp.kx.math.Vector
import java.util.Locale

internal fun toString(vector: Vector, points: Int, locale: Locale): String {
    return "${toString(point = vector.start, points, locale)} -> ${toString(point = vector.finish, points, locale)}"
}
