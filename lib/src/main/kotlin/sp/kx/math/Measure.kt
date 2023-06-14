package sp.kx.math

import java.util.concurrent.TimeUnit
import kotlin.time.Duration

interface Measure<T : Any, U : Any> {
    fun transform(units: T): U
}

private class MeasureUnit(var raw: Int) : Measure<Double, Int> {
    override fun transform(units: Double): Int {
        1.. 2
        return (units * raw).toInt()
    }
}

interface Interval<T : Comparable<T>> {
    val a: T
    val b: T
    fun getDiff(): T
}

//class MutableInterval<T : Comparable<T>>(
//    override var a: T,
//    override var b: T,
//) : Interval<T> {
//    override fun getDiff(): T {
//        return b - a
//    }
//}
