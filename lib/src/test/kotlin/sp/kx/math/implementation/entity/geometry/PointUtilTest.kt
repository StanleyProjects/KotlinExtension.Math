package sp.kx.math.implementation.entity.geometry

import org.junit.Test
import util.junit.assert

internal class PointUtilTest {
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
    fun updatedOffsetTest() {
        val x = 1.0
        val y = 2.0
        val offset = offsetOf(dX = 3.0, dY = 4.0)
        val point = pointOf(x = x, y = y).updated(offset)
        point.x.assert(x + offset.dX, "x")
        point.y.assert(y + offset.dY, "y")
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

    @Test
    fun getDifferenceTest() {
        val a = pointOf(x = 10.0, y = 20.0)
        val b = pointOf(x = 4.0, y = 6.0)
        val offset = a.getDifference(b)
        offset.dX.assert(a.x - b.x, "dX")
        offset.dY.assert(a.y - b.y, "dY")
    }
}
