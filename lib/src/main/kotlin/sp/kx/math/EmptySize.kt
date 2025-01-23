package sp.kx.math

internal object EmptySize : Size {
    override val width = 0.0
    override val height = 0.0

    override fun toString(): String {
        return "0.00x0.00"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Size) return false
        return other.width == 0.0 && other.height == 0.0
    }

    override fun hashCode(): Int {
        return 961
    }
}
