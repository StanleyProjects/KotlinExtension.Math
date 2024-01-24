package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("MagicNumber")
internal class VectorIsEmptyTest {
    @Test
    fun isEmptyTest() {
        (pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)).also { vector: Vector ->
            Assertions.assertFalse(vector.isEmpty())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1.1, y = 1.0)).also { vector: Vector ->
            Assertions.assertFalse(vector.isEmpty())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = 1)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty())
        }
        (pointOf(x = -1, y = -1) + pointOf(x = -1.0, y = -1.0)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty())
        }
    }

    @Test
    fun isEmptyDeltaFalseTest() {
        assertIsEmpty(
            vector = vectorOf(startX = 0.1, startY = 1.0, finishX = 0.1, finishY = 1.0),
            points = 1,
            isEmpty = true,
        )
        assertIsEmpty(
            vector = vectorOf(startX = 0.1, startY = 1.0, finishX = 0.2, finishY = 1.0),
            points = 1,
            isEmpty = false,
        )
        val issues = listOf(
            0.12 to 0.13,
            0.123 to 0.124,
            0.1234 to 0.1235,
            0.12345 to 0.12346,
            0.123456 to 0.123457,
            0.1234567 to 0.1234568,
            0.12345678 to 0.12345679,
            0.123456789 to 0.12345679,
        )
        check(issues.size == 8)
        check(issues.toSet().size == issues.size)
        issues.forEachIndexed { index, (startX, finishX) ->
            val vector = vectorOf(startX = startX, startY = 1.0, finishX = finishX, finishY = 1.0)
            assertIsEmpty(vector = vector, points = index + 1, isEmpty = true)
            assertIsEmpty(vector = vector, points = index + 2, isEmpty = false)
        }
    }

    @Test
    fun isEmptyDeltaTest() {
        val issues = listOf(
            0.1,
            0.12,
            0.123,
            0.1234,
            0.12345,
            0.123456,
            0.1234567,
            0.12345678,
            0.123456789,
        )
        check(issues.size == 9)
        check(issues.toSet().size == issues.size)
        for (index in 0..issues.size - 2) {
            val startX = issues[index]
            val finishX = issues[index + 1]
            val vector = vectorOf(startX = startX, startY = 1.0, finishX = finishX, finishY = 1.0)
            assertIsEmpty(vector = vector, points = index + 1, isEmpty = true)
            assertIsEmpty(vector = vector, points = index + 2, isEmpty = false)
        }
    }

    @Test
    fun isEmptyDeltaOneTest() {
        val issues = listOf(
            pointOf(x = 1.01, y = 1.0) to 2,
            pointOf(x = 1.001, y = 1.0) to 3,
            pointOf(x = 1.0001, y = 1.0) to 4,
            pointOf(x = 1.00001, y = 1.0) to 5,
            pointOf(x = 1.000001, y = 1.0) to 6,
            pointOf(x = 1.0000001, y = 1.0) to 7,
            pointOf(x = 1.00000001, y = 1.0) to 8,
            pointOf(x = 1.000000001, y = 1.0) to 9,
        )
        check(issues.size == 8)
        check(issues.toSet().size == issues.size)
        issues.forEach { (start, points) ->
            assertIsEmpty(vector = start + pointOf(x = 1, y = 1), points = points - 1, isEmpty = true)
            assertIsEmpty(vector = start + pointOf(x = 1, y = 1), points = points, isEmpty = false)
        }
    }

    @Test
    fun isEmptyPointsTest() {
        (pointOf(x = 1.001, y = 1.0) + pointOf(x = 1, y = 1)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty(points = 1))
            Assertions.assertTrue(vector.isEmpty(points = 2))
            assertIsEmpty(vector = vector, points = 3, isEmpty = false)
            Assertions.assertFalse(vector.isEmpty(points = 4))
            Assertions.assertFalse(vector.isEmpty(points = 8))
            Assertions.assertFalse(vector.isEmpty(points = 16))
        }
        (pointOf(x = 1.2, y = 3.4) + pointOf(x = 1.25, y = 3.46)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty(points = 1))
            Assertions.assertFalse(vector.isEmpty(points = 2))
        }
        (pointOf(x = 1.01, y = 1.0) + pointOf(x = 1.0, y = 1.0)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty(points = 1))
            Assertions.assertFalse(vector.isEmpty(points = 2))
            Assertions.assertFalse(vector.isEmpty(points = 4))
            Assertions.assertFalse(vector.isEmpty(points = 8))
            Assertions.assertFalse(vector.isEmpty(points = 16))
        }
        (pointOf(x = 1.001, y = 1.0) + pointOf(x = 1.0, y = 1.0)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty(points = 1))
            Assertions.assertTrue(vector.isEmpty(points = 2))
            assertIsEmpty(vector = vector, points = 3, isEmpty = false)
            Assertions.assertFalse(vector.isEmpty(points = 4))
            Assertions.assertFalse(vector.isEmpty(points = 8))
            Assertions.assertFalse(vector.isEmpty(points = 16))
        }
        (pointOf(x = 1.00000001, y = 1.0) + pointOf(x = 1.0, y = 1.0)).also { vector: Vector ->
            Assertions.assertTrue(vector.isEmpty(points = 1))
            Assertions.assertTrue(vector.isEmpty(points = 2))
            Assertions.assertTrue(vector.isEmpty(points = 3))
            Assertions.assertTrue(vector.isEmpty(points = 4))
            assertIsEmpty(vector = vector, points = 8, isEmpty = false)
            Assertions.assertFalse(vector.isEmpty(points = 16))
        }
    }

    @Test
    fun isEmptyErrorTest() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val foo = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
            @Suppress("IgnoredReturnValue")
            foo.isEmpty(points = 0)
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val foo = pointOf(x = 1.23, y = 4.56) + pointOf(x = 7.89, y = 10.1)
            @Suppress("IgnoredReturnValue")
            foo.isEmpty(points = -1)
        }
    }

    companion object {
        private fun assertIsEmpty(vector: Vector, points: Int, isEmpty: Boolean) {
            Assertions.assertEquals(isEmpty, vector.isEmpty(points = points))
        }
    }
}
