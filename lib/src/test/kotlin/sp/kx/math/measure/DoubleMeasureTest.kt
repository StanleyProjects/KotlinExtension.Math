package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DoubleMeasureTest {
    @Test
    fun measureOfTest() {
        val measure = measureOf(magnitude = 1.2)
        Assertions.assertEquals(1.2, measure.magnitude)
        Assertions.assertEquals(2.4, measure.transform(2.0))
    }
}
