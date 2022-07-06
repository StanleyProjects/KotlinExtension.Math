package sp.kx.math.implementation.entity.geometry

import org.junit.Test
import util.junit.assert

class PointUtilTest {
    @Test
    fun updatedTest() {
        val x = 1.0
        val y = 2.0
        val dX = 3.0
        val dY = 4.0
        val point = pointOf(x = x, y = y).updated(dX = dX, dY = dY)
        point.x.assert(x + dX, "x")
        point.y.assert(y + dY, "y")
    }

    @Test
    fun movedTest() {
        val x = 1.0
        val y = 2.0
        val length = 3.0
        val angle = 4.0
        val dX = kotlin.math.cos(angle) * length
        val dY = kotlin.math.sin(angle) * length
        val point = pointOf(x = x, y = y).moved(length = length, angle = angle)
        point.x.assert(x + dX, "x")
        point.y.assert(y + dY, "y")
    }
}
