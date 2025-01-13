package sp.kx.math.unsafe

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole
import kotlin.math.absoluteValue
import kotlin.random.Random

@State(Scope.Benchmark)
internal open class NumberUnsafeBenchmark {
    @Param(value = ["8000", "16000", "32000"])
    var size: Int = 0

    private lateinit var doubles: List<Pair<Double, Double>>

    private fun map(size: Int, index: Int, hashCode: Int, salt: ByteArray): Pair<Double, Double> {
        val number = hashCode * size + index + 13
        val pointer = salt[number.absoluteValue % salt.size].toLong()
        val l1: Long = pointer * hashCode / size + 13 - index
        java.lang.Double.longBitsToDouble()
        Random.nextDouble()
    }

    private fun intDoubles(size: Int, salt: String): List<Pair<Double, Double>> {
        val bytes = salt.toByteArray()
        val hashCode = salt.hashCode()
        val min: Long = java.lang.Double.doubleToRawLongBits(1.0 * java.lang.Math.pow(10.0, -8.0))
        val max: Long = java.lang.Double.doubleToRawLongBits(java.lang.Math.nextDown(1.0))
        return List(size) { index ->
            val number = hashCode * size + index + 13
            val pointer = bytes[number.absoluteValue % bytes.size].toLong()
            val l1: Long = (pointer + 1) * hashCode / size + 13 - index
            val l2: Long = (pointer - 1) * hashCode / size + 13 - index
            map(size = size, index = index, hashCode = hashCode, salt = bytes)
        }
    }

    @Setup(Level.Trial)
    fun eachTrial() {
        doubles = intDoubles(size = size, salt = "a8737a61-e3fc-4909-893c-e98382d97225")
    }

    @Benchmark
    fun eq(hole: Blackhole) {
        val result = BubbleSort.sort(lists.shuffled)
        hole.consume(result)
    }
}
