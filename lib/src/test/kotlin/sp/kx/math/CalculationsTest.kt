package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsTest {
    @Test
    fun getPerpendicularTest() {
        val a = pointOf(x = 2, y = 4)
        val b = pointOf(x = 1, y = 1)
        val c = pointOf(x = 5, y = 3)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = b.x,
            bY = b.y,
            cX = c.x,
            cY = c.y,
        )
        Assertions.assertEquals(p.x, 3.0)
        Assertions.assertEquals(p.y, 2.0)
    }

    @Test
    fun getPerpendicularBCXTest() {
        val a = pointOf(x = 3, y = 2)
        val b = pointOf(x = 1, y = 1)
        val c = pointOf(x = 1, y = 3)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = b.x,
            bY = b.y,
            cX = c.x,
            cY = c.y,
        )
        Assertions.assertEquals(p.y, a.y)
        Assertions.assertEquals(p.x, b.x)
        Assertions.assertEquals(p.x, c.x)
        Assertions.assertEquals(p.y, a.y)
        Assertions.assertEquals(p.x, 1.0)
        Assertions.assertEquals(p.y, 2.0)
    }

    @Test
    fun getPerpendicularBCYTest() {
        val a = pointOf(x = 2, y = 3)
        val b = pointOf(x = 1, y = 1)
        val c = pointOf(x = 3, y = 1)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = b.x,
            bY = b.y,
            cX = c.x,
            cY = c.y,
        )
        Assertions.assertEquals(p.x, a.x)
        Assertions.assertEquals(p.y, b.y)
        Assertions.assertEquals(p.y, c.y)
        Assertions.assertEquals(p.x, 2.0)
        Assertions.assertEquals(p.y, 1.0)
    }

    @Test
    fun getPerpendicularBACTest() {
        val a = pointOf(x = 3, y = 2)
        val b = pointOf(x = 1, y = 1)
        val c = pointOf(x = 5, y = 3)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = b.x,
            bY = b.y,
            cX = c.x,
            cY = c.y,
        )
        Assertions.assertEquals(p, a)
    }

    @Test
    fun getPerpendicularACTest() {
        val a = pointOf(x = 1, y = 1)
        val c = pointOf(x = 5, y = 3)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = a.x,
            bY = a.y,
            cX = c.x,
            cY = c.y,
        )
        Assertions.assertEquals(p, a)
    }

    @Test
    fun getPerpendicularBATest() {
        val a = pointOf(x = 3, y = 2)
        val b = pointOf(x = 1, y = 1)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = b.x,
            bY = b.y,
            cX = a.x,
            cY = a.y,
        )
        Assertions.assertEquals(p, a)
    }

    @Test
    fun getPerpendicularATest() {
        val a = pointOf(x = 3, y = 2)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = a.x,
            bY = a.y,
            cX = a.x,
            cY = a.y,
        )
        Assertions.assertEquals(p, a)
    }
}
