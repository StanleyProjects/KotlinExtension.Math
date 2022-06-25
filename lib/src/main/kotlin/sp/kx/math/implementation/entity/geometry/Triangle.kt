package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Point
import sp.kx.math.foundation.entity.geometry.Triangle
import sp.kx.math.foundation.entity.geometry.Vector

private class TriangleImpl(
    override val a: Point,
    override val b: Point,
    override val c: Point
) : Triangle

fun triangleOf(
    a: Point,
    b: Point,
    c: Point
): Triangle {
    return TriangleImpl(
        a = a,
        b = b,
        c = c
    )
}

fun Point.triangleTo(
    bc: Vector
): Triangle {
    return triangleOf(
        a = this,
        b = bc.start,
        c = bc.finish
    )
}
