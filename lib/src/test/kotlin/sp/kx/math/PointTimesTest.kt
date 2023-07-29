package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PointTimesTest {
    @Test
    fun timesTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        Assertions.assertNotEquals(foo.x, foo.y)
        Assertions.assertEquals(1.2, foo.x)
        Assertions.assertEquals(3.4, foo.y)
        foo.times(5.6).also { bar: Point ->
            val value = 5.6
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertEquals(1.2 * value, bar.x)
            Assertions.assertEquals(3.4 * value, bar.y)
            Assertions.assertEquals(foo.x * value, bar.x)
            Assertions.assertEquals(foo.y * value, bar.y)
        }
        foo.times(-7.8).also { bar: Point ->
            val value = -7.8
            Assertions.assertEquals(1.2, foo.x)
            Assertions.assertEquals(3.4, foo.y)
            Assertions.assertNotEquals(bar.x, bar.y)
            Assertions.assertEquals(1.2 * value, bar.x)
            Assertions.assertEquals(3.4 * value, bar.y)
            Assertions.assertEquals(foo.x * value, bar.x)
            Assertions.assertEquals(foo.y * value, bar.y)
        }
    }
}
