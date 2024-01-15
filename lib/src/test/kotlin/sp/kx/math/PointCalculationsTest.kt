package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class PointCalculationsTest {
    @Test
    fun distanceOfPointTest() {
        val targets = listOf(
            pointOf(x = 1, y = 3),
            pointOf(x = 5, y = 3),
            pointOf(x = 3, y = 1),
            pointOf(x = 3, y = 5),
        )
        check(targets.size == 4)
        check(targets.toSet().size == targets.size)
        val b = pointOf(x = 3, y = 3)
        targets.forEach { a ->
            val actual = distanceOf(
                a = a,
                b = b,
            )
            Assertions.assertEquals(2.0, actual) { "a: $a" }
        }
    }

    @Test
    fun distanceOfPointDoubleTest() {
        val targets = listOf(
            pointOf(x = 1, y = 3),
            pointOf(x = 5, y = 3),
            pointOf(x = 3, y = 1),
            pointOf(x = 3, y = 5),
        )
        check(targets.size == 4)
        check(targets.toSet().size == targets.size)
        targets.forEach { a ->
            val actual = distanceOf(
                a = a,
                bX = 3.0,
                bY = 3.0,
            )
            Assertions.assertEquals(2.0, actual) { "a: $a" }
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
