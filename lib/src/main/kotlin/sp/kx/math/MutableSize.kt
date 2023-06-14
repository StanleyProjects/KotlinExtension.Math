package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

class MutableSize(
    override var width: Double,
    override var height: Double,
) : Size {
    override fun toString(): String {
        return toString(size = this, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Size) return false
        return width == other.width && height == other.height
    }

    override fun hashCode(): Int {
        return Objects.hash(width, height)
    }
}

fun sizeOf(
    width: Double,
    height: Double,
): Size {
    return MutableSize(
        width = width,
        height = height,
    )
}
