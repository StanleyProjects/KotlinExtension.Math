package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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

    @Test
    fun angleTest() {
        (pointOf(x = 1, y = 1) + pointOf(x = 3, y = 1)).also { vector: Vector ->
            Assertions.assertEquals(0.0.ct(), vector.angle().ct())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).ct(), vector.angle().ct())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = 3)).also { actual: Vector ->
            Assertions.assertEquals((kotlin.math.PI / 2).ct(), actual.angle().ct())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -1, y = 1)).also { actual: Vector ->
            Assertions.assertEquals(kotlin.math.PI.ct(), actual.angle().ct())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = -1)).also { vector: Vector ->
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).ct(), vector.angle().ct())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 4, y = 4)).also { vector: Vector ->
            Assertions.assertEquals((kotlin.math.PI / 4).ct(), vector.angle().ct())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 4, y = 4)).also { vector: Vector ->
            Assertions.assertEquals((kotlin.math.PI / 4).ct(), vector.angle().ct())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -2, y = 4)).also { vector: Vector ->
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).ct(), vector.angle().ct())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -2, y = -2)).also { vector: Vector ->
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).ct(), vector.angle().ct(), 0.00000000000001)
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 4, y = -2)).also { vector: Vector ->
            Assertions.assertEquals((-kotlin.math.PI / 4).ct(), vector.angle().ct())
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
