package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset
import sp.kx.math.foundation.entity.geometry.Point
import sp.kx.math.foundation.entity.geometry.Vector

private data class VectorImpl(
    override val start: Point,
    override val finish: Point
) : Vector {
    override fun toString(): String {
        return "{start:$start,finish:$finish}"
    }
}

fun Point.toVector(finish: Point): Vector {
    return VectorImpl(
        start = this,
        finish = finish
    )
}

fun Point.toVector(offset: Offset): Vector {
    return toVector(finish = updated(offset))
}

fun Point.toVector(
    finish: Point,
    offset: Offset
): Vector {
    return updated(offset).toVector(finish = finish.updated(offset))
}

fun Point.toVector(
    length: Double,
    angle: Double
): Vector {
    return toVector(finish = moved(length = length, angle = angle))
}
