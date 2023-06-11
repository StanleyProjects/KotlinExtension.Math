package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

internal class EmptyVector(override val start: Point) : Vector {
    override val finish: Point = start

    override fun toString(): String {
        return "EmptyVector${toString(point = start, points = 2, locale = Locale.US)}"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Vector) return false
        return start.x == other.start.x &&
            start.x == other.finish.x && start.y == other.start.y && start.y == other.finish.y
    }

    override fun hashCode(): Int {
        return Objects.hash(start.x, start.y, start.x, start.y)
    }
}

fun Point.toVector(): Vector {
    return EmptyVector(this)
}
