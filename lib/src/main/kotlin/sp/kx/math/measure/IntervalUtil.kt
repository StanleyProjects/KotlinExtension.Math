package sp.kx.math.measure

fun <T : Comparable<T>> Interval<T>.isEmpty(): Boolean {
    return a == b
}
