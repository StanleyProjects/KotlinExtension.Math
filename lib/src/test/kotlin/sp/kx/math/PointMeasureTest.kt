package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

@Suppress("MagicNumber")
internal class PointMeasureTest {
    @Test
    fun pointOfTest() {
        val issues = listOf(
            Triple(pointOf(1, 2), pointOf(2, 4), 2.0),
            Triple(pointOf(2, 3), pointOf(4, 6), 2.0),
            Triple(pointOf(3, 4), pointOf(3, 4), 1.0),
            Triple(pointOf(2, 4), pointOf(1, 2), 0.5),
            Triple(pointOf(1, 2), pointOf(-2, -4), -2.0),
        )
        check(issues.size == 5)
        check(issues.toSet().size == issues.size)
        issues.forEach { (point, expected, magnitude) ->
            val measure = measureOf(magnitude = magnitude)
            val actual = pointOf(x = point.x, y = point.y, measure = measure)
            Assertions.assertEquals(expected, actual)
        }
    }
}
