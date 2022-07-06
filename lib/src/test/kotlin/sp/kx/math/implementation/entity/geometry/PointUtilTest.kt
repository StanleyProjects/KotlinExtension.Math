package sp.kx.math.implementation.entity.geometry

import org.junit.Assert.assertTrue
import org.junit.Test

class PointUtilTest {
    @Test
    fun updatedTest() {
        val x = 1.0
        val y = 2.0
        val dX = 3.0
        val dY = 4.0
        val point = pointOf(x = x, y = y).updated(dX = dX, dY = dY)
        assertTrue("Expected x is ${x + dX}, but actual is ${point.x}!", x + dX == point.x)
        assertTrue("Expected y is ${y + dY}, but actual is ${point.y}!", y + dY == point.y)
    }
}
