package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

internal class ImmutableVectorOffsetMeasureTest {
    private data class DataSet(
        val actual: Vector,
        val expected: Vector,
        val offset: Offset,
        val magnitude: Double,
    )

    @Test
    fun vectorOfTest() {
        val issues = listOf(
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = -6.0, startY = -8.0, finishX = -6.0, finishY = -10.0),
                offset = offsetOf(dX = 1.0, dY = 1.0),
                magnitude = -2.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 4.0, finishY = 5.0),
                expected = vectorOf(startX = 0.5, startY = 2.5, finishX = 1.5, finishY = 3.5),
                offset = offsetOf(dX = -1.0, dY = 2.0),
                magnitude = 0.5,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                offset = Offset.Empty,
                magnitude = 1.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 4.0, finishY = 5.0),
                expected = vectorOf(startX = 8.0, startY = 4.0, finishX = 12.0, finishY = 8.0),
                offset = offsetOf(dX = 2.0, dY = -1.0),
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
                dX = it.offset.dX,
                dY = it.offset.dY,
                measure = measure,
            )
            Assertions.assertEquals(it.expected, actual) {
                "actual: $actual\noffset: ${it.offset}"
            }
        }
    }

    @Test
    fun vectorOfOffsetTest() {
        val issues = listOf(
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = -6.0, startY = -8.0, finishX = -6.0, finishY = -10.0),
                offset = offsetOf(dX = 1.0, dY = 1.0),
                magnitude = -2.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 4.0, finishY = 5.0),
                expected = vectorOf(startX = 0.5, startY = 2.5, finishX = 1.5, finishY = 3.5),
                offset = offsetOf(dX = -1.0, dY = 2.0),
                magnitude = 0.5,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                offset = Offset.Empty,
                magnitude = 1.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 4.0, finishY = 5.0),
                expected = vectorOf(startX = 8.0, startY = 4.0, finishX = 12.0, finishY = 8.0),
                offset = offsetOf(dX = 2.0, dY = -1.0),
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
                offset = it.offset,
                measure = measure,
            )
            Assertions.assertEquals(it.expected, actual) {
                "actual: $actual\noffset: ${it.offset}"
            }
        }
    }

    @Test
    fun vectorOfPointOffsetTest() {
        val issues = listOf(
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = -6.0, startY = -8.0, finishX = -6.0, finishY = -10.0),
                offset = offsetOf(dX = 1.0, dY = 1.0),
                magnitude = -2.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 4.0, finishY = 5.0),
                expected = vectorOf(startX = 0.5, startY = 2.5, finishX = 1.5, finishY = 3.5),
                offset = offsetOf(dX = -1.0, dY = 2.0),
                magnitude = 0.5,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                offset = Offset.Empty,
                magnitude = 1.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 4.0, finishY = 5.0),
                expected = vectorOf(startX = 8.0, startY = 4.0, finishX = 12.0, finishY = 8.0),
                offset = offsetOf(dX = 2.0, dY = -1.0),
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
                finish = it.actual.finish,
                offset = it.offset,
                measure = measure,
            )
            Assertions.assertEquals(it.expected, actual) {
                "actual: $actual\noffset: ${it.offset}"
            }
        }
    }

    @Test
    fun toVectorTest() {
        val issues = listOf(
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = -6.0, startY = -8.0, finishX = -6.0, finishY = -10.0),
                offset = offsetOf(dX = 1.0, dY = 1.0),
                magnitude = -2.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 4.0, finishY = 5.0),
                expected = vectorOf(startX = 0.5, startY = 2.5, finishX = 1.5, finishY = 3.5),
                offset = offsetOf(dX = -1.0, dY = 2.0),
                magnitude = 0.5,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                expected = vectorOf(startX = 2.0, startY = 3.0, finishX = 2.0, finishY = 4.0),
                offset = Offset.Empty,
                magnitude = 1.0,
            ),
            DataSet(
                actual = vectorOf(startX = 2.0, startY = 3.0, finishX = 4.0, finishY = 5.0),
                expected = vectorOf(startX = 8.0, startY = 4.0, finishX = 12.0, finishY = 8.0),
                offset = offsetOf(dX = 2.0, dY = -1.0),
                magnitude = 2.0,
            ),
        )
        check(issues.size == 4)
        check(issues.toSet().size == issues.size)
        issues.forEach {
            val measure = measureOf(magnitude = it.magnitude)
            val actual = it.actual.start.toVector(
                finish = it.actual.finish,
                offset = it.offset,
                measure = measure,
            )
            Assertions.assertEquals(it.expected, actual) {
                "actual: $actual\noffset: ${it.offset}"
            }
        }
    }
}
