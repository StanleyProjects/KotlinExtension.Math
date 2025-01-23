package sp.kx.math

internal object UndefinedVector : Vector {
    override val start = Point.Undefined
    override val finish = Point.Undefined

    override fun toString(): String {
        return "{x: NaN, y: NaN} -> {x: NaN, y: NaN}"
    }

    override fun equals(other: Any?): Boolean {
        return other === this
    }

    override fun hashCode(): Int {
        return 1041110913
    }
}
