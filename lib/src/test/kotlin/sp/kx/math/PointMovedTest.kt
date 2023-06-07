package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class PointMovedTest {
    @Test
    fun movedTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        5.6.also { length ->
            val bar = foo.moved(length = length)
            Assertions.assertEquals(1.2 + length, bar.x)
            Assertions.assertEquals(3.4, bar.y)
        }
        (-1.28).also { length ->
            val bar = foo.moved(length = length)
            Assertions.assertEquals(1.2 + length, bar.x)
            Assertions.assertEquals(3.4, bar.y)
        }
    }

    @Test
    fun movedAngleTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        val length = 5.6
        0.0.also { angle: Double ->
            val bar = foo.moved(length = length, angle = angle)
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertEquals(1.2 + length, bar.x)
            Assertions.assertEquals(3.4, bar.y)
        }
        (kotlin.math.PI / 4).also { angle: Double ->
            val bar = foo.moved(length = length, angle = angle)
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertEquals(1.2 + length * kotlin.math.cos(angle), bar.x)
            Assertions.assertEquals(3.4 + length * kotlin.math.sin(angle), bar.y)
        }
        (kotlin.math.PI / 2).also { angle: Double ->
            val bar = foo.moved(length = length, angle = angle)
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertEquals(1.2, bar.x, 0.000000000000001)
            Assertions.assertNotEquals(1.2, bar.x, 0.0000000000000001)
            Assertions.assertTrue(bar.x.eq(1.2, points = 15))
            Assertions.assertFalse(bar.x.eq(1.2, points = 16))
            Assertions.assertEquals(3.4 + length, bar.y)
        }
        (kotlin.math.PI / 2 + kotlin.math.PI / 4).also { angle: Double ->
            val bar = foo.moved(length = length, angle = angle)
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertEquals(1.2 + length * kotlin.math.cos(angle), bar.x)
            Assertions.assertEquals(3.4 + length * kotlin.math.sin(angle), bar.y)
        }
        kotlin.math.PI.also { angle: Double ->
            val bar = foo.moved(length = length, angle = angle)
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertEquals(1.2 - length, bar.x)
            Assertions.assertEquals(3.4, bar.y, 0.000000000000001)
            Assertions.assertNotEquals(3.4, bar.y, 0.0000000000000001)
            Assertions.assertTrue(bar.y.eq(3.4, points = 15))
            Assertions.assertFalse(bar.y.eq(3.4, points = 16))
        }
    }
}
