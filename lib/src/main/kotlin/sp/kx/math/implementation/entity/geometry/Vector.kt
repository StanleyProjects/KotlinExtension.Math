package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset
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
        return "EmptyVector{$point}"
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

fun vectorOf(
    start: Point,
    finish: Point,
    offset: Offset
): Vector {
    return VectorImpl(
        start = start.updated(offset),
        finish = finish.updated(offset)
    )
}

fun Point.toEmptyVector(): Vector {
    return EmptyVectorImpl(point = this)
}

fun Point.vectorTo(
    length: Double,
    direction: Double
): Vector {
    return VectorImpl(
        start = this,
        finish = moved(length = length, direction = direction)
    )
}

fun Point.vectorTo(offset: Offset): Vector {
    return vectorOf(
        start = this,
        finish = updated(offset)
    )
}
