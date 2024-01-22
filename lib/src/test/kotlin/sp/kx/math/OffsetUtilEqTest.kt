package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.absoluteValue
import kotlin.math.pow

@Suppress("MagicNumber")
internal class OffsetUtilEqTest {
    @Test
    fun eqDeltaTest() {
        val value = 128.0001
        val other = 128.00010001
        assertOffsets(
            value = offsetOf(dX = value, dY = value),
            other = offsetOf(dX = other, dY = other),
            points = 4,
            equals = true,
        )
        assertOffsets(value = offsetOf(dX = value, dY = value), other = offsetOf(dX = other, dY = other), points = 1, equals = true)
        assertOffsets(value = offsetOf(dX = value, dY = value), other = offsetOf(dX = other, dY = other), points = 2, equals = true)
        assertOffsets(value = offsetOf(dX = value, dY = value), other = offsetOf(dX = other, dY = other), points = 4, equals = true)
        assertOffsets(value = offsetOf(dX = value, dY = value), other = offsetOf(dX = other, dY = other), points = 8, equals = false)
        val abs = (value - other).absoluteValue
        val delta = 10.0.pow(-4)
        assertOffsets(value = offsetOf(dX = abs, dY = abs), other = offsetOf(dX = delta, dY = delta), points = 4, equals = false)
    }

    @Test
    fun eqOneTest() {
        (1..8).forEach { points ->
            assertOffsets(
                value = offsetOf(dX = 0.0, dY = 0.0),
                other = offsetOf(dX = 10.0.pow(-points), dY = 0.0),
                points = points,
                equals = false,
            )
        }
    }

    @Test
    fun eqTest() {
        assertOffsets(
            value = offsetOf(dX = 9.1234567, dY = 9.123456789),
            other = offsetOf(dX = 9.123456789, dY = 9.123456789),
            points = 4,
            equals = true,
        )
        assertOffsets(
            value = offsetOf(dX = 9.12345, dY = 9.123456789),
            other = offsetOf(dX = 9.123456789, dY = 9.123456789),
            points = 6,
            equals = false,
        )
        assertOffsets(
            value = offsetOf(dX = 9.1234567, dY = 9.123456789),
            other = offsetOf(dX = 9.123456789, dY = 9.123456789),
            points = 8,
            equals = false,
        )
        assertOffsets(
            value = offsetOf(dX = 0.1234567, dY = 0.123456789),
            other = offsetOf(dX = 0.123456789, dY = 0.123456789),
            points = 8,
            equals = false,
        )
        assertOffsets(
            value = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.000000089, dY = 0.000000089),
            points = 7,
            equals = true,
        )
        assertOffsets(
            value = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.000000089, dY = 0.000000089),
            points = 8,
            equals = false,
        )
        assertOffsets(
            value = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.00000001, dY = 0.0),
            points = 7,
            equals = true,
        )
        assertOffsets(
            value = offsetOf(dX = 0.0, dY = 0.0),
            other = offsetOf(dX = 0.00000001, dY = 0.0),
            points = 8,
            equals = false,
        )
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        assertOffsets(value = actual, other = offsetOf(dX = 1.2, dY = 5.6), points = 1, equals = true)
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67), points = 2))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 1))
        Assertions.assertTrue(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 2))
    }

    @Test
    fun eqNotTest() {
        val actual = offsetOf(dX = 1.234, dY = 5.67)
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = -1.23, dY = 5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.23, dY = -5.67), points = 1))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.23, dY = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 3))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 4))
        Assertions.assertFalse(actual.eq(other = offsetOf(dX = 1.2356789, dY = 5.67891234), points = 8))
    }

    @Test
    fun eqErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = -1)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            @Suppress("IgnoredReturnValue")
            offsetOf(dX = 1.2, dY = 5.6).eq(other = offsetOf(dX = 1.2, dY = 5.6), points = 0)
        }
    }

    companion object {
        private fun assertOffsets(value: Offset, other: Offset, points: Int, equals: Boolean) {
            Assertions.assertEquals(equals, value.eq(other = other, points = points)) {
                val delta = 10.0.pow(points)
                val dXDiff = (value.dX - other.dX).absoluteValue
                val dYDiff = (value.dY - other.dY).absoluteValue
                val bX1 = BigDecimal(value.dX)
                val bX2 = BigDecimal(other.dX)
                val bXDiff = bX1 - bX2
                val bXDelta = BigDecimal(10).pow(points)
                val bXD = bXDiff * bXDelta
                """
                    points: $points
                    value: ${value.toString(points = 32)}(${value.toString(points = points)})
                    other: ${other.toString(points = 32)}(${other.toString(points = points)})
                    ---
                    bX1/1: ${bX1.setScale(1, RoundingMode.FLOOR)}
                    bX1/2: ${bX1.setScale(2, RoundingMode.FLOOR)}
                    bX1/4: ${bX1.setScale(4, RoundingMode.FLOOR)}
                    bX1/8: ${bX1.setScale(8, RoundingMode.FLOOR)}
                    bX1/12: ${bX1.setScale(12, RoundingMode.FLOOR)}
                    ---
                    bX2/1: ${bX2.setScale(1, RoundingMode.FLOOR)}
                    bX2/2: ${bX2.setScale(2, RoundingMode.FLOOR)}
                    bX2/4: ${bX2.setScale(4, RoundingMode.FLOOR)}
                    bX2/8: ${bX2.setScale(8, RoundingMode.FLOOR)}
                    bX2/12: ${bX2.setScale(12, RoundingMode.FLOOR)}
                    ---
                    dXDiff: ${dXDiff.toString(points = 32)}
                    dYDiff: ${dYDiff.toString(points = 32)}
                    10^$points: ${delta.toString(points = 32)}
                    ---
                    10^(-$points): ${10.0.pow(-points).toString(points = 32)}
                    dXDiff <= 10^(-$points): ${dXDiff <= 10.0.pow(-points)}
                    dXDiff < 10^(-$points): ${dXDiff < 10.0.pow(-points)}
                    ---
                    dXDiff * 10^$points: ${(dXDiff * delta).toString(points = 32)}(${(dXDiff * delta).toInt()})
                     - Math.round=${Math.round(dXDiff * delta).toInt()}
                     - Math.floor=${Math.floor(dXDiff * delta).toInt()}
                     - Math.ceil=${Math.ceil(dXDiff * delta).toInt()}
                    ---
                    bX1: $bX1
                    bX2: $bX2
                    bXDiff: $bXDiff
                    bXDelta: $bXDelta
                    bXDiff * bXDelta: $bXD (${bXD.toLong()}/${bXD <= BigDecimal.ZERO})
                    bXD/1: ${bXD.setScale(1, RoundingMode.FLOOR)}(${bXD.setScale(1, RoundingMode.FLOOR).toLong()})
                    bXD/2: ${bXD.setScale(2, RoundingMode.FLOOR)}
                    bXD/4: ${bXD.setScale(4, RoundingMode.FLOOR)}
                    bXD/8: ${bXD.setScale(8, RoundingMode.FLOOR)}
                    bXD/12: ${bXD.setScale(12, RoundingMode.FLOOR)}
                    ---
                    dYDiff * 10^$points: ${(dYDiff * delta).toString(points = 32)}(Math.round=${Math.round(dYDiff * delta).toInt()})(${(dYDiff * delta).toInt()})
                """.trimIndent()
            }
        }
    }
}
