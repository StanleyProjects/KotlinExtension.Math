package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PointCalculationsShortestPointTest {
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
            assertShortestPoint(
                start = vector.start,
                finish = vector.finish,
                target = target,
                expected = expected,
            )
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
            assertShortestPoint(
                start = vector.start,
                finish = vector.finish,
                target = target,
                expected = expected,
            )
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
            assertShortestPoint(
                start = vector.start,
                finish = vector.finish,
                target = target,
                expected = expected,
            )
        }
    }

    companion object {
        private fun assertShortestPoint(
            start: Point,
            finish: Point,
            target: Point,
            expected: Point,
        ) {
            getShortestPoint(start = start, finish = finish, target = target).also { actual ->
                Assertions.assertEquals(expected, actual)
            }
            getShortestPoint(
                start = start,
                finish = finish,
                xTarget = target.x,
                yTarget = target.y,
            ).also { actual ->
                Assertions.assertEquals(expected, actual)
            }
            getShortestPoint(
                start = start,
                xFinish = finish.x,
                yFinish = finish.y,
                xTarget = target.x,
                yTarget = target.y,
            ).also { actual ->
                Assertions.assertEquals(expected, actual)
            }
            getShortestPoint(
                xStart = start.x,
                yStart = start.y,
                xFinish = finish.x,
                yFinish = finish.y,
                target = target,
            ).also { actual ->
                Assertions.assertEquals(expected, actual)
            }
        }
    }
}
