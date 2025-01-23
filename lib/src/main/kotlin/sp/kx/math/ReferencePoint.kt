package sp.kx.math

internal object ReferencePoint : Point {
    override val x = 1.0
    override val y = 1.0

    override fun toString(): String {
        return "{x: 1.00, y: 1.00}"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Point) return false
        return other.x == 1.0 && other.y == 1.0
    }

    override fun hashCode(): Int {
        return -33_553_471
    }
}
