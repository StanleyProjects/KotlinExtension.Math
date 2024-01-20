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
        val ab = vectorOf(startX = 1, startY = 1, finishX = 5, finishY = 3)
        val cd = vectorOf(startX = 2, startY = 4, finishX = 4, finishY = 0)
        check(ab.start !in cd)
        check(ab.finish !in cd)
        check(cd.start !in ab)
        check(cd.finish !in ab)
        check(!ab.isCollinear(cd.start))
        check(!ab.isCollinear(cd.finish))
        val isParallel = isParallel(
            a = ab.start,
            b = ab.finish,
            c = cd.start,
            d = cd.finish,
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
