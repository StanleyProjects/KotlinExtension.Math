package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsIntersectionTest {
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
        TODO("${this::class.java.name}:getIntersectionInNoneTest")
    }

    /**
     * i in ab && i !in cd
     */
    @Test
    fun getIntersectionInABTest() {
        TODO("${this::class.java.name}:getIntersectionInABTest")
    }

    /**
     * i !in ab && i in cd
     */
    @Test
    fun getIntersectionInCDTest() {
        TODO("${this::class.java.name}:getIntersectionInCDTest")
    }

    @Test
    fun getIntersectionCollinearTest() {
        TODO("${this::class.java.name}:getIntersectionCollinearTest")
    }

    @Test
    fun getIntersectionParallelTest() {
        TODO("${this::class.java.name}:getIntersectionParallelTest")
    }

    /**
     * i in ab && i in cd
     */
    @Test
    fun getIntersectionInBothTest() {
        val issues = listOf(
            DataSet(
                ab = vectorOf(startX = 1, startY = 1, finishX = 5, finishY = 3),
                cd = vectorOf(startX = 2, startY = 4, finishX = 4, finishY = 0),
                expected = pointOf(x = 3, y = 2),
            ),
            DataSet(
                ab = pointOf(x = 0, y = 0).toVector(offsetOf(dX = 4.0, dY = 2.0)),
                cd = pointOf(x = 1, y = 3).toVector(offsetOf(dX = 2.0, dY = -4.0)),
                expected = pointOf(x = 2, y = 1),
            ),
        )
//        check(issues.size == 9) // todo
        check(issues.toSet().size == issues.size)
        issues.forEach { issue ->
            getIntersectionInBothTest(ab = issue.ab, cd = issue.cd, expected = issue.expected)
        }
    }

    private fun getIntersectionInBothTest(ab: Vector, cd: Vector, expected: Point) {
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
        Assertions.assertTrue(actual in ab)
        Assertions.assertTrue(actual in cd)
    }
}
