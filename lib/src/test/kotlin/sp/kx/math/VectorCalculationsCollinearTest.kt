package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress(
    "MagicNumber",
    "StringLiteralDuplication",
)
internal class VectorCalculationsCollinearTest {
    @Test
    fun isCollinearABCTest() {
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
                val b = a.copy()
                check(b == a)
                val c = b.copy()
                check(c == b)
                val actual = (a + b).isCollinear(target = c)
                Assertions.assertTrue(actual) {
                    "a: $a, b: $b, c: $c"
                }
            }
        }
    }

    @Test
    fun isCollinearBCTest() {
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
                check(b != a)
                val c = b.copy()
                check(c == b)
                val actual = (a + b).isCollinear(target = c)
                Assertions.assertTrue(actual) {
                    "a: $a, b: $b, c: $c"
                }
            }
        }
    }

    @Test
    fun isCollinearACTest() {
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
                check(b != a)
                val c = a.copy()
                check(c == a)
                val actual = (a + b).isCollinear(target = c)
                Assertions.assertTrue(actual) {
                    "a: $a, b: $b, c: $c"
                }
            }
        }
    }

    @Test
    fun isCollinearABTest() {
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
                val b = a.copy()
                check(b == a)
                val c = b + offset
                check(b != c)
                val actual = (a + b).isCollinear(target = c)
                Assertions.assertTrue(actual) {
                    "a: $a, b: $b, c: $c"
                }
            }
        }
    }

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
                check(b != a)
                val c = b + offset
                check(c != b)
                val actual = (a + b).isCollinear(target = c)
                Assertions.assertTrue(actual) {
                    "a: $a, b: $b, c: $c"
                }
            }
        }
    }

    @Test
    fun isCollinearBFalseTest() {
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
            val wrongOffset = offsetOf(dX = 0.25, dY = 0.75)
            check(wrongOffset != offset)
            targets.forEach { a ->
                val b = a + wrongOffset
                check(b != a)
                val c = b + offset
                check(c != b)
                val actual = (a + b).isCollinear(target = c)
                Assertions.assertFalse(actual) {
                    "a: $a, b: $b, c: $c"
                }
            }
        }
    }

    @Test
    fun isCollinearCFalseTest() {
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
            val wrongOffset = offsetOf(dX = 0.25, dY = 0.75)
            check(wrongOffset != offset)
            targets.forEach { a ->
                val b = a + offset
                check(b != a)
                val c = b + wrongOffset
                check(c != b)
                val actual = (a + b).isCollinear(target = c)
                Assertions.assertFalse(actual) {
                    "a: $a, b: $b, c: $c"
                }
            }
        }
    }
}
