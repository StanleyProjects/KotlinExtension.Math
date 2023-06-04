package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MutableOffsetTest {
    @Test
    fun constructorTest() {
        val actual = MutableOffset(
            dX = 1.2,
            dY = 3.4,
        )
        Assertions.assertNotEquals(actual.dX, actual.dY)
        Assertions.assertEquals(1.2, actual.dX)
        Assertions.assertEquals(3.4, actual.dY)
        actual.dX = 5.6
        Assertions.assertEquals(5.6, actual.dX)
        Assertions.assertEquals(3.4, actual.dY)
        actual.dY = 7.8
        Assertions.assertEquals(5.6, actual.dX)
        Assertions.assertEquals(7.8, actual.dY)
    }
}
