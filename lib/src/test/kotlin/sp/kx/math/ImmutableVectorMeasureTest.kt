package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

@Suppress("MagicNumber")
internal class ImmutableVectorMeasureTest {
    private data class DataSet(
        val actual: Vector,
        val expected: Vector,
        val magnitude: Double,
    )

    @Test
    fun vectorOfTest() {
        val issues = listOf(
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = -4.0, startY = -4.0, finishX = -4.0, finishY = -8.0),
                magnitude = -2.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 1.0, startY = 1.0, finishX = 1.0, finishY = 2.0),
                magnitude = 0.5,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                magnitude = 1.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 4.0, startY = 4.0, finishX = 4.0, finishY = 8.0),
                magnitude = 2.0,
            ),
        )
        check(issues.size == 4)
        check(issues.toSet().size == issues.size)
        issues.forEach { value ->
            val measure = measureOf(magnitude = value.magnitude)
            val actual = vectorOf(
                startX = value.actual.start.x,
                startY = value.actual.start.y,
                finishX = value.actual.finish.x,
                finishY = value.actual.finish.y,
                measure = measure,
            )
            Assertions.assertEquals(value.expected, actual)
        }
    }

    @Test
    fun vectorOfPointTest() {
        val issues = listOf(
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = -4.0, startY = -4.0, finishX = -4.0, finishY = -8.0),
                magnitude = -2.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 1.0, startY = 1.0, finishX = 1.0, finishY = 2.0),
                magnitude = 0.5,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                magnitude = 1.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 4.0, startY = 4.0, finishX = 4.0, finishY = 8.0),
                magnitude = 2.0,
            ),
        )
        check(issues.size == 4)
        check(issues.toSet().size == issues.size)
        issues.forEach { value ->
            val measure = measureOf(magnitude = value.magnitude)
            val actual = vectorOf(
                startX = value.actual.start.x,
                startY = value.actual.start.y,
                finish = value.actual.finish,
                measure = measure,
            )
            Assertions.assertEquals(value.expected, actual)
        }
    }

    @Test
    fun toVectorTest() {
        val issues = listOf(
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = -4.0, startY = -4.0, finishX = -4.0, finishY = -8.0),
                magnitude = -2.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 1.0, startY = 1.0, finishX = 1.0, finishY = 2.0),
                magnitude = 0.5,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                magnitude = 1.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 4.0, startY = 4.0, finishX = 4.0, finishY = 8.0),
                magnitude = 2.0,
            ),
        )
        check(issues.size == 4)
        check(issues.toSet().size == issues.size)
        issues.forEach { value ->
            val measure = measureOf(magnitude = value.magnitude)
            val actual = value.actual.start.toVector(
                x = value.actual.finish.x,
                y = value.actual.finish.y,
                measure = measure,
            )
            Assertions.assertEquals(value.expected, actual)
        }
    }

    @Test
    fun toVectorPointTest() {
        val issues = listOf(
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = -4.0, startY = -4.0, finishX = -4.0, finishY = -8.0),
                magnitude = -2.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 1.0, startY = 1.0, finishX = 1.0, finishY = 2.0),
                magnitude = 0.5,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                magnitude = 1.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 4.0, startY = 4.0, finishX = 4.0, finishY = 8.0),
                magnitude = 2.0,
            ),
        )
        check(issues.size == 4)
        check(issues.toSet().size == issues.size)
        issues.forEach { value ->
            val measure = measureOf(magnitude = value.magnitude)
            val actual = value.actual.start.toVector(
                finish = value.actual.finish,
                measure = measure,
            )
            Assertions.assertEquals(value.expected, actual)
        }
    }

    @Test
    fun mapTest() {
        val issues = listOf(
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = -4.0, startY = -4.0, finishX = -4.0, finishY = -8.0),
                magnitude = -2.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 1.0, startY = 1.0, finishX = 1.0, finishY = 2.0),
                magnitude = 0.5,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                magnitude = 1.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 2.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 4.0, startY = 4.0, finishX = 4.0, finishY = 8.0),
                magnitude = 2.0,
            ),
        )
        check(issues.size == 4)
        check(issues.toSet().size == issues.size)
        issues.forEach { value ->
            val measure = measureOf(magnitude = value.magnitude)
            val actual = value.actual.map(measure = measure)
            Assertions.assertEquals(value.expected, actual)
        }
    }
}
