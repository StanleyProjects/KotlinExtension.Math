package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

internal class OffsetMeasureTest {
    @Test
    fun sizeOfTest() {
        val issues = listOf(
            Triple(offsetOf(1, 2), offsetOf(2, 4), 2.0),
            Triple(offsetOf(2, 3), offsetOf(4, 6), 2.0),
            Triple(offsetOf(3, 4), offsetOf(3, 4), 1.0),
            Triple(offsetOf(2, 4), offsetOf(1, 2), 0.5),
            Triple(offsetOf(1, 2), offsetOf(-2, -4), -2.0),
        )
        check(issues.size == 5)
        check(issues.toSet().size == issues.size)
        issues.forEach { (offset: Offset, expected, magnitude) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = offsetOf(dX = offset.dX, dY = offset.dY, measure = measure)
            assertEquals(expected, actual)
        }
    }
}
