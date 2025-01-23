package sp.kx.math

internal object UndefinedSize : Size {
    override val width = Double.NaN
    override val height = Double.NaN

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
