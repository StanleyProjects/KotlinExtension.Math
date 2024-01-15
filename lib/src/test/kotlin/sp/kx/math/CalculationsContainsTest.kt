package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        vectors.forEach {
            val contains = contains(
                xStart = it.start.x,
                yStart = it.start.y,
                xFinish = it.finish.x,
                yFinish = it.finish.y,
                xTarget = 0.0,
                yTarget = 0.0,
            )
            Assertions.assertTrue(contains) { "vector: $it" }
            val vector = it + offsetOf(dX = 0.0001, dY = 0.0002)
            val actual = contains(
                xStart = vector.start.x,
                yStart = vector.start.y,
                xFinish = vector.finish.x,
                yFinish = vector.finish.y,
                xTarget = 0.0,
                yTarget = 0.0,
            )
            Assertions.assertFalse(actual) { "vector: ($it) ${vector.toString(points = 4)}" }
        }
    }
}
