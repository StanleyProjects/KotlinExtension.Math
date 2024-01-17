package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsShortestPointTest {
    @Test
    fun getShortestPointZeroTest() {
        val vector = vectorOf(
            startX = 0,
            startY = 0,
            finishX = 0,
            finishY = 0,
        )
        check(vector.isEmpty())
        val expected = pointOf(x = 0, y = 0)
        check(expected.x == 0.0)
        check(expected.y == 0.0)
        check(vector.start == expected)
        check(vector.finish == expected)
        val targets = listOf(
            pointOf(x = 0, y = 0),
            pointOf(x = 1, y = 0),
            pointOf(x = 1, y = 1),
            pointOf(x = 0, y = 1),
            pointOf(x = -1, y = 1),
            pointOf(x = -1, y = 0),
            pointOf(x = -1, y = -1),
            pointOf(x = 0, y = -1),
            pointOf(x = 1, y = -1),
        )
        check(targets.size == 9)
        check(targets.toSet().size == targets.size)
        targets.forEach { target ->
            val actual = getShortestPoint(
                xStart = vector.start.x,
                yStart = vector.start.y,
                xFinish = vector.finish.x,
                yFinish = vector.finish.y,
                xTarget = target.x,
                yTarget = target.y,
            )
            Assertions.assertEquals(expected, actual) {
                "target: $target"
            }
        }
    }

    @Test
    fun getShortestPointEmptyTest() {
        val vector = vectorOf(
            startX = 1.0,
            startY = 1.0,
            finishX = 1.0,
            finishY = 1.0,
        )
        check(vector.isEmpty())
        val expected = pointOf(x = 1, y = 1)
        check(vector.start == expected)
        check(vector.finish == expected)
        val targets = listOf(
            pointOf(x = 0, y = 0),
            pointOf(x = 1, y = 0),
            pointOf(x = 2, y = 0),
            pointOf(x = 2, y = 1),
            pointOf(x = 2, y = 2),
            pointOf(x = 1, y = 2),
            pointOf(x = 0, y = 2),
            pointOf(x = 0, y = 1),
        )
        check(targets.size == 8)
        check(targets.toSet().size == targets.size)
        targets.forEach { target ->
            val actual = getShortestPoint(
                xStart = vector.start.x,
                yStart = vector.start.y,
                xFinish = vector.finish.x,
                yFinish = vector.finish.y,
                xTarget = target.x,
                yTarget = target.y,
            )
            Assertions.assertEquals(expected, actual) {
                "target: $target"
            }
        }
    }

    @Test
    fun getShortestPointTest() {
        val vector = vectorOf(
            startX = 1.0,
            startY = 1.0,
            finishX = 3.0,
            finishY = 1.0,
        )
        val targets = listOf(
            pointOf(x = 0, y = 0) to pointOf(x = 1, y = 1),
            pointOf(x = 1, y = 0) to pointOf(x = 1, y = 1),
            pointOf(x = 2, y = 0) to pointOf(x = 2, y = 1),
            pointOf(x = 3, y = 0) to pointOf(x = 3, y = 1),
            pointOf(x = 4, y = 0) to pointOf(x = 3, y = 1),
            pointOf(x = 4, y = 1) to pointOf(x = 3, y = 1),
            pointOf(x = 4, y = 2) to pointOf(x = 3, y = 1),
            pointOf(x = 3, y = 2) to pointOf(x = 3, y = 1),
            pointOf(x = 2, y = 2) to pointOf(x = 2, y = 1),
            pointOf(x = 1, y = 2) to pointOf(x = 1, y = 1),
            pointOf(x = 0, y = 2) to pointOf(x = 1, y = 1),
            pointOf(x = 0, y = 1) to pointOf(x = 1, y = 1),
        )
        check(targets.size == 12)
        check(targets.toSet().size == targets.size)
        targets.forEach { (target, expected) ->
            val actual = getShortestPoint(
                xStart = vector.start.x,
                yStart = vector.start.y,
                xFinish = vector.finish.x,
                yFinish = vector.finish.y,
                xTarget = target.x,
                yTarget = target.y,
            )
            Assertions.assertEquals(expected, actual) {
                "target: $target"
            }
        }
    }
}
