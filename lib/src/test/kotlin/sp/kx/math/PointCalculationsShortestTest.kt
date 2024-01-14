package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PointCalculationsShortestTest {
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
        targets.forEach { target ->
            val actual = getShortest(
                start = start,
                finish = finish,
                target = target,
            )
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
        targets.forEach { target ->
            val actual = getShortest(
                start = start,
                finish = finish,
                target = target,
            )
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
        targets.forEach { target ->
            val actual = getShortest(
                start = start,
                finish = finish,
                target = target,
            )
            Assertions.assertEquals(expected, actual, 0.000000000000001) {
                "target: $target"
            }
        }
    }
}
