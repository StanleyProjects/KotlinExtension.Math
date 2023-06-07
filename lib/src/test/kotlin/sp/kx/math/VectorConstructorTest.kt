package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
            .toVector(
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
}
