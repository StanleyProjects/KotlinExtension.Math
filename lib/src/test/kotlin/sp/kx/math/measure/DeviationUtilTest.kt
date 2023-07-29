package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DeviationUtilTest {
    @Test
    fun diffTest() {
        val deviation: Deviation<Double> = MutableDeviation(
            actual = 1.2,
            expected = 3.4,
        )
        Assertions.assertNotEquals(deviation.actual, deviation.expected)
        Assertions.assertEquals(1.2, deviation.actual)
        Assertions.assertEquals(3.4, deviation.expected)
        Assertions.assertEquals(1.2 - 3.4, deviation.diff())
    }
}
