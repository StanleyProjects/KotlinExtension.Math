package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class PointCalculationsTest {
    @Test
    fun angleOfPointXYTest() {
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 3.0, bY = 1.0)
            Assertions.assertEquals(0.0.ct(), angle.ct())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).ct(), angle.ct())
        }
        TODO()
    }
}
