package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Point
import util.junit.assert

fun Point.assert(expected: Point, prefix: String) {
    x.assert(expected.x, "${prefix}x")
    y.assert(expected.y, "${prefix}y")
}
