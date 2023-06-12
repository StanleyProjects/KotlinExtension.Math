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
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 1.0, bY = 3.0)
            Assertions.assertEquals((kotlin.math.PI / 2).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = -1.0, bY = 1.0)
            Assertions.assertEquals(kotlin.math.PI.ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 1.0, bY = -1.0)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 4.0, bY = 4.0)
            Assertions.assertEquals((kotlin.math.PI / 4).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = -2.0, bY = 4.0)
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = -2.0, bY = -2.0)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).ct(), angle.ct(), 0.00000000000001)
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 4.0, bY = -2.0)
            Assertions.assertEquals((-kotlin.math.PI / 4).ct(), angle.ct())
        }
    }

    @Test
    fun angleOfXYPointTest() {
        pointOf(x = 3, y = 1).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals(0.0.ct(), angle.ct())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).ct(), angle.ct())
        }
        pointOf(x = 1, y = 3).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI / 2).ct(), angle.ct())
        }
        pointOf(x = -1, y = 1).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals(kotlin.math.PI.ct(), angle.ct())
        }
        pointOf(x = 1, y = -1).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).ct(), angle.ct())
        }
        pointOf(x = 4, y = 4).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI / 4).ct(), angle.ct())
        }
        pointOf(x = -2, y = 4).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).ct(), angle.ct())
        }
        pointOf(x = -2, y = -2).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).ct(), angle.ct(), 0.00000000000001)
        }
        pointOf(x = 4, y = -2).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((-kotlin.math.PI / 4).ct(), angle.ct())
        }
    }

    @Test
    fun angleOfPointOffsetTest() {
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 2.0, dY = 0.0))
            Assertions.assertEquals(0.0.ct(), angle.ct())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 0.0, dY = 2.0))
            Assertions.assertEquals((kotlin.math.PI / 2).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = -2.0, dY = 0.0))
            Assertions.assertEquals(kotlin.math.PI.ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 0.0, dY = -2.0))
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 3.0, dY = 3.0))
            Assertions.assertEquals((kotlin.math.PI / 4).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = -3.0, dY = 3.0))
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = -3.0, dY = -3.0))
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).ct(), angle.ct(), 0.00000000000001)
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 3.0, dY = -3.0))
            Assertions.assertEquals((-kotlin.math.PI / 4).ct(), angle.ct())
        }
    }

    @Test
    fun angleOfPointsOffsetTest() {
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = -1, y = 1), b = b, offset = offsetOf(dX = 2.0, dY = 0.0))
            Assertions.assertEquals(0.0.ct(), angle.ct())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 1, y = -1), b = b, offset = offsetOf(dX = 0.0, dY = 2.0))
            Assertions.assertEquals((kotlin.math.PI / 2).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 3, y = 1), b = b, offset = offsetOf(dX = -2.0, dY = 0.0))
            Assertions.assertEquals(kotlin.math.PI.ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 1, y = 3), b = b, offset = offsetOf(dX = 0.0, dY = -2.0))
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = -2, y = -2), b = b, offset = offsetOf(dX = 3.0, dY = 3.0))
            Assertions.assertEquals((kotlin.math.PI / 4).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 4, y = -2), b = b, offset = offsetOf(dX = -3.0, dY = 3.0))
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).ct(), angle.ct())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 4, y = 4), b = b, offset = offsetOf(dX = -3.0, dY = -3.0))
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).ct(), angle.ct(), 0.00000000000001)
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = -2, y = 4), b = b, offset = offsetOf(dX = 3.0, dY = -3.0))
            Assertions.assertEquals((-kotlin.math.PI / 4).ct(), angle.ct())
        }
    }
}
