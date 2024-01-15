package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress(
    "MagicNumber",
    "StringLiteralDuplication",
)
internal class VectorCalculationsPerpendicularTest {
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
        val vector = b + c
        targets.forEach { (target, expected) ->
            val actual = vector.getPerpendicular(target = target)
            Assertions.assertEquals(expected, actual) { "target: $target" }
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
        val vector = b + c
        targets.forEach { (target, expected) ->
            val actual = vector.getPerpendicular(target = target)
            Assertions.assertEquals(expected, actual) { "target: $target" }
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
        val b = pointOf(x = 4, y = 6)
        val c = pointOf(x = 8, y = 4)
        val vector = b + c
        targets.forEach { (target, expected) ->
            val actual = vector.getPerpendicular(target = target)
            Assertions.assertEquals(expected, actual) { "target: $target" }
        }
    }

    @Test
    fun getPerpendicularBCXTest() {
        val target = pointOf(x = 3, y = 2)
        val b = pointOf(x = 1, y = 1)
        val c = pointOf(x = 1, y = 3)
        check(b.x == c.x)
        check(b.y != c.y)
        val vector = b + c
        val actual = vector.getPerpendicular(target = target)
        Assertions.assertEquals(target.y, actual.y)
        Assertions.assertEquals(b.x, actual.x)
        Assertions.assertEquals(c.x, actual.x)
        Assertions.assertEquals(target.y, actual.y)
        Assertions.assertEquals(1.0, actual.x)
        Assertions.assertEquals(2.0, actual.y)
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
        val vector = b + c
        targets.forEach { (target, expected) ->
            val actual = vector.getPerpendicular(target = target)
            Assertions.assertEquals(expected, actual) { "target: $target" }
        }
    }

    @Test
    fun getPerpendicularBACTest() {
        val target = pointOf(x = 3, y = 2)
        val b = pointOf(x = 1, y = 1)
        val c = pointOf(x = 5, y = 3)
        val vector = b + c
        val actual = vector.getPerpendicular(target = target)
        Assertions.assertEquals(target, actual) { "target: $target" }
    }

    @Test
    fun getPerpendicularACTest() {
        val target = pointOf(x = 1, y = 1)
        val c = pointOf(x = 5, y = 3)
        val vector = target + c
        val actual = vector.getPerpendicular(target = target)
        Assertions.assertEquals(target, actual) { "target: $target" }
    }

    @Test
    fun getPerpendicularBATest() {
        val target = pointOf(x = 3, y = 2)
        val b = pointOf(x = 1, y = 1)
        val vector = b + target
        val actual = vector.getPerpendicular(target = target)
        Assertions.assertEquals(target, actual) { "target: $target" }
    }

    @Test
    fun getPerpendicularATest() {
        val target = pointOf(x = 3, y = 2)
        val vector = target + target
        val actual = vector.getPerpendicular(target = target)
        Assertions.assertEquals(target, actual) { "target: $target" }
    }
}
