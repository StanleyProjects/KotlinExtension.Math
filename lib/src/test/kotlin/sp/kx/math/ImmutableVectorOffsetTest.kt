package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ImmutableVectorOffsetTest {
    @Test
    fun vectorOfTest() {
        val dX = 12.8
        val dY = 25.6
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finishX = 5.6,
            finishY = 7.8,
            dX = dX,
            dY = dY,
        )
        Assertions.assertNotEquals(actual.start, actual.finish)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2 + dX, actual.start.x)
        Assertions.assertEquals(3.4 + dY, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6 + dX, actual.finish.x)
        Assertions.assertEquals(7.8 + dY, actual.finish.y)
    }

    @Test
    fun vectorOfOffsetTest() {
        val offset = offsetOf(dX = 12.8, dY = 25.6)
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finishX = 5.6,
            finishY = 7.8,
            offset = offset,
        )
        Assertions.assertNotEquals(actual.start, actual.finish)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2 + offset.dX, actual.start.x)
        Assertions.assertEquals(3.4 + offset.dY, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6 + offset.dX, actual.finish.x)
        Assertions.assertEquals(7.8 + offset.dY, actual.finish.y)
    }

    @Test
    fun vectorOfPointTest() {
        val finish = pointOf(x = 5.6, y = 7.8)
        val dX = 12.8
        val dY = 25.6
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finish = finish,
            dX = dX,
            dY = dY,
        )
        Assertions.assertNotEquals(actual.start, actual.finish)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2 + dX, actual.start.x)
        Assertions.assertEquals(3.4 + dY, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6 + dX, actual.finish.x)
        Assertions.assertEquals(7.8 + dY, actual.finish.y)
        Assertions.assertEquals(finish.x + dX, actual.finish.x)
        Assertions.assertEquals(finish.y + dY, actual.finish.y)
    }

    @Test
    fun vectorOfPointOffsetTest() {
        val finish = pointOf(x = 5.6, y = 7.8)
        val offset = offsetOf(dX = 12.8, dY = 25.6)
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finish = finish,
            offset = offset,
        )
        Assertions.assertNotEquals(actual.start, actual.finish)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2 + offset.dX, actual.start.x)
        Assertions.assertEquals(3.4 + offset.dY, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6 + offset.dX, actual.finish.x)
        Assertions.assertEquals(7.8 + offset.dY, actual.finish.y)
        Assertions.assertEquals(finish.x + offset.dX, actual.finish.x)
        Assertions.assertEquals(finish.y + offset.dY, actual.finish.y)
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

}
