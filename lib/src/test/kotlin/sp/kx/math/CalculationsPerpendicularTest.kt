package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress(
    "MagicNumber",
    "StringLiteralDuplication",
)
internal class CalculationsPerpendicularTest {
    @Test
    fun getPerpendicularZeroCTest() {
        val targets = listOf(
            pointOf(x = -5, y = 0) to pointOf(x = -4, y = 2),
            pointOf(x = -3, y = -1) to pointOf(x = -2, y = 1),
            pointOf(x = -3, y = 4) to pointOf(x = -4, y = 2),
            pointOf(x = -1, y = 3) to pointOf(x = -2, y = 1),
            pointOf(x = 1, y = 2) to pointOf(x = 0, y = 0),
            pointOf(x = 3, y = 1) to pointOf(x = 2, y = -1),
            pointOf(x = 5, y = 0) to pointOf(x = 4, y = -2),
            pointOf(x = -1, y = -2) to pointOf(x = 0, y = 0),
            pointOf(x = 1, y = -3) to pointOf(x = 2, y = -1),
            pointOf(x = 3, y = -4) to pointOf(x = 4, y = -2),
        )
        check(targets.size == 10)
        check(targets.toSet().size == targets.size)
        val b = pointOf(x = -4, y = 2)
        val c = pointOf(x = 0, y = 0)
        check(c.x == 0.0)
        check(b.x != c.x)
        check(b.y != c.y)
        targets.forEach { (a, expected) ->
            val actual = getPerpendicular(
                aX = a.x,
                aY = a.y,
                bX = b.x,
                bY = b.y,
                cX = c.x,
                cY = c.y,
            )
            Assertions.assertEquals(expected, actual) { "a: $a" }
        }
    }

    @Test
    fun getPerpendicularZeroBTest() {
        val targets = listOf(
            pointOf(x = -5, y = 0) to pointOf(x = -4, y = 2),
            pointOf(x = -3, y = -1) to pointOf(x = -2, y = 1),
            pointOf(x = -3, y = 4) to pointOf(x = -4, y = 2),
            pointOf(x = -1, y = 3) to pointOf(x = -2, y = 1),
            pointOf(x = 1, y = 2) to pointOf(x = 0, y = 0),
            pointOf(x = 3, y = 1) to pointOf(x = 2, y = -1),
            pointOf(x = 5, y = 0) to pointOf(x = 4, y = -2),
            pointOf(x = -1, y = -2) to pointOf(x = 0, y = 0),
            pointOf(x = 1, y = -3) to pointOf(x = 2, y = -1),
            pointOf(x = 3, y = -4) to pointOf(x = 4, y = -2),
        )
        check(targets.size == 10)
        check(targets.toSet().size == targets.size)
        val b = pointOf(x = 0, y = 0)
        val c = pointOf(x = 4, y = -2)
        check(b.x == 0.0)
        check(b.x != c.x)
        check(b.y != c.y)
        targets.forEach { (a, expected) ->
            val actual = getPerpendicular(
                aX = a.x,
                aY = a.y,
                bX = b.x,
                bY = b.y,
                cX = c.x,
                cY = c.y,
            )
            Assertions.assertEquals(expected, actual) { "a: $a" }
        }
    }

    @Test
    fun getPerpendicularTest() {
        val targets = listOf(
            pointOf(x = 5, y = 8) to pointOf(x = 4, y = 6),
            pointOf(x = 7, y = 7) to pointOf(x = 6, y = 5),
            pointOf(x = 9, y = 6) to pointOf(x = 8, y = 4),
            pointOf(x = 3, y = 4) to pointOf(x = 4, y = 6),
            pointOf(x = 5, y = 3) to pointOf(x = 6, y = 5),
            pointOf(x = 7, y = 2) to pointOf(x = 8, y = 4),
        )
        check(targets.size == 6)
        check(targets.toSet().size == targets.size)
        targets.forEach { (a, expected) ->
            val b = pointOf(x = 4, y = 6)
            val c = pointOf(x = 8, y = 4)
            val actual = getPerpendicular(
                aX = a.x,
                aY = a.y,
                bX = b.x,
                bY = b.y,
                cX = c.x,
                cY = c.y,
            )
            Assertions.assertEquals(expected, actual) { "a: $a" }
        }
    }

    @Test
    fun getPerpendicularBCXTest() {
        val a = pointOf(x = 3, y = 2)
        val b = pointOf(x = 1, y = 1)
        val c = pointOf(x = 1, y = 3)
        check(b.x == c.x)
        check(b.y != c.y)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = b.x,
            bY = b.y,
            cX = c.x,
            cY = c.y,
        )
        Assertions.assertEquals(a.y, p.y)
        Assertions.assertEquals(b.x, p.x)
        Assertions.assertEquals(c.x, p.x)
        Assertions.assertEquals(a.y, p.y)
        Assertions.assertEquals(1.0, p.x)
        Assertions.assertEquals(2.0, p.y)
    }

    @Test
    fun getPerpendicularBCYTest() {
        val targets = listOf(
            pointOf(x = 0, y = 1) to pointOf(x = 0, y = 0),
            pointOf(x = 1, y = 1) to pointOf(x = 1, y = 0),
            pointOf(x = 2, y = 1) to pointOf(x = 2, y = 0),
            pointOf(x = 0, y = -1) to pointOf(x = 0, y = 0),
            pointOf(x = 1, y = -1) to pointOf(x = 1, y = 0),
            pointOf(x = 2, y = -1) to pointOf(x = 2, y = 0),
        )
        check(targets.size == 6)
        check(targets.toSet().size == targets.size)
        val b = pointOf(x = 0, y = 0)
        val c = pointOf(x = 2, y = 0)
        check(b.x != c.x)
        check(b.y == c.y)
        targets.forEach { (a, expected) ->
            val actual = getPerpendicular(
                aX = a.x,
                aY = a.y,
                bX = b.x,
                bY = b.y,
                cX = c.x,
                cY = c.y,
            )
            Assertions.assertEquals(expected, actual)
        }
    }

    @Test
    fun getPerpendicularBACTest() {
        val a = pointOf(x = 3, y = 2)
        val b = pointOf(x = 1, y = 1)
        val c = pointOf(x = 5, y = 3)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = b.x,
            bY = b.y,
            cX = c.x,
            cY = c.y,
        )
        Assertions.assertEquals(a, p)
    }

    @Test
    fun getPerpendicularACTest() {
        val a = pointOf(x = 1, y = 1)
        val c = pointOf(x = 5, y = 3)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = a.x,
            bY = a.y,
            cX = c.x,
            cY = c.y,
        )
        Assertions.assertEquals(a, p)
    }

    @Test
    fun getPerpendicularBATest() {
        val a = pointOf(x = 3, y = 2)
        val b = pointOf(x = 1, y = 1)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = b.x,
            bY = b.y,
            cX = a.x,
            cY = a.y,
        )
        Assertions.assertEquals(a, p)
    }

    @Test
    fun getPerpendicularATest() {
        val a = pointOf(x = 3, y = 2)
        val p = getPerpendicular(
            aX = a.x,
            aY = a.y,
            bX = a.x,
            bY = a.y,
            cX = a.x,
            cY = a.y,
        )
        Assertions.assertEquals(a, p)
    }
}
