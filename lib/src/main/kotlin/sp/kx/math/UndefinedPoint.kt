package sp.kx.math

internal object UndefinedPoint : Point {
    override val x = Double.NaN
    override val y = Double.NaN

    override fun toString(): String {
        return "{x: NaN, y: NaN}"
    }

    override fun equals(other: Any?): Boolean {
        return other === this
    }

    override fun hashCode(): Int {
        return -16776255
    }
}
