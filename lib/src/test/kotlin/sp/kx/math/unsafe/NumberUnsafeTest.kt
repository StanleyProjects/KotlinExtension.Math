package sp.kx.math.unsafe

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import sp.kx.math.toString
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import kotlin.math.absoluteValue
import kotlin.random.Random

internal class NumberUnsafeTest {
    @Test
    fun fooTest() {
//        val min = java.lang.Math.nextUp(0.0)
//        val min = 0.0000000000000001
//        val min = 0.00000001
        val min = 1.0 * java.lang.Math.pow(10.0, -4.0)
        val max = java.lang.Math.nextDown(1.0)
        val minBits = java.lang.Double.doubleToRawLongBits(min)
        val maxBits = java.lang.Double.doubleToRawLongBits(max)
        // 4607182418800017407
        val bits = Random.nextLong(maxBits - minBits) + minBits
//        val bits = 1L shl 60
        val d1 = java.lang.Double.longBitsToDouble(bits)
        val s = if (bits.shr(63) == 0L) 1 else -1
        val e = bits.shr(52) and 0x7ffL
        val m = if (e == 0L) bits.and(0xfffffffffffffL).shl(1) else bits.and(0xfffffffffffffL).or(0x10000000000000L)
        val message = """
            min: $min
            max: $max
            minBits: $minBits (${java.lang.Long.toBinaryString(minBits)})
            maxBits: $maxBits (${java.lang.Long.toBinaryString(maxBits)})
            bits: $bits
            s: $s
            e: $e
            m: $m
            d1: $d1
            d1: ${d1.toString(points = 16)}
        """.trimIndent()
        error(message)
    }

    @Test
    fun eqManyTest() {
        val salt = "f73c2de5-528b-4cf1-92d5-fd922b43785c".toByteArray()
        val hashCode = salt.contentHashCode()
        val min: Long = java.lang.Double.doubleToRawLongBits(1.0 * java.lang.Math.pow(10.0, -8.0))
        val max: Long = java.lang.Double.doubleToRawLongBits(java.lang.Math.nextDown(1.0))
        val size: Int = 8_000
//        val doubles = (0..10).map { index ->
//            val number = hashCode * size + index + 13
//            val l1 = salt[(number + 1).absoluteValue % salt.size].toLong()
//            val l2 = salt[(number - 1).absoluteValue % salt.size].toLong()
//            val p1 = l1 * hashCode * 1.shl(12) / size + 13 - index
//            val p2 = l2 * hashCode * 1.shl(16) / size + 13 - index
//            val d = p1.toDouble() / p2
//            val d1 = d - d.toLong()
//            val d2 = d1 - java.lang.Math.pow(10.0, -(index % 16).plus(1).toDouble())
//            d1 to d2
//        }
//        error(doubles.joinToString(separator = "\n") { (d1, d2) -> "d1: $d1 (${d1.toString(points = 16)})\nd2: $d2 (${d2.toString(points = 16)})" })
        for (index in 0 until size) {
            val number = hashCode * size + index + 13
            val l1 = salt[(number + 1).absoluteValue % salt.size].toLong()
            val l2 = salt[(number - 1).absoluteValue % salt.size].toLong()
            val p1 = l1 * hashCode * 1.shl(12) / size + 13 - index
            val p2 = l2 * hashCode * 1.shl(16) / size + 13 - index
            val d = p1.toDouble() / p2
            val d1 = d - d.toLong()
            val d2 = d1 - java.lang.Math.pow(10.0, -(index % 16).plus(1).toDouble())
            for (points in 1..16) {
                val delta = java.lang.Math.pow(10.0, -points.toDouble())
                val diff = java.lang.Math.abs(d1 - d2)
                val message = """
                    size: $size
                    index: $index
                    d1: $d1
                    d2: $d2
                    points: $points
                    delta: $delta
                    diff: $diff (${diff.toString(points = 16)})
                """.trimIndent()
                val actual = try {
                    eq(it = d1, other = d2, points = points)
                } catch (e: Throwable) {
                    throw IllegalStateException(message, e)
                }
                assertEquals(diff < delta, actual, message)
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
