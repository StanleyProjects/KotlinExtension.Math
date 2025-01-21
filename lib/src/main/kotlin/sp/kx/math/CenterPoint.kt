package sp.kx.math

internal object CenterPoint : Point {
    override val x = 0.0
    override val y = 0.0

    override fun toString(): String {
        return "{x: 0.00, y: 0.00}"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Point) return false
        return other.x == 0.0 && other.y == 0.0
    }

    override fun hashCode(): Int {
        return 961
    }
}
