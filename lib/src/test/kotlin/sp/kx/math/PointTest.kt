package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class PointTest {
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

    @Test
    fun centerTest() {
        Assertions.assertEquals(Point.Center.x, Point.Center.y)
        Assertions.assertEquals(0.0, Point.Center.x)
        Assertions.assertEquals(0.0, Point.Center.y)
    }
}
