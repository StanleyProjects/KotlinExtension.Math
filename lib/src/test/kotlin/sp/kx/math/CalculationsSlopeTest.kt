package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsSlopeTest {
    @Test
    fun getSlopeNaNTest() {
        val targets = listOf(
            pointOf(x = 0, y = 0) to pointOf(x = 0, y = 0),
            pointOf(x = 1, y = 1) to pointOf(x = 1, y = 1),
        )
        check(targets.size == 2)
        check(targets.toSet().size == targets.size)
        targets.forEach { (a, b) ->
            val actual = getSlope(
                aX = a.x,
                aY = a.y,
                bX = b.x,
                bY = b.y,
            )
            Assertions.assertTrue(actual.isNaN()) {
                "a: $a, b: $b, actual: $actual"
            }
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
            val actual = getSlope(
                aX = a.x,
                aY = a.y,
                bX = b.x,
                bY = b.y,
            )
            Assertions.assertTrue(actual.isInfinite()) {
                "a: $a, b: $b, actual: $actual"
            }
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
            val actual = getSlope(
                aX = a.x,
                aY = a.y,
                bX = b.x,
                bY = b.y,
            )
            Assertions.assertEquals(expected, actual) {
                "a: $a, b: $b"
            }
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
            val actual = getSlope(
                aX = a.x,
                aY = a.y,
                bX = b.x,
                bY = b.y,
            )
            Assertions.assertEquals(expected, actual) {
                "a: $a, b: $b"
            }
        }
    }
}
