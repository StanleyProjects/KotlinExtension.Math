package sp.kx.math

internal object UndefinedOffset : Offset {
    override val dX = Double.NaN
    override val dY = Double.NaN

    override fun toString(): String {
        return "{dX: NaN, dY: NaN}"
    }

    override fun equals(other: Any?): Boolean {
        return other === this
    }

    override fun hashCode(): Int {
        return -16_776_255
    }
}
