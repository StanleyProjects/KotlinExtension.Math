package sp.kx.math.implementation.computation.geometry

import org.junit.Assert.assertTrue
import org.junit.Test

class GeometryComputationTest {
    private data class Environment(val startX: Double, val startY: Double, val finishX: Double, val finishY: Double)
    @Test
    fun getAngleTest() {
        val quarter = kotlin.math.PI / 4
        val tests = setOf(
            (quarter * 0) to Environment(startX = 0.0, startY = 0.0, finishX = 1.0, finishY = 0.0),
            (quarter * 1) to Environment(startX = 0.0, startY = 0.0, finishX = 1.0, finishY = 1.0),
            (quarter * 2) to Environment(startX = 0.0, startY = 0.0, finishX = 0.0, finishY = 1.0),
            (quarter * 3) to Environment(startX = 0.0, startY = 0.0, finishX = -1.0, finishY = 1.0),
            (quarter * 4) to Environment(startX = 0.0, startY = 0.0, finishX = -1.0, finishY = 0.0),
            (kotlin.math.PI + quarter * 1) to Environment(startX = 0.0, startY = 0.0, finishX = -1.0, finishY = -1.0),
            (kotlin.math.PI + quarter * 2) to Environment(startX = 0.0, startY = 0.0, finishX = 0.0, finishY = -1.0),
            (kotlin.math.PI + quarter * 3) to Environment(startX = 0.0, startY = 0.0, finishX = 1.0, finishY = -1.0)
        )
        tests.forEach { (expected, env) ->
            val actual = getAngle(startX = env.startX, startY = env.startY, finishX = env.finishX, finishY = env.finishY)
            assertTrue("Expected angle is $expected, but actual is $actual!", expected == actual)
        }
    }
}
