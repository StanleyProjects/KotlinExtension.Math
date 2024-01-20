package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsIntersectionTest {
    private data class DataSet(
        val ab: Vector,
        val cd: Vector,
        val expected: Point,
        val inAB: Boolean,
        val inCD: Boolean,
    )

    /**
     * i !in ab && i !in cd
     */
    @Test
    fun getIntersectionInNoneTest() {
        TODO("${this::class.java.name}:getIntersectionInNoneTest")
    }

    /**
     * i in ab && i !in cd
     */
    @Test
    fun getIntersectionInABTest() {
        val issues = listOf(
            DataSet(
                ab = pointOf(x = 1, y = 1).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 4, y = 0).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 3, y = 2),
                inAB = true,
                inCD = false,
            ),
            DataSet(
                ab = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 3, y = -1).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 2, y = 1),
                inAB = true,
                inCD = false,
            ),
            DataSet(
                ab = pointOf(x = -3, y = 1).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = -1, y = 2),
                inAB = true,
                inCD = false,
            ),
        )
        check(issues.size == 3)
        check(issues.toSet().size == issues.size)
        issues.forEach(::assertIntersection)
    }

    /**
     * i !in ab && i in cd
     */
    @Test
    fun getIntersectionInCDTest() {
        TODO("${this::class.java.name}:getIntersectionInCDTest")
    }

    /**
     * i in ab && i in cd
     */
    @Test
    fun getIntersectionInABInCDTest() {
        val issues = listOf(
            DataSet(
                ab = pointOf(x = 1, y = 1).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 2, y = 4).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 3, y = 2),
                inAB = true,
                inCD = true,
            ),
            DataSet(
                ab = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 1, y = 3).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 2, y = 1),
                inAB = true,
                inCD = true,
            ),
            DataSet(
                ab = pointOf(x = -1, y = -3).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 1, y = -2),
                inAB = true,
                inCD = true,
            ),
        )
        check(issues.size == 3)
        check(issues.toSet().size == issues.size)
        issues.forEach(::assertIntersection)
    }

    @Test
    fun getIntersectionCollinearTest() {
        TODO("${this::class.java.name}:getIntersectionCollinearTest")
    }

    @Test
    fun getIntersectionParallelTest() {
        TODO("${this::class.java.name}:getIntersectionParallelTest")
    }

    companion object {
        private fun assertIntersection(issue: DataSet) {
            assertIntersection(
                ab = issue.ab,
                cd = issue.cd,
                expected = issue.expected,
                inAB = issue.inAB,
                inCD = issue.inCD,
            )
        }

        private fun assertIntersection(
            ab: Vector,
            cd: Vector,
            expected: Point,
            inAB: Boolean,
            inCD: Boolean,
        ) {
            check(ab.start !in cd)
            check(ab.finish !in cd)
            check(cd.start !in ab)
            check(cd.finish !in ab)
            check(!ab.isCollinear(cd.start))
            check(!ab.isCollinear(cd.finish))
            check(!ab.isParallel(cd))
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
            Assertions.assertEquals(inAB, actual in ab)
            Assertions.assertEquals(inCD, actual in cd)
        }
    }
}
