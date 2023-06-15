package sp.kx.math.unsafe

import sp.kx.math.Size
import java.util.Locale

internal fun toString(size: Size, points: Int, locale: Locale): String {
    return "${toString(number = size.width, points, locale)}x${toString(number = size.height, points, locale)}"
}

internal fun eq(it: Size, other: Size, points: Int): Boolean {
    return eq(it.width, other.width, points) && eq(it.height, other.height, points)
}
