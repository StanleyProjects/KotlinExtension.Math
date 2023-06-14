package sp.kx.math.measure

interface Deviation<T : Comparable<T>> {
    val actual: T
    val expected: T
}
