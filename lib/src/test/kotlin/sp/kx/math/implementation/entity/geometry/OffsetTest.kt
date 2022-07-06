package sp.kx.math.implementation.entity.geometry

import org.junit.Test
import util.junit.assert

class OffsetTest {
    @Test
    fun toStringTest() {
        val string = offsetOf(dX = 3.0, dY = 4.0).toString()
        string.assert("{dX:3.00,dY:4.00}", name = "Offset.toString")
    }

    @Test
    fun offsetOfTest() {
        val dX = 3.0
        val dY = 4.0
        val offset = offsetOf(dX = dX, dY = dY)
        offset.dX.assert(dX, "dX")
        offset.dY.assert(dY, "dY")
    }
}
