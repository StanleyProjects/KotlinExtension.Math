package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class CalculationsContainsTest {
    @Test
    fun containsTest() {
        val actual = contains(
            xStart = -2.0,
            yStart = 2.0,
            xFinish = 2.0,
            yFinish = 0.0,
            xTarget = 0.0,
            yTarget = 1.0,
        )
        Assertions.assertTrue(actual)
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
        vectors.forEach { vector ->
            val actual = contains(
                xStart = vector.start.x,
                yStart = vector.start.y,
                xFinish = vector.finish.x,
                yFinish = vector.finish.y,
                xTarget = 0.0,
                yTarget = 0.0,
            )
            Assertions.assertTrue(actual) { "vector: $vector" }
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
        vectors.forEach { v1 ->
            val contains = contains(
                xStart = v1.start.x,
                yStart = v1.start.y,
                xFinish = v1.finish.x,
                yFinish = v1.finish.y,
                xTarget = 0.0,
                yTarget = 0.0,
            )
            Assertions.assertTrue(contains) { "vector: $v1" }
            val v2 = v1 + offsetOf(dX = 0.0001, dY = 0.0002)
            val actual = contains(
                xStart = v2.start.x,
                yStart = v2.start.y,
                xFinish = v2.finish.x,
                yFinish = v2.finish.y,
                xTarget = 0.0,
                yTarget = 0.0,
            )
            Assertions.assertFalse(actual) { "vector: ($v1) ${v2.toString(points = 4)}" }
        }
    }
}
