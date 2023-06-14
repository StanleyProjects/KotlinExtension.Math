package sp.kx.math

import java.util.Objects

class MutableSize(
    override var width: Double,
    override var height: Double,
) : Size {
    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
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
