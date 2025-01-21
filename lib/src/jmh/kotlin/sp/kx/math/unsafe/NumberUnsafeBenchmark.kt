package sp.kx.math.unsafe

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole
import java.math.BigDecimal
import kotlin.math.absoluteValue

@State(Scope.Benchmark)
internal open class NumberUnsafeBenchmark {
    @Param(
        value = [
//            "4000",
            "8000",
//            "16000",
            "32000",
//            "64000",
            "96000",
//            "128000",
        ],
    )
    var size: Int = 0

    private lateinit var doubles: List<Pair<Double, Double>>

    private fun initDoubles(size: Int, salt: String): List<Pair<Double, Double>> {
        val bytes = salt.toByteArray()
        val hashCode = bytes.contentHashCode()
        return List(size) { index ->
            val number = hashCode * size + index + 13
            val l1 = bytes[(number + 1).absoluteValue % bytes.size].toLong()
            val l2 = bytes[(number - 1).absoluteValue % bytes.size].toLong()
            val p1 = l1 * hashCode * 1.shl(12) / size + 13 - index
            val p2 = l2 * hashCode * 1.shl(16) / size + 13 - index
            val f = p1.toDouble() / p2 + (index % 4)
            val s1 = if (index % 4 == 0) -1 else 1
            val v1 = f * s1
            val border = index % 16
            val p = java.lang.Math.pow(10.0, -border.toDouble())
            val s2 = if (index % 5 == 0) -1 else 1
            val v2 = (f + p) * s2
            v1 to v2
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
                val actual = try {
                    eq(it = d1, other = d2, points = points)
                } catch (e: Throwable) {
                    val diff = BigDecimal.valueOf(d1) - BigDecimal.valueOf(d2)
                    val message = """
                        size: $size
                        index: $index
                        d1: $d1
                        d2: $d2
                        points: $points
                        diff: $diff
                    """.trimIndent()
                    throw IllegalStateException(message, e)
                }
                results[index] = actual
            }
        }
        hole.consume(results)
    }

    @Benchmark
    fun lt(hole: Blackhole) {
        val results = mutableMapOf<Int, Boolean>()
        for (index in doubles.indices) {
            val (d1, d2) = doubles[index]
            for (points in 1..16) {
                val actual = try {
                    lt(it = d1, other = d2, points = points)
                } catch (e: Throwable) {
                    val diff = BigDecimal.valueOf(d1) - BigDecimal.valueOf(d2)
                    val message = """
                        size: $size
                        index: $index
                        d1: $d1
                        d2: $d2
                        points: $points
                        diff: $diff
                    """.trimIndent()
                    throw IllegalStateException(message, e)
                }
                results[index] = actual
            }
        }
        hole.consume(results)
    }

    @Benchmark
    fun gt(hole: Blackhole) {
        val results = mutableMapOf<Int, Boolean>()
        for (index in doubles.indices) {
            val (d1, d2) = doubles[index]
            for (points in 1..16) {
                val actual = try {
                    gt(it = d1, other = d2, points = points)
                } catch (e: Throwable) {
                    val diff = BigDecimal.valueOf(d1) - BigDecimal.valueOf(d2)
                    val message = """
                        size: $size
                        index: $index
                        d1: $d1
                        d2: $d2
                        points: $points
                        diff: $diff
                    """.trimIndent()
                    throw IllegalStateException(message, e)
                }
                results[index] = actual
            }
        }
        hole.consume(results)
    }
}
