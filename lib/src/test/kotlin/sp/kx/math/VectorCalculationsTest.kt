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
            Assertions.assertEquals(0.0.radians(), vector.angle().radians())
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI).radians(), vector.angle().radians())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = 3)).also { actual: Vector ->
            Assertions.assertEquals((kotlin.math.PI / 2).radians(), actual.angle().radians())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -1, y = 1)).also { actual: Vector ->
            Assertions.assertEquals(kotlin.math.PI.radians(), actual.angle().radians())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 1, y = -1)).also { vector: Vector ->
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 2).radians(), vector.angle().radians())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 4, y = 4)).also { vector: Vector ->
            Assertions.assertEquals((kotlin.math.PI / 4).radians(), vector.angle().radians())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -2, y = 4)).also { vector: Vector ->
            Assertions.assertEquals((kotlin.math.PI / 2 + kotlin.math.PI / 4).radians(), vector.angle().radians())
        }
        (pointOf(x = 1, y = 1) + pointOf(x = -2, y = -2)).also { vector: Vector ->
            Assertions.assertEquals((kotlin.math.PI + kotlin.math.PI / 4).radians(), vector.angle().radians(), 0.00000000000001)
        }
        (pointOf(x = 1, y = 1) + pointOf(x = 4, y = -2)).also { vector: Vector ->
            Assertions.assertEquals((-kotlin.math.PI / 4).radians(), vector.angle().radians())
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
