package sp.kx.math.measure

import sp.kx.math.unsafe.eq
import java.util.concurrent.TimeUnit

fun Speed.isEmpty(points: Int, timeUnit: TimeUnit = TimeUnit.NANOSECONDS): Boolean {
    require(points > 0)
    return eq(it = per(timeUnit), other = 0.0, points = points)
}

fun Speed.isEmpty(): Boolean {
    return per(TimeUnit.NANOSECONDS) == 0.0
}
