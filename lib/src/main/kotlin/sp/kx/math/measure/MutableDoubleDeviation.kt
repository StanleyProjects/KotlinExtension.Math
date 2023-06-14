package sp.kx.math.measure

import java.util.Objects

class MutableDoubleDeviation(
    override var actual: Double,
    override var expected: Double,
) : Deviation<Double> {
    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return Objects.hash(actual, expected)
    }
}
