package sp.kx.math

internal object UndefinedVector : Vector {
    override val start = Point.Undefined
    override val finish = Point.Undefined

    override fun toString(): String {
        return ""
    }

    override fun equals(other: Any?): Boolean {
        return other === this
    }

    override fun hashCode(): Int {
        return -1
    }
}
