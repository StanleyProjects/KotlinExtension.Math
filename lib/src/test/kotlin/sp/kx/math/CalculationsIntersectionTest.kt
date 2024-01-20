package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsIntersectionTest {
    // todo 1.1) i !in ab && i !in cd
    // todo 1.2) i in ab && i !in cd
    // todo 1.3) i !in ab && i in cd
    // todo 1.4) i in ab && i in cd
    // todo 2) collinear
    // todo 3) parallel
    /**
     * i in ab && i in cd
     */
    @Test
    fun getIntersectionTest() {
        val ab = vectorOf(startX = 1, startY = 1, finishX = 3, finishY = 2)
        val cd = vectorOf(startX = 2, startY = 4, finishX = 4, finishY = 0)
        val cda = contains(
            start = cd.start,
            finish = cd.finish,
            target = ab.start,
        )
        check(!cda)
        val cdb = contains(
            xStart = cd.start.x,
            yStart = cd.start.y,
            xFinish = cd.finish.x,
            yFinish = cd.finish.y,
            xTarget = ab.finish.x,
            yTarget = ab.finish.y,
        )
        check(!cdb)
        // todo contains...
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
        Assertions.assertNotNull(actual)
        checkNotNull(actual)
        Assertions.assertEquals(expected, actual)
        val abi = contains(
            xStart = ab.start.x,
            yStart = ab.start.y,
            xFinish = ab.finish.x,
            yFinish = ab.finish.y,
            xTarget = actual.x,
            yTarget = actual.y,
        )
        Assertions.assertTrue(abi)
        val cdi = contains(
            xStart = cd.start.x,
            yStart = cd.start.y,
            xFinish = cd.finish.x,
            yFinish = cd.finish.y,
            xTarget = actual.x,
            yTarget = actual.y,
        )
        Assertions.assertTrue(cdi)
    }
}
