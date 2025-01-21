package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

internal class SizeMeasureTest {
    @Test
    fun sizeOfTest() {
        val issues = listOf(
            Triple(sizeOf(1, 2), sizeOf(2, 4), 2.0),
            Triple(sizeOf(2, 3), sizeOf(4, 6), 2.0),
            Triple(sizeOf(3, 4), sizeOf(3, 4), 1.0),
            Triple(sizeOf(2, 4), sizeOf(1, 2), 0.5),
            Triple(sizeOf(1, 2), sizeOf(-2, -4), -2.0),
        )
        check(issues.size == 5)
        check(issues.toSet().size == issues.size)
        issues.forEach { (size, expected, magnitude) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = sizeOf(width = size.width, height = size.height, measure = measure)
            assertEquals(expected, actual)
        }
    }
}
