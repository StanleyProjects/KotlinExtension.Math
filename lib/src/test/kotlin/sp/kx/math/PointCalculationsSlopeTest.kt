package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class PointCalculationsSlopeTest {
    @Test
    fun getSlopeNaNTest() {
        val targets = listOf(
            pointOf(x = 0, y = 0) to pointOf(x = 0, y = 0),
            pointOf(x = 1, y = 1) to pointOf(x = 1, y = 1),
            pointOf(x = 1, y = 3) to pointOf(x = 1, y = 3),
        )
        check(targets.size == 3)
        check(targets.toSet().size == targets.size)
        targets.forEach { (a, b) ->
            Assertions.assertTrue(getSlope(a = a, b = b).isNaN())
            Assertions.assertTrue(getSlope(a = a, bX = b.x, bY = b.y).isNaN())
            Assertions.assertTrue(getSlope(aX = a.x, aY = a.y, b = b).isNaN())
        }
    }

    @Test
    fun getSlopeInfiniteTest() {
        val targets = listOf(
            pointOf(x = 1, y = 3) to pointOf(x = 1, y = 0),
            pointOf(x = 1, y = 0) to pointOf(x = 1, y = 3),
            pointOf(x = 0, y = 0) to pointOf(x = 0, y = 3),
            pointOf(x = 0, y = 1) to pointOf(x = 0, y = -1),
            pointOf(x = 0, y = -1) to pointOf(x = 0, y = 1),
            pointOf(x = 1, y = 0) to pointOf(x = 1, y = -3),
        )
        check(targets.size == 6)
        check(targets.toSet().size == targets.size)
        targets.forEach { (a, b) ->
            Assertions.assertTrue(getSlope(a = a, b = b).isInfinite())
            Assertions.assertTrue(getSlope(a = a, bX = b.x, bY = b.y).isInfinite())
            Assertions.assertTrue(getSlope(aX = a.x, aY = a.y, b = b).isInfinite())
        }
    }

    @Test
    fun getSlopeZeroTest() {
        val expected = 0.0
        val targets = listOf(
            pointOf(x = 1, y = 0) to pointOf(x = 3, y = 0),
            pointOf(x = 1, y = 1) to pointOf(x = 3, y = 1),
            pointOf(x = 1, y = 2) to pointOf(x = 3, y = 2),
            pointOf(x = 0, y = 0) to pointOf(x = 3, y = 0),
            pointOf(x = -3, y = 0) to pointOf(x = 0, y = 0),
        )
        check(targets.size == 5)
        check(targets.toSet().size == targets.size)
        targets.forEach { (a, b) ->
            Assertions.assertEquals(expected, getSlope(a = a, b = b))
            Assertions.assertEquals(expected, getSlope(a = a, bX = b.x, bY = b.y))
            Assertions.assertEquals(expected, getSlope(aX = a.x, aY = a.y, b = b))
        }
    }

    @Test
    fun getSlopeTest() {
        val targets = listOf(
            Triple(pointOf(x = 1, y = 1), pointOf(x = 3, y = 2), 0.5),
            Triple(pointOf(x = 1, y = 2), pointOf(x = 3, y = 1), -0.5),
            Triple(pointOf(x = 3, y = 2), pointOf(x = 1, y = 1), 0.5),
            Triple(pointOf(x = 1, y = 3), pointOf(x = 3, y = 1), -1.0),
            Triple(pointOf(x = 1, y = 1), pointOf(x = 3, y = 3), 1.0),
        )
        check(targets.size == 5)
        check(targets.toSet().size == targets.size)
        targets.forEach { (a, b, expected) ->
            Assertions.assertEquals(expected, getSlope(a = a, b = b))
            Assertions.assertEquals(expected, getSlope(a = a, bX = b.x, bY = b.y))
            Assertions.assertEquals(expected, getSlope(aX = a.x, aY = a.y, b = b))
        }
    }
}
