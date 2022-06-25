package sp.kx.math.implementation.computation.number

import kotlin.math.absoluteValue

fun Double.isSame(that: Double, epsilon: Double): Boolean {
    check(epsilon < 1.0)
    return (this - that).absoluteValue < epsilon
}

fun Double.normalize(k: Double): Double {
    return ((this % k) + k) % k
}

fun Double.isLessThan(that: Double, epsilon: Double): Boolean {
    check(epsilon < 1.0)
    val d = this - that
    return d.absoluteValue > epsilon && d < 0
}

fun Double.isMoreThan(that: Double, epsilon: Double): Boolean {
    check(epsilon < 1.0)
    val d = this - that
    return d.absoluteValue > epsilon && d > 0
}
