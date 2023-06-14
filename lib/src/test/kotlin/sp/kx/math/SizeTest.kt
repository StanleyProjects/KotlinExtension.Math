package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class SizeTest {
    @Test
    fun pointOfTest() {
        val foo: Size = sizeOf(
            width = 1.2,
            height = 3.4,
        )
        Assertions.assertNotEquals(foo.width, foo.height)
        Assertions.assertEquals(1.2, foo.width)
        Assertions.assertEquals(3.4, foo.height)
    }
}
