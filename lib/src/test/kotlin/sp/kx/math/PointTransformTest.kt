package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sp.kx.math.measure.measureOf

@Suppress("MagicNumber")
internal class PointTransformTest {
    @Test
    fun pointOfTest() {
        val actual = pointOf(
            x = 1.2,
            y = 3.4,
        ) {
            it * 2
        }
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2 * 2, actual.x)
        Assertions.assertEquals(3.4 * 2, actual.y)
    }

    @Test
    fun mapTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        val bar = foo.map { it * 2 }
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        Assertions.assertEquals(1.2 * 2, bar.x)
        Assertions.assertEquals(3.4 * 2, bar.y)
    }

    @Test
    fun mapMeasureTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        val bar = foo.map(measureOf(magnitude = 2.0))
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        Assertions.assertEquals(1.2 * 2, bar.x)
        Assertions.assertEquals(3.4 * 2, bar.y)
    }
}
