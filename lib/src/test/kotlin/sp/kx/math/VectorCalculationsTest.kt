package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.PI
import kotlin.math.floor

@Suppress("MagicNumber")
internal class VectorCalculationsTest {
    @Test
    fun lengthTest() {
        (pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)).also { actual: Vector ->
            Assertions.assertEquals(2.0, actual.length())
        }
        (pointOf(x = 3, y = 1) + pointOf(x = 1, y = 1)).also { actual: Vector ->
            Assertions.assertEquals(2.0, actual.length())
        }
        (pointOf(x = 1, y = -1) + pointOf(x = 1, y = 2)).also { actual: Vector ->
            Assertions.assertEquals(3.0, actual.length())
        }
        (pointOf(x = 1, y = 2) + pointOf(x = 1, y = -1)).also { actual: Vector ->
            Assertions.assertEquals(3.0, actual.length())
        }
    }

    private fun assertRadians(expected: Double, actual: Double) {
        val pi2 = kotlin.math.PI * 2
        Assertions.assertEquals(
            expected - pi2 * floor((expected + PI) / pi2),
            actual - pi2 * floor((actual + PI) / pi2),
        )
    }

    @Test
    fun angleTest() {
        (pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)).also { vector: Vector ->
            assertRadians(0.0, vector.angle())
            assertRadians(kotlin.math.PI + kotlin.math.PI, vector.angle())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = 3)).also { actual: Vector ->
            assertRadians(kotlin.math.PI / 2, actual.angle())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -1, y = 1)).also { actual: Vector ->
            assertRadians(kotlin.math.PI, actual.angle())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = -1)).also { vector: Vector ->
            assertRadians(kotlin.math.PI + kotlin.math.PI / 2, vector.angle())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 4, y = 4)).also { vector: Vector ->
            assertRadians(kotlin.math.PI / 4, vector.angle())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 4, y = 4)).also { vector: Vector ->
            assertRadians(kotlin.math.PI / 4, vector.angle())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -2, y = 4)).also { vector: Vector ->
            assertRadians(kotlin.math.PI / 2 + kotlin.math.PI / 4, vector.angle())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -2, y = -2)).also { vector: Vector ->
            assertRadians(kotlin.math.PI + kotlin.math.PI / 4, vector.angle())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 4, y = -2)).also { vector: Vector ->
            assertRadians(-kotlin.math.PI / 4, vector.angle())
        }
    }

    @Test
    fun centerTest() {
        (pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)).also { vector: Vector ->
            val actual = vector.center()
            Assertions.assertEquals(2.0, actual.x)
            Assertions.assertEquals(1.0, actual.y)
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = 3)).also { vector: Vector ->
            val actual = vector.center()
            Assertions.assertEquals(1.0, actual.x)
            Assertions.assertEquals(2.0, actual.y)
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -1, y = 1)).also { vector: Vector ->
            val actual = vector.center()
            Assertions.assertEquals(0.0, actual.x)
            Assertions.assertEquals(1.0, actual.y)
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = -1)).also { vector: Vector ->
            val actual = vector.center()
            Assertions.assertEquals(1.0, actual.x)
            Assertions.assertEquals(0.0, actual.y)
        }
        (pointOf(x = 0, y = 0) + pointOf(x = 4, y = 4)).also { vector: Vector ->
            val actual = vector.center()
            Assertions.assertEquals(2.0, actual.x)
            Assertions.assertEquals(2.0, actual.y)
        }
    }
}
