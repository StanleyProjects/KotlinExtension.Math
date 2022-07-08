package sp.kx.math.implementation.entity.geometry

import org.junit.Test
import util.junit.assert

internal class PointTest {
    @Test
    fun toStringTest() {
        val string = pointOf(x = 1.0, y = 2.0).toString()
        string.assert("{x:1.00,y:2.00}", name = "Point.toString")
    }

    @Test
    fun pointOfDoubleTest() {
        val x = 1.0
        val y = 2.0
        val point = pointOf(x = x, y = y)
        point.x.assert(x, "x")
        point.y.assert(y, "y")
    }

    @Test
    fun pointOfIntTest() {
        val x = 1
        val y = 2
        val point = pointOf(x = x, y = y)
        point.x.assert(x.toDouble(), "x")
        point.y.assert(y.toDouble(), "y")
    }
}
