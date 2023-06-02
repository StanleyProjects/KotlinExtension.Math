package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Offset
import sp.kx.math.foundation.entity.geometry.Point
import sp.kx.math.foundation.entity.geometry.Vector

private data class VectorImpl(
    override val start: Point,
    override val finish: Point,
) : Vector {
    override fun toString(): String {
        return "{start:$start,finish:$finish}"
    }
}

/**
 * @return An instance of [Vector] built from the
 * [this] [Point] receiver as [Vector.start] and [finish] as [Vector.finish].
 * ```
 * val start = pointOf(1, 2)
 * val finish = pointOf(3, 4)
 * val vector = start.toVector(finish)
 * assertEquals(vector.start, start)
 * assertEquals(vector.finish, finish)
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
fun Point.toVector(finish: Point): Vector {
    return VectorImpl(
        start = this,
        finish = finish,
    )
}

/**
 * @return An instance of [Vector] for which
 * [Vector.start] is [this] [Point] receiver and
 * [Vector.finish] is [this] [Point] receiver modified by the [offset].
 * ```
 * val start = pointOf(1, 2)
 * val offset = offsetOf(3.0, 4.0)
 * val vector = start.toVector(offset)
 * assertEquals(vector.start, start)
 * assertEquals(vector.finish, start.updated(offset))
 * ```
 * @see [Point.updated]
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
fun Point.toVector(offset: Offset): Vector {
    return toVector(finish = updated(offset))
}

/**
 * @return An instance of [Vector] for which
 * [Vector.start] is [this] [Point] receiver modified by the [offset] and
 * [Vector.finish] is [finish] modified by the [offset].
 * ```
 * val start = pointOf(1, 2)
 * val finish = pointOf(3, 4)
 * val offset = offsetOf(5.0, 6.0)
 * val vector = start.toVector(finish, offset)
 * assertEquals(vector.start, start.updated(offset))
 * assertEquals(vector.finish, finish.updated(offset))
 * ```
 * @see [Point.updated]
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
fun Point.toVector(
    finish: Point,
    offset: Offset,
): Vector {
    return updated(offset).toVector(finish = finish.updated(offset))
}

/**
 * @return An instance of [Vector] for which
 * [Vector.start] is [this] [Point] receiver and
 * [Vector.finish] is [this] [Point] receiver [moved] [Point.moved] by the [length] and [angle].
 * ```
 * val start = pointOf(1, 2)
 * val length = 3.0
 * val angle = 4.0
 * val vector = start.toVector(length = length, angle = angle)
 * assertEquals(vector.start, start)
 * assertEquals(vector.finish, start.moved(length = length, angle = angle))
 * ```
 * @see [Point.moved]
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
fun Point.toVector(
    length: Double,
    angle: Double,
): Vector {
    return toVector(finish = moved(length = length, angle = angle))
}
