package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class PointCalculationsTest {
    @Test
    fun angleOfPointXYTest() {
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 3.0, bY = 1.0)
            Assertions.assertEquals(0.0.radians(), angle.radians())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 1.0, bY = 3.0)
            Assertions.assertEquals((kotlin.math.PI / 2).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = -1.0, bY = 1.0)
            Assertions.assertEquals(kotlin.math.PI.radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 1.0, bY = -1.0)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 4.0, bY = 4.0)
            Assertions.assertEquals((kotlin.math.PI / 4).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = -2.0, bY = 4.0)
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = -2.0, bY = -2.0)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).radians(), angle.radians(), 0.00000000000001)
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, bX = 4.0, bY = -2.0)
            Assertions.assertEquals((-kotlin.math.PI / 4).radians(), angle.radians())
        }
    }

    @Test
    fun angleOfXYPointTest() {
        pointOf(x = 3, y = 1).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals(0.0.radians(), angle.radians())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).radians(), angle.radians())
        }
        pointOf(x = 1, y = 3).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI / 2).radians(), angle.radians())
        }
        pointOf(x = -1, y = 1).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals(kotlin.math.PI.radians(), angle.radians())
        }
        pointOf(x = 1, y = -1).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).radians(), angle.radians())
        }
        pointOf(x = 4, y = 4).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI / 4).radians(), angle.radians())
        }
        pointOf(x = -2, y = 4).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).radians(), angle.radians())
        }
        pointOf(x = -2, y = -2).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).radians(), angle.radians(), 0.00000000000001)
        }
        pointOf(x = 4, y = -2).also { b: Point ->
            val angle = angleOf(aX = 1.0, aY = 1.0, b = b)
            Assertions.assertEquals((-kotlin.math.PI / 4).radians(), angle.radians())
        }
    }

    @Test
    fun angleOfPointOffsetTest() {
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 2.0, dY = 0.0))
            Assertions.assertEquals(0.0.radians(), angle.radians())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 0.0, dY = 2.0))
            Assertions.assertEquals((kotlin.math.PI / 2).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = -2.0, dY = 0.0))
            Assertions.assertEquals(kotlin.math.PI.radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 0.0, dY = -2.0))
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 3.0, dY = 3.0))
            Assertions.assertEquals((kotlin.math.PI / 4).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = -3.0, dY = 3.0))
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = -3.0, dY = -3.0))
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).radians(), angle.radians(), 0.00000000000001)
        }
        pointOf(x = 1, y = 1).also { a: Point ->
            val angle = angleOf(a = a, offset = offsetOf(dX = 3.0, dY = -3.0))
            Assertions.assertEquals((-kotlin.math.PI / 4).radians(), angle.radians())
        }
    }

    @Test
    fun angleOfPointsOffsetTest() {
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = -1, y = 1), b = b, offset = offsetOf(dX = 2.0, dY = 0.0))
            Assertions.assertEquals(0.0.radians(), angle.radians())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 1, y = -1), b = b, offset = offsetOf(dX = 0.0, dY = 2.0))
            Assertions.assertEquals((kotlin.math.PI / 2).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 3, y = 1), b = b, offset = offsetOf(dX = -2.0, dY = 0.0))
            Assertions.assertEquals(kotlin.math.PI.radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 1, y = 3), b = b, offset = offsetOf(dX = 0.0, dY = -2.0))
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = -2, y = -2), b = b, offset = offsetOf(dX = 3.0, dY = 3.0))
            Assertions.assertEquals((kotlin.math.PI / 4).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 4, y = -2), b = b, offset = offsetOf(dX = -3.0, dY = 3.0))
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).radians(), angle.radians())
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = 4, y = 4), b = b, offset = offsetOf(dX = -3.0, dY = -3.0))
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).radians(), angle.radians(), 0.00000000000001)
        }
        pointOf(x = 1, y = 1).also { b: Point ->
            val angle = angleOf(a = pointOf(x = -2, y = 4), b = b, offset = offsetOf(dX = 3.0, dY = -3.0))
            Assertions.assertEquals((-kotlin.math.PI / 4).radians(), angle.radians())
        }
    }

    @Test
    fun centerOfTest() {
        (12.8 to 0.0).also { (x: Double, y: Double) ->
            val point: Point = centerOf(x = x, y = y)
            Assertions.assertEquals(12.8 / 2, point.x)
            Assertions.assertEquals(0.0, point.y)
        }
        (0.0 to 25.6).also { (x: Double, y: Double) ->
            val point: Point = centerOf(x = x, y = y)
            Assertions.assertEquals(0.0, point.x)
            Assertions.assertEquals(25.6 / 2, point.y)
        }
        (-51.2 to 0.0).also { (x: Double, y: Double) ->
            val point: Point = centerOf(x = x, y = y)
            Assertions.assertEquals(-51.2 / 2, point.x)
            Assertions.assertEquals(0.0, point.y)
        }
        (0.0 to -10.24).also { (x: Double, y: Double) ->
            val point: Point = centerOf(x = x, y = y)
            Assertions.assertEquals(0.0, point.x)
            Assertions.assertEquals(-10.24 / 2, point.y)
        }
        (12.34 to 56.78).also { (x: Double, y: Double) ->
            val point: Point = centerOf(x = x, y = y)
            Assertions.assertEquals(12.34 / 2, point.x)
            Assertions.assertEquals(56.78 / 2, point.y)
        }
    }

    @Test
    fun centerOfOffsetTest() {
        offsetOf(dX = 12.8, dY = 0.0).also { offset: Offset ->
            val point: Point = centerOf(offset)
            Assertions.assertEquals(12.8 / 2, point.x)
            Assertions.assertEquals(0.0, point.y)
        }
        offsetOf(dX = 0.0, dY = 25.6).also { offset: Offset ->
            val point: Point = centerOf(offset)
            Assertions.assertEquals(0.0, point.x)
            Assertions.assertEquals(25.6 / 2, point.y)
        }
        offsetOf(dX = -51.2, dY = 0.0).also { offset: Offset ->
            val point: Point = centerOf(offset)
            Assertions.assertEquals(-51.2 / 2, point.x)
            Assertions.assertEquals(0.0, point.y)
        }
        offsetOf(dX = 0.0, dY = -10.24).also { offset: Offset ->
            val point: Point = centerOf(offset)
            Assertions.assertEquals(0.0, point.x)
            Assertions.assertEquals(-10.24 / 2, point.y)
        }
        offsetOf(dX = 12.34, dY = 56.78).also { offset: Offset ->
            val point: Point = centerOf(offset)
            Assertions.assertEquals(12.34 / 2, point.x)
            Assertions.assertEquals(56.78 / 2, point.y)
        }
    }
}
