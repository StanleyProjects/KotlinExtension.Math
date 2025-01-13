package sp.kx.math.unsafe

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import kotlin.math.absoluteValue

internal class NumberUnsafeTest {
    @Test
    fun eqManyTest() {
        val salt = "f73c2de5-528b-4cf1-92d5-fd922b43785c".toByteArray()
        val hashCode = salt.contentHashCode()
        val size: Int = 8_000
        for (index in 0 until size) {
            val number = hashCode * size + index + 13
            val l1 = salt[(number + 1).absoluteValue % salt.size].toLong()
            val l2 = salt[(number - 1).absoluteValue % salt.size].toLong()
            val p1 = l1 * hashCode * 1.shl(12) / size + 13 - index
            val p2 = l2 * hashCode * 1.shl(16) / size + 13 - index
            val d = p1.toDouble() / p2
            val d1 = d - d.toLong() + (index % 4)
            val d2 = d1 - java.lang.Math.pow(10.0, -(index % 16).plus(1).toDouble())
            for (points in 1..16) {
                val diff = BigDecimal(d1).subtract(BigDecimal(d2))
                val expected = diff
                    .scaleByPowerOfTen(points)
                    .setScale(1, RoundingMode.HALF_EVEN)
                    .toBigInteger()
                    .equals(BigInteger.ZERO)
                val message = """
                    size: $size
                    index: $index
                    d1: $d1
                    d2: $d2
                    points: $points
                    diff: $diff
                """.trimIndent()
                val actual = try {
                    eq(it = d1, other = d2, points = points)
                } catch (e: Throwable) {
                    throw IllegalStateException(message, e)
                }
                assertEquals(expected, actual, message)
            }
        }
    }

    @Test
    fun eqTest() {
        listOf(
            Triple(0.12, 0.10, 2),
            Triple(
                0.06944444443148837,
                0.06943444443148837,
                5,
            ),
        ).forEach { (v1, v2, border) ->
            for (points in 1..16) {
                val diff = BigDecimal(v1).subtract(BigDecimal(v2))
                val expected = diff
                    .scaleByPowerOfTen(points)
                    .setScale(1, RoundingMode.HALF_EVEN)
                    .toBigInteger()
                    .equals(BigInteger.ZERO)
                val message = """
                    v1: $v1
                    v2: $v2
                    border: $border
                    points: $points
                    diff: $diff
                """.trimIndent()
                val actual = try {
                    eq(it = v1, other = v2, points = points)
                } catch (e: Throwable) {
                    throw IllegalStateException(message, e)
                }
                assertEquals(expected, actual, message)
            }
        }
    }
}
