package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

private class EmptyVector(point: Point) : Vector {
    override val start: Point = point
    override val finish: Point = point

    override fun toString(): String {
        return "EmptyVector${toString(point = start, points = 2, locale = Locale.US)}"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Vector) return false
        return start.x == other.start.x &&
                finish.x == other.finish.x && start.y == other.start.y && finish.y == other.finish.y
    }

    override fun hashCode(): Int {
        return Objects.hash(start.x, start.y, finish.x, finish.y)
    }
}

fun Point.toVector(): Vector {
    return EmptyVector(this)
}
