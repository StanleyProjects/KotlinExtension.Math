package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class VectorCalculationsContainsTest {
    @Test
    fun containsEmptyTest() {
        val issues = listOf(
            Triple(pointOf(x = 0, y = 0), pointOf(x = 0, y = 0), true),
            Triple(pointOf(x = 0, y = 0), pointOf(x = 0.001, y = 0.0), false),
            Triple(pointOf(x = 1, y = 0), pointOf(x = 1, y = 0), true),
            Triple(pointOf(x = 0, y = 1), pointOf(x = 0, y = 1), true),
            Triple(pointOf(x = 2, y = 1), pointOf(x = 2, y = 1), true),
            Triple(pointOf(x = 2, y = 1), pointOf(x = 1, y = 2), false),
        )
        check(issues.size == 6)
        check(issues.toSet().size == issues.size)
        issues.forEach { (point, target, expected) ->
            val vector = point.toVector()
            check(vector.isEmpty())
            val actual = target in vector
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun containsTest() {
        val vector = vectorOf(startX = -2, startY = 2, finishX = 2, finishY = 0)
        val target = pointOf(x = 0, y = 1)
        Assertions.assertTrue(target in vector)
    }

    @Test
    fun containsTrueTest() {
        val vectors = listOf(
            vectorOf(startX = -2.0, startY = 0.0, finishX = 2.0, finishY = 0.0),
            vectorOf(startX = -1.0, startY = -1.0, finishX = 2.0, finishY = 2.0),
            vectorOf(startX = 0.0, startY = -2.0, finishX = 0.0, finishY = 1.0),
            vectorOf(startX = 1.0, startY = -1.0, finishX = -2.0, finishY = 2.0),
            vectorOf(startX = 2.0, startY = 0.0, finishX = -1.0, finishY = 0.0),
            vectorOf(startX = 1.0, startY = 1.0, finishX = -2.0, finishY = -2.0),
            vectorOf(startX = 0.0, startY = 2.0, finishX = 0.0, finishY = -1.0),
            vectorOf(startX = -2.0, startY = 2.0, finishX = 2.0, finishY = -2.0),
        )
        check(vectors.size == 8)
        check(vectors.toSet().size == vectors.size)
        val target = pointOf(x = 0, y = 0)
        check(target == Point.Center)
        vectors.forEach { vector ->
            Assertions.assertTrue(target in vector) { "vector: $vector" }
        }
    }

    @Test
    fun containsFalseTest() {
        val vectors = listOf(
            vectorOf(startX = -2.0, startY = 0.0, finishX = 2.0, finishY = 0.0),
            vectorOf(startX = -1.0, startY = -1.0, finishX = 2.0, finishY = 2.0),
            vectorOf(startX = 0.0, startY = -2.0, finishX = 0.0, finishY = 1.0),
            vectorOf(startX = 1.0, startY = -1.0, finishX = -2.0, finishY = 2.0),
            vectorOf(startX = 2.0, startY = 0.0, finishX = -1.0, finishY = 0.0),
            vectorOf(startX = 1.0, startY = 1.0, finishX = -2.0, finishY = -2.0),
            vectorOf(startX = 0.0, startY = 2.0, finishX = 0.0, finishY = -1.0),
            vectorOf(startX = -2.0, startY = 2.0, finishX = 2.0, finishY = -2.0),
        )
        check(vectors.size == 8)
        check(vectors.toSet().size == vectors.size)
        val target = pointOf(x = 0, y = 0)
        check(target == Point.Center)
        vectors.forEach { v1 ->
            val contains = target in v1
            Assertions.assertTrue(contains) { "vector: $v1" }
            val v2 = v1 + offsetOf(dX = 0.0001, dY = 0.0002)
            Assertions.assertFalse(target in v2) { "vector: ($v1) ${v2.toString(points = 4)}" }
        }
    }
}
