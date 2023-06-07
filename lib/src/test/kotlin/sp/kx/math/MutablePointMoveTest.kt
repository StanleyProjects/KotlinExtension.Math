package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class MutablePointMoveTest {
    @Test
    fun moveTest() {
        val actual = MutablePoint(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        5.6.also { length ->
            actual.move(length = length)
            Assertions.assertEquals(1.2 + length, actual.x)
            Assertions.assertEquals(3.4, actual.y)
        }
        (-1.28).also { length ->
            actual.move(length = length)
            Assertions.assertEquals(1.2 + 5.6 + length, actual.x)
            Assertions.assertEquals(3.4, actual.y)
        }
    }

    @Test
    fun moveAngleTest() {
        MutablePoint(x = 1.2, y = 3.4).also { point ->
            Assertions.assertNotEquals(point.x, point.y)
            Assertions.assertEquals(1.2, point.x)
            Assertions.assertEquals(3.4, point.y)
            val length = 5.6
            val angle = 0.0
            point.move(length = length, angle = angle)
            Assertions.assertEquals(1.2 + length, point.x)
            Assertions.assertEquals(3.4, point.y)
        }
        MutablePoint(x = 1.2, y = 3.4).also { point ->
            Assertions.assertNotEquals(point.x, point.y)
            Assertions.assertEquals(1.2, point.x)
            Assertions.assertEquals(3.4, point.y)
            val length = 5.6
            val angle = kotlin.math.PI / 4
            point.move(length = length, angle = angle)
            Assertions.assertEquals(1.2 + length * kotlin.math.cos(angle), point.x)
            Assertions.assertEquals(3.4 + length * kotlin.math.sin(angle), point.y)
        }
        MutablePoint(x = 1.2, y = 3.4).also { point ->
            Assertions.assertNotEquals(point.x, point.y)
            Assertions.assertEquals(1.2, point.x)
            Assertions.assertEquals(3.4, point.y)
            val length = 5.6
            val angle = kotlin.math.PI / 2
            point.move(length = length, angle = angle)
            Assertions.assertEquals(1.2, point.x, 0.000000000000001)
            Assertions.assertNotEquals(1.2, point.x, 0.0000000000000001)
            Assertions.assertTrue(point.x.eq(1.2, points = 15))
            Assertions.assertFalse(point.x.eq(1.2, points = 16))
            Assertions.assertEquals(3.4 + length, point.y)
        }
        MutablePoint(x = 1.2, y = 3.4).also { point ->
            Assertions.assertNotEquals(point.x, point.y)
            Assertions.assertEquals(1.2, point.x)
            Assertions.assertEquals(3.4, point.y)
            val length = 5.6
            val angle = kotlin.math.PI / 2 + kotlin.math.PI / 4
            point.move(length = length, angle = angle)
            Assertions.assertEquals(1.2 + length * kotlin.math.cos(angle), point.x)
            Assertions.assertEquals(3.4 + length * kotlin.math.sin(angle), point.y)
        }
        MutablePoint(x = 1.2, y = 3.4).also { point ->
            Assertions.assertNotEquals(point.x, point.y)
            Assertions.assertEquals(1.2, point.x)
            Assertions.assertEquals(3.4, point.y)
            val length = 5.6
            val angle = kotlin.math.PI
            point.move(length = length, angle = angle)
            Assertions.assertEquals(1.2 - length, point.x)
            Assertions.assertEquals(3.4, point.y, 0.000000000000001)
            Assertions.assertNotEquals(3.4, point.y, 0.0000000000000001)
            Assertions.assertTrue(point.y.eq(3.4, points = 15))
            Assertions.assertFalse(point.y.eq(3.4, points = 16))
        }
    }
}
