package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PointUtilTest {
    @Test
    fun toStringTest() {
        val actual = pointOf(x = 1.234, y = 5.67)
        Assertions.assertEquals("{x: 1, y: 6}", actual.toString(points = 0))
        Assertions.assertEquals("{x: 1.2, y: 5.7}", actual.toString(points = 1))
        Assertions.assertEquals("{x: 1.23, y: 5.67}", actual.toString(points = 2))
        Assertions.assertEquals("{x: 1.234, y: 5.670}", actual.toString(points = 3))
        Assertions.assertEquals("{x: 1.23400000, y: 5.67000000}", actual.toString(points = 8))
    }

    @Test
    fun toStringErrorTest() {
        Assertions.assertThrows(IllegalStateException::class.java) {
            pointOf(x = 1.234, y = 5.67).toString(points = -1)
        }
    }
}
