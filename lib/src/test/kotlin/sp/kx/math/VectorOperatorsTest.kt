package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sp.kx.math.measure.Measure
import sp.kx.math.measure.measureOf

internal class VectorOperatorsTest {
    @Test
    fun plusOffsetTest() {
        val vector = pointOf(x = 1.2, y = 3.4) + pointOf(x = 5.6, y = 7.8)
        offsetOf(dX = 1.23, dY = 4.56).also { offset: Offset ->
            val actual = vector + offset
            Assertions.assertEquals(actual.start.x, vector.start.x + offset.dX)
            Assertions.assertEquals(actual.start.y, vector.start.y + offset.dY)
            Assertions.assertEquals(actual.finish.x, vector.finish.x + offset.dX)
            Assertions.assertEquals(actual.finish.y, vector.finish.y + offset.dY)
        }
        offsetOf(dX = -7.89, dY = -10.1112).also { offset: Offset ->
            val actual = vector + offset
            Assertions.assertEquals(actual.start.x, vector.start.x + offset.dX)
            Assertions.assertEquals(actual.start.y, vector.start.y + offset.dY)
            Assertions.assertEquals(actual.finish.x, vector.finish.x + offset.dX)
            Assertions.assertEquals(actual.finish.y, vector.finish.y + offset.dY)
        }
    }

    @Test
    fun plusMeasureTest() {
        val vector = pointOf(x = 1.2, y = 3.4) + pointOf(x = 5.6, y = 7.8)
        measureOf(magnitude = 1.23).also { measure: Measure<Double, Double> ->
            val actual = vector + measure
            Assertions.assertEquals(actual.start.x, measure.transform(vector.start.x))
            Assertions.assertEquals(actual.start.y, measure.transform(vector.start.y))
            Assertions.assertEquals(actual.finish.x, measure.transform(vector.finish.x))
            Assertions.assertEquals(actual.finish.y, measure.transform(vector.finish.y))
        }
        measureOf(magnitude = -4.56).also { measure: Measure<Double, Double> ->
            val actual = vector + measure
            Assertions.assertEquals(actual.start.x, measure.transform(vector.start.x))
            Assertions.assertEquals(actual.start.y, measure.transform(vector.start.y))
            Assertions.assertEquals(actual.finish.x, measure.transform(vector.finish.x))
            Assertions.assertEquals(actual.finish.y, measure.transform(vector.finish.y))
        }
    }
}
