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
            val fraction = p1.toDouble() / p2
            val d = fraction - fraction.toLong()
            val d1 = d + (index % 4) * (if (index % 4 == 0) -1 else 1)
            val e = 1.0 / java.lang.Math.pow(10.0, (index % 16).toDouble())
            val d2 = d1 * (if (index % 5 == 0) -1 else 1) + e
            for (points in 1..16) {
                val diff = d1 - d2
                val de = diff * java.lang.Math.pow(10.0, points.toDouble())
                val b1 = BigDecimal.valueOf(d1)
                    .scaleByPowerOfTen(points)
                    .toBigInteger()
                val b2 = BigDecimal.valueOf(d2)
                    .scaleByPowerOfTen(points)
                    .toBigInteger()
                val expected = b1 == b2
                val message = """
                    size: $size
                    index: $index
                    e: $e (${e.toString(24)})
                    d1: $d1 (${d1.toString(24)})
                    d2: $d2 (${d2.toString(24)})
                    b1: $b1
                    b2: $b2
                    points: $points
                    diff: $diff (${diff.toString(24)})
                    de: $de (${de.toString(24)})
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
            Triple(3.0624999999865143, 3.0634999999865142, 3),
            Triple(0.06944444448339876, -0.06944443448339876, 2),
            Triple(0.1, 0.09, 1),
            Triple(0.11, 0.19, 2),
            Triple(5.6, 5.67, 2),
            Triple(5.59, 5.67, 1),
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
            Triple(
                2.069444444445907,
                2.069444444445908,
                15,
            ),
            Triple(
                2.069444444445079,
                2.06944444444507,
                15,
            ),
            Triple(
                2.122499999991322,
                2.1225009999913222,
                4,
            ),
            Triple(
                0.1262499999828202,
                0.8737500000171798,
                1,
            ),
            Triple(
                4.56444444,
                4.56,
                3,
            ),
        ).forEach { (d1, d2, border) ->
            for (points in 1..16) {
                val b1 = BigDecimal(d1)
                val b2 = BigDecimal(d2)
                val s1 = b1.scaleByPowerOfTen(points)
                val s2 = b2.scaleByPowerOfTen(points)
                val i1 = s1.toBigInteger()
                val i2 = s2.toBigInteger()
                val expected = points < border
                val message = """
                    d1: $d1 (${d1.toString(24)})
                    d2: $d2 (${d2.toString(24)})
                    b1: $b1
                    b2: $b2
                    s1: $s1
                    s2: $s2
                    i1: $i1
                    i2: $i2
                    border: $border
                    points: $points
                    expected: $expected
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
            val fraction = p1.toDouble() / p2
            val d = fraction - fraction.toLong()
            val d1 = d + (index % 4) * (if (index % 4 == 0) -1 else 1)
            val e = 1.0 / java.lang.Math.pow(10.0, (index % 16).toDouble())
            val d2 = d1 * (if (index % 5 == 0) -1 else 1) + e
            for (points in 1..16) {
                val diff = d1 - d2
                val de = diff * java.lang.Math.pow(10.0, points.toDouble())
                val b1 = BigDecimal.valueOf(d1)
                    .scaleByPowerOfTen(points)
                    .toBigInteger()
                val b2 = BigDecimal.valueOf(d2)
                    .scaleByPowerOfTen(points)
                    .toBigInteger()
                val expected = b1 < b2
                val message = """
                    size: $size
                    index: $index
                    e: $e (${e.toString(24)})
                    d1: $d1 (${d1.toString(24)})
                    d2: $d2 (${d2.toString(24)})
                    b1: $b1
                    b2: $b2
                    points: $points
                    diff: $diff (${diff.toString(24)})
                    de: $de (${de.toString(24)})
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
                val b1 = BigDecimal.valueOf(d1)
                val b2 = BigDecimal.valueOf(d2)
                val p1 = b1.scaleByPowerOfTen(points)
                val p2 = b2.scaleByPowerOfTen(points)
                val s1 = b1.setScale(points, RoundingMode.DOWN)
                val s2 = b2.setScale(points, RoundingMode.DOWN)
                val e = java.lang.Math.pow(10.0, points.toDouble())
                val f1 = d1 * e
                val f2 = d2 * e
                val f3 = f1 - f2
                val expected = s1 > s2
                val message = """
                    size: $size
                    index: $index
                    d1: $d1 (${d1.toString(24)})
                    d2: $d2 (${d2.toString(24)})
                    p1: $p1
                    p2: $p2
                    p1: ${p1.divideAndRemainder(BigDecimal.ONE).toList()}
                    p2: ${p2.divideAndRemainder(BigDecimal.ONE).toList()}
                    s1: $s1
                    s2: $s2
                    e: $e (${e.toString(24)})
                    f1: $f1 (${f1.toString(24)})
                    f2: $f2 (${f2.toString(24)})
                    f3: $f3 (${f3.toString(24)})
                    points: $points
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

    @Test
    fun gtTest() {
        listOf(
            Triple(2.1122685185095014, 2.1122685184995014, 10),
            Triple(2.062500000261851, 2.06250000026185, 15),
            Triple(1.0637755101863098, 1.0537755101863098, 2),
            Triple(0.03000000007189047, -0.06999999992810954, 2),
            Triple(0.028698979594767485, -0.07130102040523252, 2),
        ).forEach { (d1, d2, border) ->
            for (points in 1..16) {
                val b1 = BigDecimal.valueOf(d1)
                val b2 = BigDecimal.valueOf(d2)
                val p1 = b1.scaleByPowerOfTen(points)
                val p2 = b2.scaleByPowerOfTen(points)
                val s1 = b1.setScale(points, RoundingMode.DOWN)
                val s2 = b2.setScale(points, RoundingMode.DOWN)
                val expected = points >= border
                val e = java.lang.Math.pow(10.0, points.toDouble())
                val f1 = d1 * e
                val f2 = d2 * e
                val f3 = f1 - f2
                val message = """
                    d1: $d1 (${d1.toString(24)})
                    d2: $d2 (${d2.toString(24)})
                    b1: $b1
                    b2: $b2
                    p1: $p1
                    p2: $p2
                    s1: $s1
                    s2: $s2
                    border: $border
                    points: $points
                    expected: $expected
                    e: $e (${e.toString(24)})
                    f1: $f1 (${f1.toString(24)})
                    f2: $f2 (${f2.toString(24)})
                    f3: $f3 (${f3.toString(24)})
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
