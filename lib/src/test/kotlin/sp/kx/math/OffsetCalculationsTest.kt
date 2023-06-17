package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class OffsetCalculationsTest {
    @Test
    fun angleOfTest() {
        offsetOf(dX = 3.0, dY = 0.0).also { offset: Offset ->
            val angle = angleOf(offset)
            Assertions.assertEquals(0.0.ct(), angle.ct())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).ct(), angle.ct())
        }
        offsetOf(dX = 0.0, dY = 3.0).also { offset: Offset ->
            val angle = angleOf(offset)
            Assertions.assertEquals((kotlin.math.PI / 2).ct(), angle.ct())
        }
        offsetOf(dX = -1.0, dY = 0.0).also { offset: Offset ->
            val angle = angleOf(offset)
            Assertions.assertEquals(kotlin.math.PI.ct(), angle.ct())
        }
        offsetOf(dX = 0.0, dY = -1.0).also { offset: Offset ->
            val angle = angleOf(offset)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).ct(), angle.ct())
        }
        offsetOf(dX = 4.0, dY = 4.0).also { offset: Offset ->
            val angle = angleOf(offset)
            Assertions.assertEquals((kotlin.math.PI / 4).ct(), angle.ct())
        }
        offsetOf(dX = -4.0, dY = 4.0).also { offset: Offset ->
            val angle = angleOf(offset)
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).ct(), angle.ct())
        }
        offsetOf(dX = -2.0, dY = -2.0).also { offset: Offset ->
            val angle = angleOf(offset)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).ct(), angle.ct(), 0.00000000000001)
        }
        offsetOf(dX = 4.0, dY = -4.0).also { offset: Offset ->
            val angle = angleOf(offset)
            Assertions.assertEquals((-kotlin.math.PI / 4).ct(), angle.ct())
        }
    }

    @Test
    fun distanceOfTest() {
        offsetOf(dX = 12.8, dY = 0.0).also { offset: Offset ->
            Assertions.assertEquals(12.8, distanceOf(offset))
        }
        offsetOf(dX = 0.0, dY = 25.6).also { offset: Offset ->
            Assertions.assertEquals(25.6, distanceOf(offset))
        }
        offsetOf(dX = -51.2, dY = 0.0).also { offset: Offset ->
            Assertions.assertEquals(51.2, distanceOf(offset))
        }
        offsetOf(dX = 0.0, dY = -10.24).also { offset: Offset ->
            Assertions.assertEquals(10.24, distanceOf(offset))
        }
        offsetOf(dX = 12.34, dY = 56.78).also { offset: Offset ->
            Assertions.assertEquals(kotlin.math.sqrt(offset.dX * offset.dX + offset.dY * offset.dY), distanceOf(offset))
        }
    }
}
