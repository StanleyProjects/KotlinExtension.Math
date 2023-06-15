package sp.kx.math.measure

interface Measure<T : Comparable<T>, U : Comparable<U>> {
    val magnitude: U
    fun transform(units: T): U
}
