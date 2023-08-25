package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class ImmutableVectorTransformTest {
    @Test
    fun vectorOfTest() {
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finishX = 5.6,
            finishY = 7.8,
        ) { it * 2 }
        Assertions.assertNotEquals(actual.start, actual.finish)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2 * 2, actual.start.x)
        Assertions.assertEquals(3.4 * 2, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6 * 2, actual.finish.x)
        Assertions.assertEquals(7.8 * 2, actual.finish.y)
    }

    @Test
    fun vectorOfPointTest() {
        val finish = pointOf(x = 5.6, y = 7.8)
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finish = finish,
        ) { it * 2 }
        Assertions.assertNotEquals(actual.start, actual.finish)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2 * 2, actual.start.x)
        Assertions.assertEquals(3.4 * 2, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6 * 2, actual.finish.x)
        Assertions.assertEquals(7.8 * 2, actual.finish.y)
        Assertions.assertEquals(finish.x * 2, actual.finish.x)
        Assertions.assertEquals(finish.y * 2, actual.finish.y)
    }

    @Test
    fun toVectorTest() {
        val actual: Vector = pointOf(x = 1.2, y = 3.4).toVector(x = 5.6, y = 7.8) { it * 2 }
        Assertions.assertNotEquals(actual.start, actual.finish)
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertEquals(1.2 * 2, actual.start.x)
        Assertions.assertEquals(3.4 * 2, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(5.6 * 2, actual.finish.x)
        Assertions.assertEquals(7.8 * 2, actual.finish.y)
    }

    @Test
    fun mapTest() {
        val foo: Vector = pointOf(x = 1.2, y = 3.4) + pointOf(x = 5.6, y = 7.8)
        Assertions.assertNotEquals(foo.start, foo.finish)
        Assertions.assertNotEquals(foo.start.x, foo.start.y)
        Assertions.assertNotEquals(foo.finish.x, foo.finish.y)
        val bar: Vector = foo.map { it * 2 }
        Assertions.assertEquals(1.2, foo.start.x)
        Assertions.assertEquals(3.4, foo.start.y)
        Assertions.assertEquals(5.6, foo.finish.x)
        Assertions.assertEquals(7.8, foo.finish.y)
        Assertions.assertEquals(foo.start.x * 2, bar.start.x)
        Assertions.assertEquals(foo.start.y * 2, bar.start.y)
        Assertions.assertEquals(foo.finish.x * 2, bar.finish.x)
        Assertions.assertEquals(foo.finish.y * 2, bar.finish.y)
    }
}
