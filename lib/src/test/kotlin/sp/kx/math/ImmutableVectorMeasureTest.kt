package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

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
        issues.forEach {
            val measure = measureOf(magnitude = it.magnitude)
            val actual = vectorOf(
                startX = it.actual.start.x,
                startY = it.actual.start.y,
                finishX = it.actual.finish.x,
                finishY = it.actual.finish.y,
                measure = measure,
            )
            Assertions.assertEquals(it.expected, actual)
        }
    }

    @Test
    fun vectorOfPointTest() {
        TODO("${this::class.java.name}:vectorOfPointTest")
    }

    @Test
    fun toVectorTest() {
        TODO("${this::class.java.name}:toVectorTest")
    }

    @Test
    fun toVectorPointTest() {
        TODO("${this::class.java.name}:toVectorPointTest")
    }

    @Test
    fun mapTest() {
        TODO("${this::class.java.name}:mapTest")
    }
}
