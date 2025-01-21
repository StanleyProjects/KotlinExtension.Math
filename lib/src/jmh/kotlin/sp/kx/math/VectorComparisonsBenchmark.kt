package sp.kx.math

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Level
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
internal open class VectorComparisonsBenchmark {
    private class VectorComparisons(
        val vectors: Iterable<Vector>,
        val target: Point,
        val minDistance: Double,
        val points: Int,
    )

    @Param(
        value = [
            "128",
            "256",
            "512",
        ],
    )
    var size: Int = 0

    private lateinit var comparisons: List<VectorComparisons>

    private fun initComparisons(size: Int): List<VectorComparisons> {
        val accuracy = (1..16).toList()
        val distances = listOf(
            0.0,
            0.1,
            0.5,
            1.0,
            1.5,
            2.0,
            2.5,
            3.0,
        )
        val vectors = listOf(
            vectorOf(
                startX = 0.0,
                startY = 0.0,
                finishX = 6.0,
                finishY = 0.0,
            ),
            vectorOf(
                startX = 0.0,
                startY = 1.0,
                finishX = 6.0,
                finishY = 0.0,
            ),
            vectorOf(
                startX = 0.0,
                startY = -1.0,
                finishX = 6.0,
                finishY = 1.0,
            ),
            vectorOf(
                startX = 1.0,
                startY = 3.0,
                finishX = 5.0,
                finishY = -3.0,
            ),
            vectorOf(
                startX = 2.0,
                startY = 3.0,
                finishX = 4.0,
                finishY = -1.0,
            ),
        )
        val targets = listOf(
            -3.0 to 3.0,
            -2.0 to 2.0,
            -1.0 to 1.0,
            0.0 to 4.0,
            1.0 to 1.0,
            4.0 to 2.0,
            8.0 to 0.0,
            5.0 to -1.0,
            3.0 to -2.0,
            4.0 to -4.0,
        )
        val result = mutableListOf<VectorComparisons>()
        for (index in 0 until size) {
            val multiplier = 1.0 + index
            distances.forEach { minDistance ->
                accuracy.forEach { points ->
                    targets.forEach { (xTarget, yTarget) ->
                        result += VectorComparisons(
                            vectors = vectors,
                            target = pointOf(
                                x = xTarget * multiplier,
                                y = yTarget * multiplier,
                            ),
                            minDistance = minDistance * multiplier,
                            points = points,
                        )
                    }
                }
            }
        }
        return result
    }

    @Setup(Level.Trial)
    fun eachTrial() {
        comparisons = initComparisons(size = size)
    }

    @Benchmark
    fun reaches(hole: Blackhole) {
        val results = mutableMapOf<Int, Boolean>()
        comparisons.forEachIndexed { index, it ->
            it.vectors.forEach { vector ->
                results[index] = vector.reaches(
                    xTarget = it.target.x,
                    yTarget = it.target.y,
                    minDistance = it.minDistance,
                    points = it.points,
                )
            }
        }
        hole.consume(results)
    }

    @Benchmark
    fun reachesPoint(hole: Blackhole) {
        val results = mutableMapOf<Int, Boolean>()
        comparisons.forEachIndexed { index, it ->
            it.vectors.forEach { vector ->
                results[index] = vector.reaches(
                    target = it.target,
                    minDistance = it.minDistance,
                    points = it.points,
                )
            }
        }
        hole.consume(results)
    }

    @Benchmark
    fun reachesIterable(hole: Blackhole) {
        val results = mutableMapOf<Int, Boolean>()
        comparisons.forEachIndexed { index, it ->
            results[index] = it.vectors.reaches(
                xTarget = it.target.x,
                yTarget = it.target.y,
                minDistance = it.minDistance,
                points = it.points,
            )
        }
        hole.consume(results)
    }

    @Benchmark
    fun reachesIterablePoint(hole: Blackhole) {
        val results = mutableMapOf<Int, Boolean>()
        comparisons.forEachIndexed { index, it ->
            results[index] = it.vectors.reaches(
                target = it.target,
                minDistance = it.minDistance,
                points = it.points,
            )
        }
        hole.consume(results)
    }
}
