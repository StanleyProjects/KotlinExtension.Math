package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class OffsetTest {
    @Test
    fun offsetOfTest() {
        offsetOf(
            dX = 1.2,
            dY = 1.2,
        ).also { actual: Offset ->
            Assertions.assertEquals(actual.dX, actual.dY)
            Assertions.assertEquals(1.2, actual.dX)
            Assertions.assertEquals(1.2, actual.dY)
        }
        offsetOf(
            dX = 1.2,
            dY = 3.4,
        ).also { actual: Offset ->
            Assertions.assertNotEquals(actual.dX, actual.dY)
            Assertions.assertEquals(1.2, actual.dX)
            Assertions.assertEquals(3.4, actual.dY)
        }
        offsetOf(
            dX = 5.6,
            dY = 7.8,
        ).also { actual: Offset ->
            Assertions.assertNotEquals(actual.dX, actual.dY)
            Assertions.assertEquals(5.6, actual.dX)
            Assertions.assertEquals(7.8, actual.dY)
        }
    }

    @Test
    fun emptyTest() {
        Assertions.assertEquals(Offset.Empty.dX, Offset.Empty.dY)
        Assertions.assertEquals(0.0, Offset.Empty.dX)
        Assertions.assertEquals(0.0, Offset.Empty.dY)
    }
}
