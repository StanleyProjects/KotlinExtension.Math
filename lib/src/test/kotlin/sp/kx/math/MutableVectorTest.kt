package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MutableVectorTest {
    @Test
    fun constructorTest() {
        val actual = MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        )
        Assertions.assertNotEquals(actual.start.x, actual.start.y)
        Assertions.assertNotEquals(actual.finish.x, actual.finish.y)
        Assertions.assertEquals(1.2, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.start.x = 1.28
        Assertions.assertEquals(1.28, actual.start.x)
        Assertions.assertEquals(3.4, actual.start.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.start.y = 2.56
        Assertions.assertEquals(1.28, actual.start.x)
        Assertions.assertEquals(2.56, actual.start.y)
        Assertions.assertEquals(5.6, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.finish.x = 5.12
        Assertions.assertEquals(1.28, actual.start.x)
        Assertions.assertEquals(2.56, actual.start.y)
        Assertions.assertEquals(5.12, actual.finish.x)
        Assertions.assertEquals(7.8, actual.finish.y)
        actual.finish.y = 10.24
        Assertions.assertEquals(1.28, actual.start.x)
        Assertions.assertEquals(2.56, actual.start.y)
        Assertions.assertEquals(5.12, actual.finish.x)
        Assertions.assertEquals(10.24, actual.finish.y)
    }

    @Test
    fun toStringTest() {
        MutableVector(
            start = MutablePoint(x = 1.2, y = 3.4),
            finish = MutablePoint(x = 5.6, y = 7.8),
        ).also { actual ->
            Assertions.assertEquals("{x: 1.20, y: 3.40} -> {x: 5.60, y: 7.80}", actual.toString())
        }
        MutableVector(
            start = MutablePoint(x = 1.23, y = 3.45),
            finish = MutablePoint(x = 5.67, y = 7.89),
        ).also { actual ->
            Assertions.assertEquals("{x: 1.23, y: 3.45} -> {x: 5.67, y: 7.89}", actual.toString())
        }
        MutableVector(
            start = MutablePoint(x = 1.234, y = 3.456),
            finish = MutablePoint(x = 5.678, y = 7.891),
        ).also { actual ->
            Assertions.assertEquals("{x: 1.23, y: 3.46} -> {x: 5.68, y: 7.89}", actual.toString())
        }
    }
}
