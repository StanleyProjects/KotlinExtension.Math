package sp.kx.math.measure

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

class MutableDoubleDeviation(
    override var actual: Double,
    override var expected: Double,
) : Deviation<Double> {
    override fun toString(): String {
        return toString(deviation = this, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Deviation<*>) return false
        val actual = other.actual
        if (actual !is Double) return false
        val expected = other.expected
        if (expected !is Double) return false
        return this.actual == actual && this.expected == expected
    }

    override fun hashCode(): Int {
        return Objects.hash(actual, expected)
    }
}
