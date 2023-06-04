package sp.kx.math.unsafe

import sp.kx.math.Offset
import java.util.Locale

internal fun toString(offset: Offset, points: Int, locale: Locale): String {
    return "{dX: ${toString(number = offset.dX, points, locale)}, dY: ${toString(number = offset.dY, points, locale)}}"
}

internal fun eq(it: Offset, other: Offset, points: Int): Boolean {
    return eq(it.dX, other.dX, points) && eq(it.dY, other.dY, points)
}
