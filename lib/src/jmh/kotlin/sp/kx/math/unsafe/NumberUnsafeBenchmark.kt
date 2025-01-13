package sp.kx.math.unsafe

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole
import kotlin.math.absoluteValue
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

@State(Scope.Benchmark)
internal open class NumberUnsafeBenchmark {
    @Param(value = ["8000", "16000", "32000"])
    var size: Int = 0

    private lateinit var doubles: List<Pair<Double, Double>>

    private fun initDoubles(size: Int, salt: String): List<Pair<Double, Double>> {
        val bytes = salt.toByteArray()
        val hashCode = salt.hashCode()
        return List(size) { index ->
            val number = hashCode * size + index + 13
            val l1 = bytes[(number + 1).absoluteValue % bytes.size].toLong()
            val l2 = bytes[(number - 1).absoluteValue % bytes.size].toLong()
            val p1 = l1 * hashCode * 1.shl(12) / size + 13 - index
            val p2 = l2 * hashCode * 1.shl(16) / size + 13 - index
            val d = p1.toDouble() / p2
            val d1 = d - d.toLong() + (index % 4)
            val d2 = d1 - java.lang.Math.pow(10.0, -(index % 16).plus(1).toDouble())
            d1 to d2
        }
    }

    @Setup(Level.Trial)
    fun eachTrial() {
        doubles = initDoubles(size = size, salt = "a8737a61-e3fc-4909-893c-e98382d97225")
    }

    @Benchmark
    fun eq(hole: Blackhole) {
        val results = mutableMapOf<Int, Boolean>()
        for (index in doubles.indices) {
            val (d1, d2) = doubles[index]
            for (points in 1..16) {
                val diff = BigDecimal(d1).subtract(BigDecimal(d2))
                val expected = diff
                    .scaleByPowerOfTen(points)
                    .setScale(1, RoundingMode.HALF_EVEN)
                    .toBigInteger()
                    .equals(BigInteger.ZERO)
                val message = """
                    size: $size
                    index: $index
                    d1: $d1
                    d2: $d2
                    points: $points
                    diff: $diff
                """.trimIndent()
                val actual = try {
                    eq(it = d1, other = d2, points = points)
                } catch (e: Throwable) {
                    throw IllegalStateException(message, e)
                }
                check(expected == actual) { message }
            }
        }
        hole.consume(results)
    }
}
