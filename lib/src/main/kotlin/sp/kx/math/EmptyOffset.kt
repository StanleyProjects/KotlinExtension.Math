package sp.kx.math

internal object EmptyOffset : Offset {
    override val dX = 0.0
    override val dY = 0.0

    override fun toString(): String {
        return ""
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Offset) return false
        return other.dX == 0.0 && other.dY == 0.0
    }

    override fun hashCode(): Int {
        return -1
    }
}
