package sp.kx.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ImmutableVectorOffsetTest {
    @Test
    fun vectorOfTest() {
        val dX = 12.8
        val dY = 25.6
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finishX = 5.6,
            finishY = 7.8,
            dX = dX,
            dY = dY,
        )
        assertNotEquals(actual.start, actual.finish)
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(1.2 + dX, actual.start.x)
        assertEquals(3.4 + dY, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(5.6 + dX, actual.finish.x)
        assertEquals(7.8 + dY, actual.finish.y)
    }

    @Test
    fun vectorOfOffsetTest() {
        val offset = offsetOf(dX = 12.8, dY = 25.6)
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finishX = 5.6,
            finishY = 7.8,
            offset = offset,
        )
        assertNotEquals(actual.start, actual.finish)
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(1.2 + offset.dX, actual.start.x)
        assertEquals(3.4 + offset.dY, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(5.6 + offset.dX, actual.finish.x)
        assertEquals(7.8 + offset.dY, actual.finish.y)
    }

    @Test
    fun vectorOfPointTest() {
        val finish = pointOf(x = 5.6, y = 7.8)
        val dX = 12.8
        val dY = 25.6
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finish = finish,
            dX = dX,
            dY = dY,
        )
        assertNotEquals(actual.start, actual.finish)
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(1.2 + dX, actual.start.x)
        assertEquals(3.4 + dY, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(5.6 + dX, actual.finish.x)
        assertEquals(7.8 + dY, actual.finish.y)
        assertEquals(finish.x + dX, actual.finish.x)
        assertEquals(finish.y + dY, actual.finish.y)
    }

    @Test
    fun vectorOfPointOffsetTest() {
        val finish = pointOf(x = 5.6, y = 7.8)
        val offset = offsetOf(dX = 12.8, dY = 25.6)
        val actual: Vector = vectorOf(
            startX = 1.2,
            startY = 3.4,
            finish = finish,
            offset = offset,
        )
        assertNotEquals(actual.start, actual.finish)
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(1.2 + offset.dX, actual.start.x)
        assertEquals(3.4 + offset.dY, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(5.6 + offset.dX, actual.finish.x)
        assertEquals(7.8 + offset.dY, actual.finish.y)
        assertEquals(finish.x + offset.dX, actual.finish.x)
        assertEquals(finish.y + offset.dY, actual.finish.y)
    }

    @Test
    fun toVectorOffsetTest() {
        val foo = pointOf(x = 1.2, y = 3.4)
        val offset = offsetOf(dX = 12.8, dY = 25.6)
        val actual: Vector = foo.toVector(offset = offset)
        assertEquals(actual.start, foo)
        assertNotEquals(actual.start, actual.finish)
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(1.2, actual.start.x)
        assertEquals(3.4, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(1.2 + 12.8, actual.finish.x)
        assertEquals(3.4 + 25.6, actual.finish.y)
        assertEquals(1.2 + offset.dX, actual.finish.x)
        assertEquals(3.4 + offset.dY, actual.finish.y)
        assertEquals(actual.start.x + offset.dX, actual.finish.x)
        assertEquals(actual.start.y + offset.dY, actual.finish.y)
    }

    @Test
    fun toVectorPointOffsetTest() {
        val offset = offsetOf(dX = 12.8, dY = 25.6)
        val foo = pointOf(x = 1.2, y = 3.4)
        val bar = pointOf(x = 5.6, y = 7.8)
        val actual: Vector = foo.toVector(finish = bar, offset = offset)
        assertNotEquals(actual.start, actual.finish)
        assertNotEquals(actual.start.x, actual.start.y)
        assertEquals(1.2 + offset.dX, actual.start.x)
        assertEquals(3.4 + offset.dY, actual.start.y)
        assertNotEquals(actual.finish.x, actual.finish.y)
        assertEquals(5.6 + offset.dX, actual.finish.x)
        assertEquals(7.8 + offset.dY, actual.finish.y)
        assertEquals(foo.x + offset.dX, actual.start.x)
        assertEquals(foo.y + offset.dY, actual.start.y)
        assertEquals(bar.x + offset.dX, actual.finish.x)
        assertEquals(bar.y + offset.dY, actual.finish.y)
    }

    @Test
    fun toOffsetTest() {
        val delta = 0.0001
        val points = 4
        listOf(
            vectorOf(-1.0, -1.0, 0.0, 0.0) to offsetOf(1.0, 1.0),
            vectorOf(0.0, 0.0, 0.0, 0.0) to offsetOf(0.0, 0.0),
            vectorOf(0.0, 0.0, 1.0, 1.0) to offsetOf(1.0, 1.0),
            vectorOf(1.0, 1.0, 0.0, 0.0) to offsetOf(-1.0, -1.0),
            vectorOf(1.0, 1.0, 1.0, 1.0) to offsetOf(0.0, 0.0),
            vectorOf(1.2, 3.4, 5.6, 7.8) to offsetOf(4.4, 4.4),
        ).forEach { (vector, expected) ->
            val actual = vector.toOffset()
            val message = """
                vector: $vector (${vector.toString(24)})
                expected: $expected (${expected.toString(24)})
                actual: $actual (${actual.toString(24)})
                delta: $delta (${delta.toString(24)})
                points: $points
            """.trimIndent()
            assertEquals(expected.dX, actual.dX, delta, message)
            assertEquals(expected.dY, actual.dY, delta, message)
            assertTrue(expected.eq(actual, points = points), message)
        }
    }
}
