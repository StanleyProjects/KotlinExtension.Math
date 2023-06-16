package sp.kx.math.measure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MutableDeviationTest {
    @Test
    fun constructorTest() {
        val deviation = MutableDeviation(
            actual = 1.2,
            expected = 3.4,
        )
        Assertions.assertNotEquals(deviation.actual, deviation.expected)
        Assertions.assertEquals(1.2, deviation.actual)
        Assertions.assertEquals(3.4, deviation.expected)
        deviation.actual = 5.6
        Assertions.assertEquals(5.6, deviation.actual)
        Assertions.assertEquals(3.4, deviation.expected)
        deviation.expected = 7.8
        Assertions.assertEquals(5.6, deviation.actual)
        Assertions.assertEquals(7.8, deviation.expected)
    }
}
