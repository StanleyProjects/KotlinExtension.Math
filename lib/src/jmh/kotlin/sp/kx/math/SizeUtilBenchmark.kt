package sp.kx.math

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole
import kotlin.math.absoluteValue

@State(Scope.Benchmark)
internal open class SizeUtilBenchmark {
    @Param(
        value = [
//            "8000",
//            "32000",
//            "128000",
//            "256000",
//            "512000",
//            "1000000",
            "2000000",
        ],
    )
    var size: Int = 0

    private lateinit var sizes: List<Size>

    private fun getLong(size: Int, index: Int, bytes: ByteArray, hashCode: Int): Long {
        val number = hashCode * size + index + 13
        val l = bytes[number.absoluteValue % bytes.size].toLong()
        return l * hashCode * 1.shl(12) / size + 13 - index
    }

    private fun initSizes(size: Int, salt: String): List<Size> {
        val bytes = salt.toByteArray()
        val hashCode = bytes.contentHashCode()
        return List(size) { index ->
            val p = getLong(size = size, index = index, bytes = bytes, hashCode = hashCode)
            val p1 = getLong(size = size, index = index - 1, bytes = bytes, hashCode = hashCode)
            val p2 = getLong(size = size, index = index + 1, bytes = bytes, hashCode = hashCode)
            val width = p.toDouble() / p1 + (index % 16)
            val height = p.toDouble() / p2 + (index % 32)
            sizeOf(width = width, height = height)
        }
    }

    @Setup(Level.Trial)
    fun eachTrial() {
        sizes = initSizes(size = size, salt = "39c024b8-d724-4285-966d-fc570031539a")
    }

    @Benchmark
    fun diagonal(hole: Blackhole) {
        val results = mutableMapOf<Int, Double>()
        sizes.forEachIndexed { index, size ->
            val actual = size.diagonal()
            results[index] = when (index % 4) {
                0 -> 1 / actual
                1 -> actual * actual
                2 -> kotlin.math.log2(actual)
                else -> kotlin.math.sqrt(actual)
            }
        }
        hole.consume(results)
    }
}
