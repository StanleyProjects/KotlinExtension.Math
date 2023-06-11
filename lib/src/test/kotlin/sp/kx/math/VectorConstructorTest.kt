package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class VectorConstructorTest {
    @Test
    fun vectorOfTest() {
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finishX = 5.6,
            finishY = 7.8,
        )
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
    }

    @Test
    fun vectorOfPointTest() {
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finish = pointOf(x = 5.6, y = 7.8),
        )
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
    }

    @Test
    fun pointPlusTest() {
        val actual: Vector = pointOf(x = 1.2, y = 3.4) + pointOf(x = 5.6, y = 7.8)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
    }

    @Test
    fun toVectorTest() {
        val actual: Vector = pointOf(x = 1.2, y = 3.4)
            .toVector(x = 5.6, y = 7.8)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
    }

    @Test
    fun toVectorOffsetTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        val offset = offsetOf(dX = 12.8, dY = 25.6)
        val actual: Vector = foo.toVector(offset = offset)
        Assertions.assertEquals(actual.start, foo)
        Assertions.assertNotEquals(actual.start, actual.finish)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(1.2 + 12.8, actual.finish.x)
        Assertions.assertEquals(3.4 + 25.6, actual.finish.y)
        Assertions.assertEquals(1.2 + offset.dX, actual.finish.x)
        Assertions.assertEquals(3.4 + offset.dY, actual.finish.y)
        Assertions.assertEquals(actual.start.x + offset.dX, actual.finish.x)
        Assertions.assertEquals(actual.start.y + offset.dY, actual.finish.y)
    }

    @Test
    fun toVectorPointOffsetTest() {
        val offset = offsetOf(dX = 12.8, dY = 25.6)
        val foo = pointOf(x = 1.2, y = 3.4)
        val bar = pointOf(x = 5.6, y = 7.8)
        val actual: Vector = foo.toVector(finish = bar, offset = offset)
        Assertions.assertNotEquals(actual.start, actual.finish)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2 + offset.dX, actual.start.x)
        Assertions.assertEquals(3.4 + offset.dY, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6 + offset.dX, actual.finish.x)
        Assertions.assertEquals(7.8 + offset.dY, actual.finish.y)
        Assertions.assertEquals(foo.x + offset.dX, actual.start.x)
        Assertions.assertEquals(foo.y + offset.dY, actual.start.y)
        Assertions.assertEquals(bar.x + offset.dX, actual.finish.x)
        Assertions.assertEquals(bar.y + offset.dY, actual.finish.y)
    }

    @Test
    fun vectorOfLengthAngleTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        val length = 5.6
        0.0.also { angle: Double ->
            val vector: Vector = vectorOf(start = foo, length = length, angle = angle)
            Assertions.assertEquals(foo.x, vector.start.x)
            Assertions.assertEquals(foo.y, vector.start.y)
            Assertions.assertEquals(foo.x + length, vector.finish.x)
            Assertions.assertEquals(foo.y, vector.finish.y)
        }
        (kotlin.math.PI / 4).also { angle: Double ->
            val vector: Vector = vectorOf(start = foo, length = length, angle = angle)
            Assertions.assertEquals(foo.x, vector.start.x)
            Assertions.assertEquals(foo.y, vector.start.y)
            Assertions.assertEquals(foo.x + length * kotlin.math.cos(angle), vector.finish.x)
            Assertions.assertEquals(foo.y + length * kotlin.math.sin(angle), vector.finish.y)
        }
        (kotlin.math.PI / 2).also { angle: Double ->
            val vector: Vector = vectorOf(start = foo, length = length, angle = angle)
            Assertions.assertEquals(foo.x, vector.start.x)
            Assertions.assertEquals(foo.y, vector.start.y)
            Assertions.assertEquals(1.2, vector.finish.x, 0.000000000000001)
            Assertions.assertNotEquals(1.2, vector.finish.x, 0.0000000000000001)
            Assertions.assertTrue(vector.finish.x.eq(1.2, points = 15))
            Assertions.assertFalse(vector.finish.x.eq(1.2, points = 16))
            Assertions.assertEquals(3.4 + length, vector.finish.y)
        }
        (kotlin.math.PI / 2 + kotlin.math.PI / 4).also { angle: Double ->
            val vector: Vector = vectorOf(start = foo, length = length, angle = angle)
            Assertions.assertEquals(foo.x, vector.start.x)
            Assertions.assertEquals(foo.y, vector.start.y)
            Assertions.assertEquals(1.2 + length * kotlin.math.cos(angle), vector.finish.x)
            Assertions.assertEquals(3.4 + length * kotlin.math.sin(angle), vector.finish.y)
        }
        kotlin.math.PI.also { angle: Double ->
            val vector: Vector = vectorOf(start = foo, length = length, angle = angle)
            Assertions.assertEquals(foo.x, vector.start.x)
            Assertions.assertEquals(foo.y, vector.start.y)
            Assertions.assertEquals(1.2 - length, vector.finish.x)
            Assertions.assertEquals(3.4, vector.finish.y, 0.000000000000001)
            Assertions.assertNotEquals(3.4, vector.finish.y, 0.0000000000000001)
            Assertions.assertTrue(vector.finish.y.eq(3.4, points = 15))
            Assertions.assertFalse(vector.finish.y.eq(3.4, points = 16))
        }
    }

    @Test
    fun vectorOfLengthTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        5.6.also { length ->
            val vector: Vector = vectorOf(start = foo, length = length)
            Assertions.assertEquals(1.2 + length, vector.finish.x)
            Assertions.assertEquals(3.4, vector.finish.y)
        }
        (-1.28).also { length ->
            val vector: Vector = vectorOf(start = foo, length = length)
            Assertions.assertEquals(1.2 + length, vector.finish.x)
            Assertions.assertEquals(3.4, vector.finish.y)
        }
    }
}
