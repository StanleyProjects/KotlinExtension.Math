package sp.kx.math

operator fun MutableOffset.divAssign(value: Double) {
    set(
        dX = dX / value,
        dY = dY / value,
    )
}

operator fun MutableOffset.timesAssign(value: Double) {
    set(
        dX = dX * value,
        dY = dY * value,
    )
}

operator fun MutableOffset.plusAssign(value: Double) {
    set(
        dX = dX + value,
        dY = dY + value,
    )
}

operator fun MutableOffset.minusAssign(value: Double) {
    set(
        dX = dX - value,
        dY = dY - value,
    )
}

operator fun MutableOffset.divAssign(other: Offset) {
    set(
        dX = dX / other.dX,
        dY = dY / other.dY,
    )
}

operator fun MutableOffset.timesAssign(other: Offset) {
    set(
        dX = dX * other.dX,
        dY = dY * other.dY,
    )
}

operator fun MutableOffset.plusAssign(other: Offset) {
    set(
        dX = dX + other.dX,
        dY = dY + other.dY,
    )
}

operator fun MutableOffset.minusAssign(other: Offset) {
    set(
        dX = dX - other.dX,
        dY = dY - other.dY,
    )
}
