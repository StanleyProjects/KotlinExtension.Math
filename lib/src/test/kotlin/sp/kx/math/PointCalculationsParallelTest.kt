package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PointCalculationsParallelTest {
    @Test
    fun isParallelEmptyTest() {
        val targets = listOf(
            pointOf(x = 1, y = 1),
            pointOf(x = 1, y = 0),
            pointOf(x = 1, y = -1),
            pointOf(x = 0, y = -1),
            pointOf(x = -1, y = -1),
            pointOf(x = -1, y = 0),
            pointOf(x = -1, y = 1),
            pointOf(x = 0, y = 1),
            pointOf(x = 0, y = 0),
        )
        check(targets.size == 9)
        check(targets.toSet().size == targets.size)
        targets.forEach { a ->
            val ab = a.toVector()
            check(ab.isEmpty())
            val actual = isParallel(
                a = ab.start,
                b = ab.finish,
                c = ab.start,
                d = ab.finish,
            )
            Assertions.assertTrue(actual) {
                "ab: $ab, cd: $ab"
            }
        }
    }

    @Test
    fun isParallelEqualsTest() {
        val targets = listOf(
            pointOf(x = 1, y = 1),
            pointOf(x = 1, y = 0),
            pointOf(x = 1, y = -1),
            pointOf(x = 0, y = -1),
            pointOf(x = -1, y = -1),
            pointOf(x = -1, y = 0),
            pointOf(x = -1, y = 1),
            pointOf(x = 0, y = 1),
            pointOf(x = 0, y = 0),
        )
        check(targets.size == 9)
        check(targets.toSet().size == targets.size)
        targets.forEach { a ->
            val ab = a.toVector(offsetOf(dX = 1.0, dY = 1.0))
            check(!ab.isEmpty())
            val actual = isParallel(
                a = ab.start,
                b = ab.finish,
                c = ab.start,
                d = ab.finish,
            )
            Assertions.assertTrue(actual) {
                "ab: $ab, cd: $ab"
            }
        }
    }

    @Test
    fun isParallelXTest() {
        val targets = listOf(
            pointOf(x = 1, y = 1),
            pointOf(x = 1, y = 0),
            pointOf(x = 1, y = -1),
            pointOf(x = 0, y = -1),
            pointOf(x = -1, y = -1),
            pointOf(x = -1, y = 0),
            pointOf(x = -1, y = 1),
            pointOf(x = 0, y = 1),
            pointOf(x = 0, y = 0),
        )
        check(targets.size == 9)
        check(targets.toSet().size == targets.size)
        targets.forEach { a ->
            val ab = a.toVector(offsetOf(dX = 0.0, dY = 1.0))
            val cd = ab + offsetOf(dX = 1.0, dY = 1.0)
            check(ab.start.x == ab.finish.x)
            check(cd.start.x == cd.finish.x)
            check(ab.start.x != cd.start.x)
            val actual = isParallel(
                a = ab.start,
                b = ab.finish,
                c = cd.start,
                d = cd.finish,
            )
            Assertions.assertTrue(actual) {
                "ab: $ab, cd: $cd"
            }
        }
    }

    @Test
    fun isParallelYTest() {
        val targets = listOf(
            pointOf(x = 1, y = 1),
            pointOf(x = 1, y = 0),
            pointOf(x = 1, y = -1),
            pointOf(x = 0, y = -1),
            pointOf(x = -1, y = -1),
            pointOf(x = -1, y = 0),
            pointOf(x = -1, y = 1),
            pointOf(x = 0, y = 1),
            pointOf(x = 0, y = 0),
        )
        check(targets.size == 9)
        check(targets.toSet().size == targets.size)
        targets.forEach { a ->
            val ab = a.toVector(offsetOf(dX = 1.0, dY = 0.0))
            val cd = ab + offsetOf(dX = 1.0, dY = 1.0)
            check(ab.start.y == ab.finish.y)
            check(cd.start.y == cd.finish.y)
            check(ab.start.y != cd.start.y)
            val actual = isParallel(
                a = ab.start,
                b = ab.finish,
                c = cd.start,
                d = cd.finish,
            )
            Assertions.assertTrue(actual) {
                "ab: $ab, cd: $cd"
            }
        }
    }

    @Test
    fun isParallelTest() {
        val targets = listOf(
            vectorOf(startX = 1, startY = 1, finishX = 3, finishY = 2),
            vectorOf(startX = 1, startY = 3, finishX = 3, finishY = 1),
            vectorOf(startX = 1, startY = -1, finishX = 3, finishY = -2),
            vectorOf(startX = 1, startY = -3, finishX = 3, finishY = -1),
        )
        check(targets.size == 4)
        check(targets.toSet().size == targets.size)
        targets.forEach { ab ->
            val cd = ab + offsetOf(dX = 1.0, dY = 1.0)
            val actual = isParallel(
                a = ab.start,
                b = ab.finish,
                c = cd.start,
                d = cd.finish,
            )
            Assertions.assertTrue(actual) {
                "ab: $ab, cd: $cd"
            }
        }
    }

    @Test
    fun isParallelFalseTest() {
        val targets = listOf(
            pointOf(x = 1, y = 1),
            pointOf(x = 1, y = 0),
            pointOf(x = 1, y = -1),
            pointOf(x = 0, y = -1),
            pointOf(x = -1, y = -1),
            pointOf(x = -1, y = 0),
            pointOf(x = -1, y = 1),
            pointOf(x = 0, y = 1),
            pointOf(x = 0, y = 0),
        )
        check(targets.size == 9)
        check(targets.toSet().size == targets.size)
        targets.forEach { a ->
            val ab = a.toVector(offsetOf(dX = -1.0, dY = 1.0))
            check(!ab.isEmpty())
            val cd = ImmutableVector(
                start = ab.start + offsetOf(dX = 0.1, dY = 1.0),
                finish = ab.finish + offsetOf(dX = 1.0, dY = 1.0),
            )
            check(!cd.isEmpty())
            check(ab.start != cd.start)
            check(ab.finish != cd.finish)
            val actual = isParallel(
                a = ab.start,
                b = ab.finish,
                c = cd.start,
                d = cd.finish,
            )
            Assertions.assertFalse(actual) {
                """
                    ab: $ab
                    cd: $cd
                    abk: ${ab.finish.x - ab.start.x}
                    cdk: ${cd.finish.x - cd.start.x}
                """.trimIndent()
            }
        }
    }
}
