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
            Triple(1.0, 12, false),
            Triple(1.0, 6, false),
            Triple(1.0, 1, false),
            Triple(2.0, 12, false),
            Triple(2.0, 6, false),
            Triple(2.0, 1, false),
            Triple(2.25, 1, false),
            Triple(2.25, 2, true),
            Triple(3.0, 12, true),
            Triple(3.0, 6, true),
            Triple(3.0, 1, true),
        ).forEach { (minDistance, points, expected) ->
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
            """.trimIndent()
            assertEquals(expected, actual, message)
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
            Triple(1.0, 12, false),
            Triple(1.0, 6, false),
            Triple(1.0, 1, false),
            Triple(2.0, 12, false),
            Triple(2.0, 6, false),
            Triple(2.0, 1, false),
            Triple(2.25, 1, false),
            Triple(2.25, 2, true),
            Triple(3.0, 12, true),
            Triple(3.0, 6, true),
            Triple(3.0, 1, true),
        ).forEach { (minDistance, points, expected) ->
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
            """.trimIndent()
            assertEquals(expected, actual, message)
        }
    }

    @Test
    fun ltIterableTest() {
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
            Triple(1.0, 12, false),
            Triple(1.0, 6, false),
            Triple(1.0, 1, false),
            Triple(2.0, 12, false),
            Triple(2.0, 6, false),
            Triple(2.0, 1, false),
            Triple(2.25, 1, false),
            Triple(2.25, 2, true),
            Triple(3.0, 12, true),
            Triple(3.0, 6, true),
            Triple(3.0, 1, true),
        ).forEach { (minDistance, points, expected) ->
            val actual = vectors.lt(
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
            """.trimIndent()
            assertEquals(expected, actual, message)
        }
    }

    @Test
    fun ltIterablePointTest() {
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
            Triple(1.0, 12, false),
            Triple(1.0, 6, false),
            Triple(1.0, 1, false),
            Triple(2.0, 12, false),
            Triple(2.0, 6, false),
            Triple(2.0, 1, false),
            Triple(2.25, 1, false),
            Triple(2.25, 2, true),
            Triple(3.0, 12, true),
            Triple(3.0, 6, true),
            Triple(3.0, 1, true),
        ).forEach { (minDistance, points, expected) ->
            val actual = vectors.lt(
                target = target,
                minDistance = minDistance,
                points = points,
            )
            val message = """
                vectors: $vectors
                target: $target
                minDistance: $minDistance
                points: $points
            """.trimIndent()
            assertEquals(expected, actual, message)
        }
    }
}
