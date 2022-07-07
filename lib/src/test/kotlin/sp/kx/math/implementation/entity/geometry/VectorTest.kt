package sp.kx.math.implementation.entity.geometry

import org.junit.Test
import util.junit.assert

class VectorTest {
    @Test
    fun toStringTest() {
        val start = pointOf(x = 1.0, y = 2.0)
        val finish = pointOf(x = 3.0, y = 4.0)
        val string = start.toVector(finish = finish).toString()
        string.assert("{start:$start,finish:$finish}", name = "Vector.toString")
    }

    @Test
    fun toVectorTest() {
        val start = pointOf(x = 1.0, y = 2.0)
        val finish = pointOf(x = 3.0, y = 4.0)
        val vector = start.toVector(finish = finish)
        start.assert(vector.start, prefix = "start.")
        finish.assert(vector.finish, prefix = "finish.")
    }

    @Test
    fun toVectorOffsetTest() {
        val start = pointOf(x = 1.0, y = 2.0)
        val offset = offsetOf(dX = 3.0, dY = 4.0)
        val vector = start.toVector(offset = offset)
        start.assert(vector.start, prefix = "start.")
        start.updated(offset).assert(vector.finish, prefix = "finish.")
    }
}
