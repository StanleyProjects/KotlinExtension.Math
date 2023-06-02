package sp.kx.math

class MutablePoint(
    override var x: Double,
    override var y: Double,
) : Point

fun pointOf(
    x: Double,
    y: Double,
): Point {
    return MutablePoint(
        x = x,
        y = y,
    )
}
