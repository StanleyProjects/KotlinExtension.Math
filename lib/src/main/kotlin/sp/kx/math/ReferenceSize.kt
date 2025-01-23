package sp.kx.math

internal object ReferenceSize : Size {
    override val width = 1.0
    override val height = 1.0

    override fun toString(): String {
        return "1.00x1.00"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Size) return false
        return other.width == 1.0 && other.height == 1.0
    }

    override fun hashCode(): Int {
        return -33553471
    }
}
