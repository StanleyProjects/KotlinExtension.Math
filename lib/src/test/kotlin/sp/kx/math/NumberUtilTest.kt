package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class NumberUtilTest {
    @Test
    fun radiansTest() {
        val actual = kotlin.math.PI * 2 + kotlin.math.PI / 3
        Assertions.assertTrue(actual > kotlin.math.PI * 2)
        val delta = 0.00000000000001
        Assertions.assertEquals(kotlin.math.PI / 3, actual.radians(), delta)
        Assertions.assertEquals(kotlin.math.PI / 3, (kotlin.math.PI * 2 + actual).radians(), delta)
        Assertions.assertEquals(kotlin.math.PI / 3, (kotlin.math.PI * 4 + actual).radians(), delta)
    }

    @Test
    fun radiansNegativeTest() {
        val actual = -kotlin.math.PI / 3
        Assertions.assertTrue(actual < 0)
        val delta = 0.00000000000001
        Assertions.assertEquals(kotlin.math.PI * 2 - kotlin.math.PI / 3, actual.radians(), delta)
        Assertions.assertEquals(kotlin.math.PI * 2 - kotlin.math.PI / 3, (kotlin.math.PI * 2 + actual).radians(), delta)
        Assertions.assertEquals(kotlin.math.PI * 2 - kotlin.math.PI / 3, (kotlin.math.PI * 4 + actual).radians(), delta)
    }

    @Test
    fun ctKTest() {
        val k = 128.0
        val value = 42.0
        val actual = k + k + value
        Assertions.assertEquals(value, actual.ct(k = k))
        Assertions.assertEquals(value, (k + actual).ct(k = k))
        Assertions.assertEquals(value, (k * 2 + actual).ct(k = k))
        Assertions.assertEquals(value, (k * 3 + actual).ct(k = k))
        Assertions.assertEquals(value, (k * 4 + actual).ct(k = k))
    }

    @Test
    fun ctKNegativeTest() {
        val k = 128.0
        val value = 42.0
        val actual = -value
        Assertions.assertEquals(k - value, actual.ct(k = k))
        Assertions.assertEquals(k - value, (k + actual).ct(k = k))
        Assertions.assertEquals(k - value, (k * 2 + actual).ct(k = k))
        Assertions.assertEquals(k - value, (k * 3 + actual).ct(k = k))
        Assertions.assertEquals(k - value, (k * 4 + actual).ct(k = k))
    }

    @Test
    fun divideByYourselfTest() {
        Assertions.assertEquals(1.0, 1.0.dby())
        Assertions.assertEquals(-1.0, (-1.0).dby())
        Assertions.assertEquals(1.0, 5.0.dby())
        Assertions.assertEquals(-1.0, (-42.0).dby())
        Assertions.assertEquals(1.0, Double.MAX_VALUE.dby())
        Assertions.assertEquals(1.0, Double.MIN_VALUE.dby())
        Assertions.assertEquals(-1.0, (-Double.MIN_VALUE).dby())
        Assertions.assertEquals(-1.0, (-Double.MAX_VALUE).dby())
        Assertions.assertTrue(0.0.dby().isNaN())
        Assertions.assertTrue(Double.NaN.dby().isNaN())
        Assertions.assertTrue(Double.POSITIVE_INFINITY.dby().isNaN())
        Assertions.assertTrue(Double.NEGATIVE_INFINITY.dby().isNaN())
    }

    @Test
    fun orNullTest() {
        Assertions.assertNotNull(Double.NEGATIVE_INFINITY.orNull())
        Assertions.assertNotNull(0.0.orNull())
        Assertions.assertNotNull(Double.MIN_VALUE.orNull())
        Assertions.assertNotNull(1.0.orNull())
        Assertions.assertNotNull(42.0.orNull())
        Assertions.assertNotNull(Double.MAX_VALUE.orNull())
        Assertions.assertNotNull(Double.POSITIVE_INFINITY.orNull())
        Assertions.assertNull(Double.NaN.orNull())
    }

    @Test
    fun orDefaultTest() {
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY.orDefault())
        Assertions.assertEquals(0.0, 0.0.orDefault())
        Assertions.assertEquals(Double.MIN_VALUE, Double.MIN_VALUE.orDefault())
        Assertions.assertEquals(1.0, 1.0.orDefault())
        Assertions.assertEquals(42.0, 42.0.orDefault())
        Assertions.assertEquals(Double.MAX_VALUE, Double.MAX_VALUE.orDefault())
        Assertions.assertEquals(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY.orDefault())
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, Double.NaN.orDefault(Double.NEGATIVE_INFINITY))
        Assertions.assertEquals(-1.0, Double.NaN.orDefault(-1.0))
        Assertions.assertEquals(0.0, Double.NaN.orDefault())
        Assertions.assertEquals(0.0, Double.NaN.orDefault(0.0))
        Assertions.assertEquals(Double.MIN_VALUE, Double.NaN.orDefault(Double.MIN_VALUE))
        Assertions.assertEquals(1.0, Double.NaN.orDefault(1.0))
        Assertions.assertEquals(42.0, Double.NaN.orDefault(42.0))
        Assertions.assertEquals(Double.MAX_VALUE, Double.NaN.orDefault(Double.MAX_VALUE))
        Assertions.assertEquals(Double.POSITIVE_INFINITY, Double.NaN.orDefault(Double.POSITIVE_INFINITY))
        Assertions.assertTrue(Double.NaN.orDefault(Double.NaN).isNaN())
    }
}
