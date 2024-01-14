package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class VectorCalculationsShortestTest {
    @Test
    fun getShortestZeroTest() {
        val expected = 1.0
        check(expected > 0)
        val targets = listOf(
            pointOf(x = 0, y = 1),
            pointOf(x = 1, y = 0),
            pointOf(x = 0, y = -1),
            pointOf(x = -1, y = 0),
        )
        check(targets.size == 4)
        check(targets.toSet().size == targets.size)
        val start = Point.Center
        val finish = Point.Center
        check(start.x == 0.0)
        check(start.y == 0.0)
        check(finish.x == 0.0)
        check(finish.y == 0.0)
        val vector = start + finish
        targets.forEach { target ->
            val actual = vector.getShortest(target = target)
            Assertions.assertEquals(expected, actual, 0.000000000000001) {
                "target: $target"
            }
        }
    }

    @Test
    fun getShortestZeroFinishTest() {
        val expected = 1.0
        check(expected > 0)
        val targets = listOf(
            pointOf(x = -3, y = 0),
            pointOf(x = 1, y = 0),
            pointOf(x = -2, y = 1),
            pointOf(x = -1, y = 1),
            pointOf(x = 0, y = 1),
            pointOf(x = -2, y = -1),
            pointOf(x = -1, y = -1),
            pointOf(x = 0, y = -1),
        )
        check(targets.size == 8)
        check(targets.toSet().size == targets.size)
        val start = pointOf(x = -2, y = 0)
        val finish = Point.Center
        check(finish.x == 0.0)
        check(finish.y == 0.0)
        val vector = start + finish
        targets.forEach { target ->
            val actual = vector.getShortest(target = target)
            Assertions.assertEquals(expected, actual, 0.000000000000001) {
                "target: $target"
            }
        }
    }

    @Test
    fun getShortestZeroStartTest() {
        val expected = 1.0
        check(expected > 0)
        val targets = listOf(
            pointOf(x = -1, y = 0),
            pointOf(x = 3, y = 0),
            pointOf(x = 0, y = 1),
            pointOf(x = 1, y = 1),
            pointOf(x = 2, y = 1),
            pointOf(x = 0, y = -1),
            pointOf(x = 1, y = -1),
            pointOf(x = 2, y = -1),
        )
        check(targets.size == 8)
        check(targets.toSet().size == targets.size)
        val start = Point.Center
        val finish = pointOf(x = 2, y = 0)
        check(start.x == 0.0)
        check(start.y == 0.0)
        val vector = start + finish
        targets.forEach { target ->
            val actual = vector.getShortest(target = target)
            Assertions.assertEquals(expected, actual, 0.000000000000001) {
                "target: $target"
            }
        }
    }

    @Test
    fun getShortestVTest() {
        val targets = listOf(
            pointOf(x = 1, y = 3),
            pointOf(x = 1, y = 4),
            pointOf(x = 1, y = 5),
            pointOf(x = 5, y = 3),
            pointOf(x = 5, y = 4),
            pointOf(x = 5, y = 5),
            pointOf(x = 3, y = 1),
            pointOf(x = 3, y = 7),
        )
        check(targets.size == 8)
        check(targets.toSet().size == targets.size)
        val start = pointOf(x = 3, y = 3)
        val finish = pointOf(x = 3, y = 5)
        val vector = start + finish
        targets.forEach { target ->
            val actual = vector.getShortest(target = target)
            Assertions.assertEquals(2.0, actual) {
                "target: $target"
            }
        }
    }

    @Test
    fun getShortestHTest() {
        val targets = listOf(
            pointOf(x = 3, y = 1),
            pointOf(x = 4, y = 1),
            pointOf(x = 5, y = 1),
            pointOf(x = 3, y = 5),
            pointOf(x = 4, y = 5),
            pointOf(x = 5, y = 5),
            pointOf(x = 1, y = 3),
            pointOf(x = 7, y = 3),
        )
        check(targets.size == 8)
        check(targets.toSet().size == targets.size)
        val start = pointOf(x = 3, y = 3)
        val finish = pointOf(x = 5, y = 3)
        val vector = start + finish
        targets.forEach { target ->
            val actual = vector.getShortest(target = target)
            Assertions.assertEquals(2.0, actual) {
                "target: $target"
            }
        }
    }

    @Test
    fun getShortestDTest() {
        val expected = distanceOf(x = 1.0, y = 1.0)
        check(expected > 0)
        val targets = listOf(
            pointOf(x = 2, y = 2),
            pointOf(x = 2, y = 4),
            pointOf(x = 3, y = 5),
            pointOf(x = 4, y = 6),
            pointOf(x = 4, y = 2),
            pointOf(x = 5, y = 3),
            pointOf(x = 6, y = 4),
            pointOf(x = 6, y = 6),
        )
        check(targets.size == 8)
        check(targets.toSet().size == targets.size)
        val start = pointOf(x = 3, y = 3)
        val finish = pointOf(x = 5, y = 5)
        val vector = start + finish
        targets.forEach { target ->
            val actual = vector.getShortest(target = target)
            Assertions.assertEquals(expected, actual, 0.000000000000001) {
                "target: $target"
            }
        }
    }
}
