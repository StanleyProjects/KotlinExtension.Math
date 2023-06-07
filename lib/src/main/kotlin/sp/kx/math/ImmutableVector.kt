package sp.kx.math

import sp.kx.math.unsafe.toString
import java.util.Locale
import java.util.Objects

internal class ImmutableVector(
    override val start: Point,
    override val finish: Point,
) : Vector {
    override fun toString(): String {
        return toString(vector = this, points = 2, locale = Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Vector) return false
        return start.x == other.start.x && finish.x == other.finish.x && start.y == other.start.y && finish.y == other.finish.y
    }

    override fun hashCode(): Int {
        return Objects.hash(start.x, start.y, finish.x, finish.y)
    }
}

fun vectorOf(
    startX: Double,
    startY: Double,
    finishX: Double,
    finishY: Double,
): Vector {
    return ImmutableVector(
        start = pointOf(x = startX, y = startY),
        finish = pointOf(x = finishX, y = finishY),
    )
}

fun vectorOf(
    startX: Double,
    startY: Double,
    finish: Point,
): Vector {
    return ImmutableVector(
        start = pointOf(x = startX, y = startY),
        finish = finish,
    )
}

operator fun Point.plus(finish: Point): Vector {
    return ImmutableVector(
        start = this,
        finish = finish,
    )
}

fun Point.toVector(
    finishX: Double,
    finishY: Double,
): Vector {
    return ImmutableVector(
        start = this,
        finish = pointOf(x = finishX, y = finishY),
    )
}
