package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsIntersectionTest {
    private data class DataSet(
        val ab: Vector,
        val cd: Vector,
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
            )
        )
//        check(issues.size == 9) // todo
        check(issues.toSet().size == issues.size)
        issues.forEach { issue ->
            getIntersectionInBothTest(ab = issue.ab, cd = issue.cd)
        }
    }

    private fun getIntersectionInBothTest(ab: Vector, cd: Vector) {
        check(ab.start !in cd)
        check(ab.finish !in cd)
        check(cd.start !in ab)
        check(cd.finish !in ab)
        check(!ab.isCollinear(cd.start))
        check(!ab.isCollinear(cd.finish))
        check(!ab.isParallel(cd))
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
        Assertions.assertTrue(actual in ab)
        Assertions.assertTrue(actual in cd)
    }
}
