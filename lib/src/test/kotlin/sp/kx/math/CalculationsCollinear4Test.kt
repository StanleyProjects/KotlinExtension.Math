package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsCollinear4Test {
    @Test
    fun isCollinearTest() {
        val targets = listOf(
            pointOf(x = 1, y = 1),
            pointOf(x = 1, y = 0),
            pointOf(x = 1, y = -1),
            pointOf(x = 0, y = -1),
            pointOf(x = -1, y = -1),
            pointOf(x = -1, y = 0),
            pointOf(x = -1, y = 1),
            pointOf(x = 0, y = 1),
            pointOf(x = 0, y = 0),
        )
        check(targets.size == 9)
        check(targets.toSet().size == targets.size)
        val offsets = listOf(
            offsetOf(dX = 0.0, dY = 1.0),
            offsetOf(dX = 1.0, dY = 0.0),
            offsetOf(dX = 1.0, dY = 1.0),
            offsetOf(dX = 0.0, dY = -1.0),
            offsetOf(dX = -1.0, dY = 0.0),
            offsetOf(dX = -1.0, dY = -1.0),
        )
        check(offsets.size == 6)
        check(offsets.toSet().size == offsets.size)
        offsets.forEach { offset ->
            check(!offset.isEmpty())
            targets.forEach { a ->
                val b = a + offset
                val c = b + offset
                val d = c + offset
                listOf(a, b, c, d).also {
                    check(it.toSet().size == it.size)
                }
                val actual = isCollinear(
                    aX = a.x,
                    aY = a.y,
                    bX = b.x,
                    bY = b.y,
                    cX = c.x,
                    cY = c.y,
                    dX = d.x,
                    dY = d.y,
                )
                Assertions.assertTrue(actual) {
                    "a: $a, b: $b\nc: $c, d: $d"
                }
            }
        }
    }

    @Test
    fun isCollinearFalseTest() {
        val targets = listOf(
            pointOf(x = 1, y = 1),
            pointOf(x = 1, y = 0),
            pointOf(x = 1, y = -1),
            pointOf(x = 0, y = -1),
            pointOf(x = -1, y = -1),
            pointOf(x = -1, y = 0),
            pointOf(x = -1, y = 1),
            pointOf(x = 0, y = 1),
            pointOf(x = 0, y = 0),
        )
        check(targets.size == 9)
        check(targets.toSet().size == targets.size)
        val offsets = listOf(
            offsetOf(dX = 0.0, dY = 1.0),
            offsetOf(dX = 1.0, dY = 0.0),
            offsetOf(dX = 1.0, dY = 1.0),
            offsetOf(dX = 0.0, dY = -1.0),
            offsetOf(dX = -1.0, dY = 0.0),
            offsetOf(dX = -1.0, dY = -1.0),
        )
        check(offsets.size == 6)
        check(offsets.toSet().size == offsets.size)
        val wrongOffset = offsetOf(dX = 0.25, dY = 0.75)
        offsets.forEach { offset ->
            check(!offset.isEmpty())
            check(wrongOffset != offset)
            targets.forEach { a ->
                val b = a + offset
                val c = b + offset
                val d = c + wrongOffset
                listOf(a, b, c, d).also {
                    check(it.toSet().size == it.size)
                }
                val isCollinear = isCollinear(
                    aX = a.x,
                    aY = a.y,
                    bX = b.x,
                    bY = b.y,
                    cX = c.x,
                    cY = c.y,
                )
                check(isCollinear)
                val actual = isCollinear(
                    aX = a.x,
                    aY = a.y,
                    bX = b.x,
                    bY = b.y,
                    cX = c.x,
                    cY = c.y,
                    dX = d.x,
                    dY = d.y,
                )
                Assertions.assertFalse(actual) {
                    "a: $a, b: $b\nc: $c, d: $d"
                }
            }
        }
    }
}
