package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.absoluteValue
import kotlin.math.pow

@Suppress("MagicNumber")
internal class VectorIsEmptyTest {
    @Test
    fun isEmptyTest() {
        (pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)).also { vector: Vector ->
            Assertions.assertFalse(vector.isEmpty())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1.1, y = 1.0)).also { vector: Vector ->
            Assertions.assertFalse(vector.isEmpty())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = 1)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty())
        }
        (pointOf(x = -1, y = -1) + pointOf(x = -1.0, y = -1.0)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty())
        }
    }

    @Test
    fun isEmptyPointsTest() {
        (pointOf(x = 1.2, y = 3.4) + pointOf(x = 1.25, y = 3.46)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty(points = 1))
            Assertions.assertFalse(vector.isEmpty(points = 2))
        }
        (pointOf(x = 1.01, y = 1.0) + pointOf(x = 1.0, y = 1.0)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty(points = 1))
            Assertions.assertFalse(vector.isEmpty(points = 2))
            Assertions.assertFalse(vector.isEmpty(points = 4))
            Assertions.assertFalse(vector.isEmpty(points = 8))
            Assertions.assertFalse(vector.isEmpty(points = 16))
        }
        (pointOf(x = 1.001, y = 1.0) + pointOf(x = 1.0, y = 1.0)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty(points = 1))
            Assertions.assertTrue(vector.isEmpty(points = 2))
            assertIsEmpty(vector = vector, points = 3, isEmpty = false)
            Assertions.assertFalse(vector.isEmpty(points = 4))
            Assertions.assertFalse(vector.isEmpty(points = 8))
            Assertions.assertFalse(vector.isEmpty(points = 16))
        }
        (pointOf(x = 1.00000001, y = 1.0) + pointOf(x = 1.0, y = 1.0)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty(points = 1))
            Assertions.assertTrue(vector.isEmpty(points = 2))
            Assertions.assertTrue(vector.isEmpty(points = 3))
            Assertions.assertTrue(vector.isEmpty(points = 4))
            assertIsEmpty(vector = vector, points = 8, isEmpty = false)
            Assertions.assertFalse(vector.isEmpty(points = 16))
        }
    }

    @Test
    fun isEmptyErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val foo = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
            @Suppress("IgnoredReturnValue")
            foo.isEmpty(points = 0)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val foo = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
            @Suppress("IgnoredReturnValue")
            foo.isEmpty(points = -1)
        }
    }

    companion object {
        private fun assertIsEmpty(vector: Vector, points: Int, isEmpty: Boolean) {
            Assertions.assertEquals(isEmpty, vector.isEmpty(points = points)) {
                val delta = 10.0.pow(points)
                val value = vector.start.x
                val other = vector.finish.x
                val diff = (value - other).absoluteValue
                val bX1 = BigDecimal(value)
                val bX2 = BigDecimal(other)
                val bXDiff = bX1 - bX2
                val bXDelta = BigDecimal(10).pow(points)
                val bXD = bXDiff * bXDelta
                """
                    points: $points
                    value: ${value.toString(points = 32)}(${value.toString(points = points)})
                    other: ${other.toString(points = 32)}(${other.toString(points = points)})
                    diff: ${diff.toString(points = 32)}
                    10^$points: ${delta.toString(points = 32)}
                    diff * 10^$points: ${(diff * delta).toString(points = 32)}(${(diff * delta).toInt()})
                    ---
                    bX1: $bX1
                    bX2: $bX2
                    bXDiff: $bXDiff
                    bXDelta: $bXDelta
                    bXDiff * bXDelta: $bXD (${bXD.toLong()}/${bXD == BigDecimal.ZERO})
                    bXD/0: ${bXD.setScale(0, RoundingMode.FLOOR)}(${bXD.setScale(0, RoundingMode.FLOOR).toLong()})
                    bXD/1: ${bXD.setScale(1, RoundingMode.FLOOR)}(${bXD.setScale(1, RoundingMode.FLOOR).toLong()})
                    bXD/HALF_EVEN: ${bXD.setScale(1, RoundingMode.HALF_EVEN)}
                    ---
                """.trimIndent()
            }
        }
    }
}
