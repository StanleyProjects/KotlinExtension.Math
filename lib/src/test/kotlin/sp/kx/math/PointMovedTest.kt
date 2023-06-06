package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        TODO()
    }
}
