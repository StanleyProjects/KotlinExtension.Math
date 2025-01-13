package sp.kx.math.unsafe

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import sp.kx.math.toString
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
    fun eqTest() {
        val v1 = 0.12
        val v2 = 0.10
        assertNotEquals(v1, v2)
        assertEquals(v1, v2, 0.1)
        assertNotEquals(v1, v2, 0.01)
        val message = """
            v1: $v1
            v2: $v2
        """.trimIndent()
        assertTrue(eq(it = v1, other = v2, points = 1), message)
        assertFalse(eq(it = v1, other = v2, points = 2), message)
    }
}
