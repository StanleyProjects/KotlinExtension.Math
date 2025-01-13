package sp.kx.math.unsafe

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sp.kx.math.toString
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
            val d1 = d - d.toLong() + (index % 4) * (if (index % 2 == 0) 1 else -1)
            val d2 = d1 - java.lang.Math.pow(10.0, -(index % 16).plus(1).toDouble())
            for (points in 1..16) {
                val diff = BigDecimal(d1).subtract(BigDecimal(d2))
                val scaled = diff.toDouble() * java.lang.Math.pow(10.0, points.toDouble())
                val round = java.lang.Math.round(scaled)
                val expected = diff
                    .scaleByPowerOfTen(points)
                    .setScale(0, RoundingMode.HALF_EVEN)
                    .toBigInteger()
                    .equals(BigInteger.ZERO)
                val message = """
                    size: $size
                    index: $index
                    d1: $d1
                    d2: $d2
                    points: $points
                    diff: $diff
                    scaled: $scaled (${scaled.toString(16)})
                    round: $round (${round.toString(16)})
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
            Triple(
                2.069444444445908,
                2.069444444445907,
                15,
            ),
        ).forEach { (v1, v2, border) ->
            for (points in 1..16) {
                val diff = BigDecimal(v1).subtract(BigDecimal(v2))
                val ds = diff.scaleByPowerOfTen(points)
                val scaled = diff.toDouble() * java.lang.Math.pow(10.0, points.toDouble())
                val round = java.lang.Math.round(scaled)
                val dr = ds.setScale(0, RoundingMode.HALF_EVEN)
                val di = dr.toBigInteger()
                val expected = di == BigInteger.ZERO
                val message = """
                    v1: $v1
                    v2: $v2
                    border: $border
                    points: $points
                    diff: $diff
                    ds: $ds
                    dr: $dr
                    di: $di
                    scaled: $scaled (${scaled.toString(16)})
                    round: $round (${round.toString(16)})
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

    @Test
    fun ltManyTest() {
        val salt = "fa377667-1b5c-4a02-a1c1-05203b7512d9".toByteArray()
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
                    .setScale(0, RoundingMode.HALF_EVEN)
                    .toBigInteger() < BigInteger.ZERO
                val message = """
                    size: $size
                    index: $index
                    d1: $d1
                    d2: $d2
                    points: $points
                    diff: $diff
                """.trimIndent()
                val actual = try {
                    lt(it = d1, other = d2, points = points)
                } catch (e: Throwable) {
                    throw IllegalStateException(message, e)
                }
                assertEquals(expected, actual, message)
            }
        }
    }

    @Test
    fun gtManyTest() {
        val salt = "9bed8c8c-064a-4cb4-9ceb-bad7d80040b3".toByteArray()
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
                    .setScale(0, RoundingMode.HALF_EVEN)
                    .toBigInteger() > BigInteger.ZERO
                val message = """
                    size: $size
                    index: $index
                    d1: $d1
                    d2: $d2
                    points: $points
                    diff: $diff
                """.trimIndent()
                val actual = try {
                    gt(it = d1, other = d2, points = points)
                } catch (e: Throwable) {
                    throw IllegalStateException(message, e)
                }
                assertEquals(expected, actual, message)
            }
        }
    }
}
