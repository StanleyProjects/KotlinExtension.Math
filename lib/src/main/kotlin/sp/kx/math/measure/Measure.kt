package sp.kx.math.measure

interface Measure<T : Any, U : Any> {
    fun transform(units: T): U
}
