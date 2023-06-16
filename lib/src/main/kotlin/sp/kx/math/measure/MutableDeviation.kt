package sp.kx.math.measure

class MutableDeviation<T : Comparable<T>>(
    override var actual: T,
    override var expected: T,
) : Deviation<T>
