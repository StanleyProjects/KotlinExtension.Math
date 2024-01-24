package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress(
    "MagicNumber",
    "StringLiteralDuplication",
)
internal class PointCalculationsIntersectionTest {
    private data class DataSet(
        val ab: Vector,
        val cd: Vector,
        val expected: Point,
    )

    /**
     * i !in ab && i !in cd
     */
    @Test
    fun getIntersectionInNoneTest() {
        val abOffset = offsetOf(dX = 4, dY = 2)
        val cdOffset = offsetOf(dX = 2, dY = -4)
        val issues = listOf(
            DataSet(
                ab = pointOf(x = -3, y = -1).toVector(abOffset),
                cd = pointOf(x = 4, y = 0).toVector(cdOffset),
                expected = pointOf(x = 3, y = 2),
            ),
            DataSet(
                ab = pointOf(x = 0, y = 0).toVector(abOffset),
                cd = pointOf(x = 7, y = 1).toVector(cdOffset),
                expected = pointOf(x = 6, y = 3),
            ),
            DataSet(
                ab = pointOf(x = 1, y = 3).toVector(abOffset),
                cd = pointOf(x = 0, y = 0).toVector(cdOffset),
                expected = pointOf(x = -1, y = 2),
            ),
        )
        check(issues.size == 3)
        check(issues.toSet().size == issues.size)
        issues.forEach { issue ->
            assertIntersection(
                ab = issue.ab,
                cd = issue.cd,
                expected = issue.expected,
                inAB = false,
                inCD = false,
            )
        }
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
            ),
            DataSet(
                ab = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 3, y = -1).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 2, y = 1),
            ),
            DataSet(
                ab = pointOf(x = -3, y = 1).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = -1, y = 2),
            ),
        )
        check(issues.size == 3)
        check(issues.toSet().size == issues.size)
        issues.forEach { issue ->
            assertIntersection(
                ab = issue.ab,
                cd = issue.cd,
                expected = issue.expected,
                inAB = true,
                inCD = false,
            )
        }
    }

    /**
     * i !in ab && i in cd
     */
    @Test
    fun getIntersectionInCDTest() {
        val issues = listOf(
            DataSet(
                ab = pointOf(x = -3, y = -1).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 2, y = 4).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 3, y = 2),
            ),
            DataSet(
                ab = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 5, y = 5).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 6, y = 3),
            ),
            DataSet(
                ab = pointOf(x = 3, y = -1).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 1, y = -2),
            ),
        )
        check(issues.size == 3)
        check(issues.toSet().size == issues.size)
        issues.forEach { issue ->
            assertIntersection(
                ab = issue.ab,
                cd = issue.cd,
                expected = issue.expected,
                inAB = false,
                inCD = true,
            )
        }
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
            ),
            DataSet(
                ab = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 1, y = 3).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 2, y = 1),
            ),
            DataSet(
                ab = pointOf(x = -1, y = -3).toVector(offsetOf(dX = 4, dY = 2)),
                cd = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 2, dY = -4)),
                expected = pointOf(x = 1, y = -2),
            ),
        )
        check(issues.size == 3)
        check(issues.toSet().size == issues.size)
        issues.forEach { issue ->
            assertIntersection(
                ab = issue.ab,
                cd = issue.cd,
                expected = issue.expected,
                inAB = true,
                inCD = true,
            )
        }
    }

    @Test
    fun getIntersectionCollinearTest() {
        val ab = pointOf(x = -3, y = -1).toVector(offsetOf(dX = 4, dY = 2))
        val cd = pointOf(x = 3, y = 2).toVector(offsetOf(dX = 4, dY = 2))
        check(ab.start !in cd) { "${ab.start} in $cd!" }
        check(ab.finish !in cd) { "${ab.finish} in $cd!" }
        check(cd.start !in ab)
        check(cd.finish !in ab)
        check(ab.isCollinear(cd.start))
        check(ab.isCollinear(cd.finish))
        check(cd.isCollinear(ab.start))
        check(cd.isCollinear(ab.finish))
        val actual = getIntersection(
            a = ab.start,
            b = ab.finish,
            c = cd.start,
            d = cd.finish,
        )
        Assertions.assertNull(actual)
    }

    @Test
    fun getIntersectionParallelTest() {
        val ab = pointOf(x = 1, y = 1).toVector(offsetOf(dX = 4, dY = 2))
        val cd = pointOf(x = 1, y = 2).toVector(offsetOf(dX = 4, dY = 2))
        check(ab.start !in cd) { "${ab.start} in $cd!" }
        check(ab.finish !in cd) { "${ab.finish} in $cd!" }
        check(cd.start !in ab)
        check(cd.finish !in ab)
        check(!ab.isCollinear(cd.start))
        check(!ab.isCollinear(cd.finish))
        check(!cd.isCollinear(ab.start))
        check(!cd.isCollinear(ab.finish))
        check(ab.isParallel(cd))
        val actual = getIntersection(
            a = ab.start,
            b = ab.finish,
            c = cd.start,
            d = cd.finish,
        )
        Assertions.assertNull(actual)
    }

    companion object {
        private fun assertIntersection(
            ab: Vector,
            cd: Vector,
            expected: Point,
            inAB: Boolean,
            inCD: Boolean,
        ) {
            check(ab.start !in cd) { "${ab.start} in $cd!" }
            check(ab.finish !in cd) { "${ab.finish} in $cd!" }
            check(cd.start !in ab)
            check(cd.finish !in ab)
            check(!ab.isCollinear(cd.start))
            check(!ab.isCollinear(cd.finish))
            check(!cd.isCollinear(ab.start))
            check(!cd.isCollinear(ab.finish))
            check(!ab.isParallel(cd))
            val actual = getIntersection(
                a = ab.start,
                b = ab.finish,
                c = cd.start,
                d = cd.finish,
            )
            Assertions.assertNotNull(actual)
            checkNotNull(actual)
            Assertions.assertEquals(expected, actual)
            Assertions.assertEquals(inAB, actual in ab)
            Assertions.assertEquals(inCD, actual in cd)
        }
    }
}
