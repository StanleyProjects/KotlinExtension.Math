package sp.kx.math.unsafe

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sp.kx.math.toString
import java.math.BigDecimal
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
            val f = p1.toDouble() / p2 + (index % 4)
            val s1 = if (index % 4 == 0) -1 else 1
            val v1 = f * s1
            val border = index % 16
            val p = java.lang.Math.pow(10.0, -border.toDouble())
            val s2 = if (index % 5 == 0) -1 else 1
            val v2 = (f + p) * s2
            for (points in 1..16) {
                if (points == border) continue
                val e = java.lang.Math.pow(10.0, points.toDouble())
                val diff = v1 - v2
                val b1 = BigDecimal.valueOf(v1)
                    .setScale(points, RoundingMode.DOWN)
                val b2 = BigDecimal.valueOf(v2)
                    .setScale(points, RoundingMode.DOWN)
//                val expected = b1 == b2
                val expected = if (points > border) {
                    false
                } else if (s1 == s2) {
                    true
                } else {
                    b1 == b2
                }
//                val expected = s1 == s2 && points < border
                val message = """
                    size: $size
                    index: $index
                    border: $border
                    points: $points
                    v1: $v1 (${v1.toString(24)})
                    v2: $v2 (${v2.toString(24)})
                    e: $e (${e.toString(24)})
                    diff: $diff (${diff.toString(24)})
                    diff * e = ${diff * e}
                    dl = ${(diff * e).toLong()}
                    b1: $b1
                    b2: $b2
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
    fun eqTensTest() {
        (1..16).forEach { points ->
            var v1 = java.lang.Math.pow(10.0, -points.toDouble())
            if (points > 4) v1 *= 1.1
            val v2 = 0.0
            val e = java.lang.Math.pow(10.0, points.toDouble())
            val d1 = v1 * e
            val d2 = v2 * e
            val l1 = d1.toLong()
            val l2 = d2.toLong()
            val r1 = java.lang.Math.round(d1)
            val r2 = java.lang.Math.round(d2)
            val f1 = java.lang.Math.floor(d1)
            val f2 = java.lang.Math.floor(d2)
            val expected = false
            val message = """
                v1: $v1 (${v1.toString(24)})
                v2: $v2 (${v2.toString(24)})
                d1: $d1 (${d1.toString(24)})
                d2: $d2 (${d2.toString(24)})
                l1: $l1
                l2: $l2
                r1: $r1
                r2: $r2
                f1: $f1 (${f1.toString(24)})
                f2: $f2 (${f2.toString(24)})
                points: $points
                expected: $expected
            """.trimIndent()
            assertEquals(expected, eq(it = v1, other = v2, points = points), message)
            assertEquals(expected, eq(it = v1 * -1, other = v2, points = points), message)
        }
    }

    @Test
    fun eqTest() {
        val issues = listOf(
            Triple(0.9, -0.9, 1),
            Triple(0.09, -0.09, 2),
            Triple(0.009, -0.009, 3),
            Triple(0.0009, -0.0009, 4),
            Triple(3.062500000652571, 3.0625000006525718, 16),
            Triple(3.1225000011575728, 3.1225000011575736, 15),
            Triple(java.lang.Math.pow(10.0, -4.0), 0.0, 4),
            Triple(-java.lang.Math.pow(10.0, -4.0), 0.0, 4),
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
        )
        for ((v1, v2, border) in issues) {
            for (points in 1..16) {
                if (points == border) break
                val e = java.lang.Math.pow(10.0, points.toDouble())
                val diff = java.lang.Math.abs(v1 - v2)
                val de = diff * e
                val dl = de.toLong()
                val expected = points < border
                val message = """
                    v1: $v1 (${v1.toString(24)})
                    v2: $v2 (${v2.toString(24)})
                    e: $e (${e.toString(24)})
                    v1 - v2 = $diff (${diff.toString(24)})
                    diff * e = $de (${de.toString(24)})
                    dl: $dl
                    border: $border
                    points: $points
                    expected: $expected
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
            val f = p1.toDouble() / p2 + (index % 4)
            val s1 = if (index % 4 == 0) -1 else 1
//            val s1 = 1
            val v1 = f * s1
            val border = index % 16
            val p = java.lang.Math.pow(10.0, -border.toDouble())
//            val s2 = if (index % 5 == 0) -1 else 1
            val s2 = 1
            val v2 = (f + p) * s2
            for (points in 1..16) {
                if (points == border) continue
                val e = java.lang.Math.pow(10.0, points.toDouble())
                val diff = v1 - v2
                val b1 = BigDecimal.valueOf(v1)
                    .setScale(points, RoundingMode.DOWN)
                val b2 = BigDecimal.valueOf(v2)
                    .setScale(points, RoundingMode.DOWN)
                val expected = if (points < border) {
                    s1 < s2 && b1 < b2
                } else if (s1 == s2) {
                    true
                } else {
                    b1 < b2
                }
                val message = """
                    size: $size
                    index: $index
                    border: $border
                    points: $points
                    v1: $v1 (${v1.toString(24)})
                    v2: $v2 (${v2.toString(24)})
                    s1: $s1
                    s2: $s2
                    e: $e (${e.toString(24)})
                    diff: $diff (${diff.toString(24)})
                    diff * e = ${diff * e}
                    dl = ${(diff * e).toLong()}
                    b1: $b1
                    b2: $b2
                """.trimIndent()
                val actual = try {
                    lt(it = v1, other = v2, points = points)
                } catch (e: Throwable) {
                    throw IllegalStateException(message, e)
                }
                assertEquals(expected, actual, message)
            }
        }
    }

    @Test
    fun ltTest() {
        val issues = listOf(
            Triple(-0.03282828284424402, 0.032928282844244025, 2),
            Triple(2.063137755122162, 2.0731377551221617, 2),
            Triple(3.063788659796652, 3.063788659806652, 10),
        )
        for ((v1, v2, border) in issues) {
            for (points in 1..16) {
                if (points == border) continue
                val e = java.lang.Math.pow(10.0, points.toDouble())
                val diff = java.lang.Math.abs(v1 - v2)
                val de = diff * e
                val dl = de.toLong()
                val expected = points > border
                val message = """
                    v1: $v1 (${v1.toString(24)})
                    v2: $v2 (${v2.toString(24)})
                    e: $e (${e.toString(24)})
                    v1 - v2 = $diff (${diff.toString(24)})
                    diff * e = $de (${de.toString(24)})
                    dl: $dl
                    border: $border
                    points: $points
                    expected: $expected
                """.trimIndent()
                val actual = try {
                    lt(it = v1, other = v2, points = points)
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
            val f = p1.toDouble() / p2 + (index % 4)
            val s1 = if (index % 4 == 0) -1 else 1
//            val s1 = 1
            val v1 = f * s1
            val border = index % 16
            val p = java.lang.Math.pow(10.0, -border.toDouble())
//            val s2 = if (index % 5 == 0) -1 else 1
            val s2 = 1
            val v2 = (f - p) * s2
            for (points in 1..16) {
                if (points == border) continue
                val e = java.lang.Math.pow(10.0, points.toDouble())
                val diff = v1 - v2
                val b1 = BigDecimal.valueOf(v1)
                    .setScale(points, RoundingMode.DOWN)
                val b2 = BigDecimal.valueOf(v2)
                    .setScale(points, RoundingMode.DOWN)
                val expected = if (points < border) {
                    false
                } else if (s1 == s2) {
                    true
                } else {
                    b1 > b2
                }
                val message = """
                    size: $size
                    index: $index
                    border: $border
                    points: $points
                    v1: $v1 (${v1.toString(24)})
                    v2: $v2 (${v2.toString(24)})
                    s1: $s1
                    s2: $s2
                    e: $e (${e.toString(24)})
                    diff: $diff (${diff.toString(24)})
                    diff * e = ${diff * e}
                    dl = ${(diff * e).toLong()}
                    b1: $b1
                    b2: $b2
                """.trimIndent()
                val actual = try {
                    gt(it = v1, other = v2, points = points)
                } catch (e: Throwable) {
                    throw IllegalStateException(message, e)
                }
                assertEquals(expected, actual, message)
            }
        }
    }

    @Test
    fun gtTest() {
        val issues = listOf(
            Triple(0.9, -0.9, 1),
            Triple(0.09, -0.09, 2),
            Triple(0.009, -0.009, 3),
            Triple(0.0009, -0.0009, 4),
            Triple(-0.11074561400449934, -0.8892543859955007, 1),
            Triple(3.0625000006525718, 3.062500000652571, 16),
            Triple(3.1225000011575736, 3.1225000011575728, 15),
        )
        for ((v1, v2, border) in issues) {
            for (points in 1..16) {
                if (points == border) continue
                val e = java.lang.Math.pow(10.0, points.toDouble())
                val diff = v1 - v2
                val de = diff * e
                val dl = de.toLong()
                val expected = points > border
                val message = """
                    v1: $v1 (${v1.toString(24)})
                    v2: $v2 (${v2.toString(24)})
                    e: $e (${e.toString(24)})
                    v1 - v2 = $diff (${diff.toString(24)})
                    diff * e = $de (${de.toString(24)})
                    dl: $dl
                    border: $border
                    points: $points
                    expected: $expected
                """.trimIndent()
                val actual = try {
                    gt(it = v1, other = v2, points = points)
                } catch (e: Throwable) {
                    throw IllegalStateException(message, e)
                }
                assertEquals(expected, actual, message)
            }
        }
    }
}
