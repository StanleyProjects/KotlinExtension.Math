package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsIntersectionTest {
    @Test
    fun getIntersectionTest() {
        val ab = vectorOf(startX = 1, startY = 1, finishX = 3, finishY = 2)
        val cd = vectorOf(startX = 2, startY = 4, finishX = 4, finishY = 0)
        val abc = isCollinear(
            aX = ab.start.x,
            aY = ab.start.y,
            bX = ab.finish.x,
            bY = ab.finish.y,
            cX = cd.start.x,
            cY = cd.start.y,
        )
        check(!abc)
        val abd = isCollinear(
            aX = ab.start.x,
            aY = ab.start.y,
            bX = ab.finish.x,
            bY = ab.finish.y,
            cX = cd.finish.x,
            cY = cd.finish.y,
        )
        check(!abd)
        val isParallel = isParallel(
            aX = ab.start.x,
            aY = ab.start.y,
            bX = ab.finish.x,
            bY = ab.finish.y,
            cX = cd.start.x,
            cY = cd.start.y,
            dX = cd.finish.x,
            dY = cd.finish.y,
        )
        check(!isParallel)
        val expected = pointOf(x = 3, y = 2)
        val actual = getIntersection(
            aX = ab.start.x,
            aY = ab.start.y,
            bX = ab.finish.x,
            bY = ab.finish.y,
            cX = cd.start.x,
            cY = cd.start.y,
            dX = cd.finish.x,
            dY = cd.finish.y,
        )
        Assertions.assertEquals(expected, actual)
    }
}
