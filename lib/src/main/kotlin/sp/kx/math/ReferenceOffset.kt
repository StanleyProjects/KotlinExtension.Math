package sp.kx.math

internal object ReferenceOffset : Offset {
    override val dX = 1.0
    override val dY = 1.0

    override fun toString(): String {
        return ""
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Offset) return false
        return other.dX == 1.0 && other.dY == 1.0
    }

    override fun hashCode(): Int {
        return -1
    }
}
