package sp.kx.math.measure

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import sp.kx.math.toString

internal class DoubleMeasureOperatorsTest {
    @Test
    fun timesDoubleTest() {
        val m1 = measureOf(magnitude = 1.2)
        assertEquals(1.2, m1.magnitude)
        listOf(
            Triple(-1.0, -1.2, false),
            Triple(0.0, 0.0, false),
            Triple(1.0, 1.2, true),
            Triple(2.0, 2.4, false),
            Triple(7.8, 9.36, false),
        ).forEach { (value: Double, expected: Double, equals: Boolean) ->
            val m2: Measure<Double, Double> = m1 * value
            val message = """
                m1: $m1
                m2: $m2
                value: $value
                expected: $expected
            """.trimIndent()
            assertEquals(expected, m2.magnitude, message)
            assertEquals(m1.magnitude * value, m2.magnitude)
            if (equals) {
                assertEquals(m1.magnitude, m2.magnitude)
                assertEquals(m1, m2)
            } else {
                assertNotEquals(m1.magnitude, m2.magnitude)
                assertNotEquals(m1, m2)
            }
        }
    }

    @Test
    fun divDoubleTest() {
        val m1 = measureOf(magnitude = 1.2)
        assertEquals(1.2, m1.magnitude)
        listOf(
            Triple(-1.0, -1.2, false),
            Triple(-0.5, -2.4, false),
//            Triple(0.0, 0.0, false),
            Triple(0.5, 2.4, false),
            Triple(1.0, 1.2, true),
            Triple(2.0, 0.6, false),
            Triple(3.0, 0.4, false),
            Triple(6.0, 0.2, false),
        ).forEach { (value: Double, expected: Double, equals: Boolean) ->
            val m2: Measure<Double, Double> = m1 / value
            val message = """
                m1: $m1
                m2: $m2
                value: $value
                expected: $expected
            """.trimIndent()
            val delta = 0.00000001
            assertEquals(expected, m2.magnitude, delta, message)
            assertEquals(m1.magnitude / value, m2.magnitude, delta, message)
            if (equals) {
                assertEquals(m1.magnitude, m2.magnitude, delta)
                assertEquals(m1, m2)
            } else {
                assertNotEquals(m1.magnitude, m2.magnitude, delta)
                assertNotEquals(m1, m2)
            }
        }
    }

    @Test
    fun timesMeasureTest() {
        val v1 = 1.2
        val delta = 0.00000001
        assertEquals(1.2, v1, delta)
        listOf(
            Triple(-1.0, -1.2, false),
            Triple(0.0, 0.0, false),
            Triple(1.0, 1.2, true),
            Triple(2.0, 2.4, false),
            Triple(7.8, 9.36, false),
        ).forEach { (magnitude: Double, expected: Double, equals: Boolean) ->
            val measure = measureOf(magnitude = magnitude)
            val v2 = v1 * measure
            val message = """
                v1: $v1 (${v1.toString(24)})
                v2: $v2 (${v2.toString(24)})
                magnitude: $magnitude
                expected: $expected
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected, v2, delta, message)
            assertEquals(v1 * magnitude, v2, delta)
            if (equals) {
                assertEquals(v1, v2, delta)
            } else {
                assertNotEquals(v1, v2, delta)
            }
        }
    }

    @Test
    fun divMeasureTest() {
        val v1 = 1.2
        val delta = 0.00000001
        assertEquals(1.2, v1, delta)
        listOf(
            Triple(-1.0, -1.2, false),
            Triple(-0.5, -2.4, false),
//            Triple(0.0, 0.0, false),
            Triple(0.5, 2.4, false),
            Triple(1.0, 1.2, true),
            Triple(2.0, 0.6, false),
            Triple(3.0, 0.4, false),
            Triple(6.0, 0.2, false),
        ).forEach { (magnitude: Double, expected: Double, equals: Boolean) ->
            val measure = measureOf(magnitude = magnitude)
            val v2 = v1 / measure
            val message = """
                v1: $v1 (${v1.toString(24)})
                v2: $v2 (${v2.toString(24)})
                magnitude: $magnitude
                expected: $expected
                delta: $delta (${delta.toString(24)})
            """.trimIndent()
            assertEquals(expected, v2, delta, message)
            assertEquals(v1 / magnitude, v2, delta)
            if (equals) {
                assertEquals(v1, v2, delta)
            } else {
                assertNotEquals(v1, v2, delta)
            }
        }
    }
}
