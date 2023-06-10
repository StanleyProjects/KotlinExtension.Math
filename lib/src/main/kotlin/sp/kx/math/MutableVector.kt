package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

/**
 * A mutable implementation of the [Vector] type.
 *
 * Usage:
 * ```
 * val vector = MutableVector(
 *     start = MutablePoint(x = 1.2, y = 3.4),
 *     finish = MutablePoint(x = 5.6, y = 7.8),
 * )
 * vector.start.x = 2.0
 * vector.finish.y = 3.0
 * ```
 * @property start The [MutablePoint] from which the beginning of the [MutableVector] can be counted.
 * @property finish The [MutablePoint] up to which the direction of the [MutableVector] can be computed.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.0
 */
class MutableVector(
    override val start: MutablePoint,
    override val finish: MutablePoint,
) : Vector {
    override fun toString(): String {
        return toString(vector = this, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Vector) return false
        return start.x == other.start.x &&
            finish.x == other.finish.x && start.y == other.start.y && finish.y == other.finish.y
    }

    override fun hashCode(): Int {
        return Objects.hash(start.x, start.y, finish.x, finish.y)
    }

    fun set(
        start: Point,
        finish: Point,
    ) {
        this.start.set(start)
        this.finish.set(finish)
    }

    fun set(other: Vector) {
        this.start.set(other.start)
        this.finish.set(other.finish)
    }

    fun swap() {
        val x = start.x
        val y = start.y
        start.set(finish)
        finish.set(x = x, y = y)
    }
}
