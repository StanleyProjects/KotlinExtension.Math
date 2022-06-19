package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Point
import sp.kx.math.foundation.entity.geometry.Vector

private class EmptyVectorImpl(
    private val point: Point
) : Vector {
    override val start: Point
        get() = point
    override val finish: Point
        get() = point
    override fun toString(): String {
        return "{point:$point}"
    }

    override fun hashCode(): Int {
        return start.hashCode() + finish.hashCode() * 13
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Vector -> start == other.start && finish == other.finish
            else -> false
        }
    }
}

private class VectorImpl(
    override val start: Point,
    override val finish: Point
) : Vector {
    override fun toString(): String {
        return "{start:$start,finish:$finish}"
    }

    override fun hashCode(): Int {
        return start.hashCode() + finish.hashCode() * 13
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Vector -> start == other.start && finish == other.finish
            else -> false
        }
    }
}

fun vectorOf(
    start: Point,
    finish: Point
): Vector {
    return VectorImpl(
        start = start,
        finish = finish
    )
}

fun emptyVectorOf(
    point: Point
): Vector {
    return EmptyVectorImpl(
        point = point
    )
}

fun vectorOf(
    start: Point,
    length: Double,
    direction: Double
): Vector {
    val finish = pointOf(
        x = start.x + length * kotlin.math.cos(direction),
        y = start.y + length * kotlin.math.sin(direction),
    )
    return VectorImpl(
        start = start,
        finish = finish
    )
}
