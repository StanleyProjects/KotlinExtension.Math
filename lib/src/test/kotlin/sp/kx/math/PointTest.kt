package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PointTest {
    @Test
    fun classMutablePointTest() {
        val actual = MutablePoint(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        actual.x = 5.6
        Assertions.assertEquals(5.6, actual.x)
        Assertions.assertEquals(3.4, actual.y)
        actual.y = 7.8
        Assertions.assertEquals(5.6, actual.x)
        Assertions.assertEquals(7.8, actual.y)
    }

    @Test
    fun pointOfTest() {
        val actual: Point = pointOf(
            x = 1.2,
            y = 3.4,
        )
        Assertions.assertNotEquals(actual.x, actual.y)
        Assertions.assertEquals(1.2, actual.x)
        Assertions.assertEquals(3.4, actual.y)
    }
}
