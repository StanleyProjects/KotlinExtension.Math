package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class VectorComparisonsTest {
    @Test
    fun reachesTest() {
        val vector = vectorOf(
            startX = 0.0,
            startY = 0.0,
            finishX = 2.0,
            finishY = 0.0,
        )
        val x = 1.0
        val y = 2.24
        setOf(
            1.0 to 17,
            2.0 to 17,
            2.23 to 17,
            2.25 to 2,
            2.26 to 2,
            3.0 to 0,
            4.0 to 0,
        ).forEach { (minDistance, border) ->
            for (points in 1..16) {
                if (points == border) continue
                val expected = points > border
                val actual = vector.reaches(
                    xTarget = x,
                    yTarget = y,
                    minDistance = minDistance,
                    points = points,
                )
                val message = """
                    vector: $vector
                    x: $x
                    y: $y
                    minDistance: $minDistance
                    points: $points
                    border: $border
                """.trimIndent()
                assertEquals(expected, actual, message)
            }
        }
    }

    @Test
    fun reachesPointTest() {
        val vector = vectorOf(
            startX = 0.0,
            startY = 0.0,
            finishX = 2.0,
            finishY = 0.0,
        )
        val target = pointOf(
            x = 1.0,
            y = 2.24,
        )
        setOf(
            1.0 to 17,
            2.0 to 17,
            2.23 to 17,
            2.25 to 2,
            2.26 to 2,
            3.0 to 0,
            4.0 to 0,
        ).forEach { (minDistance, border) ->
            for (points in 1..16) {
                if (points == border) continue
                val expected = points > border
                val actual = vector.reaches(
                    target = target,
                    minDistance = minDistance,
                    points = points,
                )
                val message = """
                    vector: $vector
                    target: $target
                    minDistance: $minDistance
                    points: $points
                    border: $border
                """.trimIndent()
                assertEquals(expected, actual, message)
            }
        }
    }

    @Test
    fun reachesIterableTest() {
        val v1 = vectorOf(
            startX = 0.0,
            startY = 0.0,
            finishX = 2.0,
            finishY = 0.0,
        )
        val v2 = vectorOf(
            startX = 0.0,
            startY = 1.0,
            finishX = 2.0,
            finishY = 1.0,
        )
        val x = 1.0
        val y = 3.24
        val vectors = listOf(v1, v2)
        setOf(
            1.0 to 17,
            2.0 to 17,
            2.23 to 17,
            2.25 to 2,
            2.26 to 2,
            3.0 to 0,
            4.0 to 0,
        ).forEach { (minDistance, border) ->
            for (points in 1..16) {
                if (points == border) continue
                val expected = points > border
                val actual = vectors.reaches(
                    xTarget = x,
                    yTarget = y,
                    minDistance = minDistance,
                    points = points,
                )
                val message = """
                    vectors: $vectors
                    x: $x
                    y: $y
                    minDistance: $minDistance
                    points: $points
                    border: $border
                """.trimIndent()
                assertEquals(expected, actual, message)
            }
        }
    }

    @Test
    fun reachesIterablePointTest() {
        val v1 = vectorOf(
            startX = 0.0,
            startY = 0.0,
            finishX = 2.0,
            finishY = 0.0,
        )
        val v2 = vectorOf(
            startX = 0.0,
            startY = 1.0,
            finishX = 2.0,
            finishY = 1.0,
        )
        val target = pointOf(
            x = 1.0,
            y = 3.24,
        )
        val vectors = listOf(v1, v2)
        setOf(
            1.0 to 17,
            2.0 to 17,
            2.23 to 17,
            2.25 to 2,
            2.26 to 2,
            3.0 to 0,
            4.0 to 0,
        ).forEach { (minDistance, border) ->
            for (points in 1..16) {
                if (points == border) continue
                val expected = points > border
                val actual = vectors.reaches(
                    target = target,
                    minDistance = minDistance,
                    points = points,
                )
                val message = """
                    vectors: $vectors
                    target: $target
                    minDistance: $minDistance
                    points: $points
                    border: $border
                """.trimIndent()
                assertEquals(expected, actual, message)
            }
        }
    }
}
