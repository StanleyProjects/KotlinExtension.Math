package sp.kx.math.measure

import kotlin.time.Duration

fun Interval<Duration>.diff(): Duration {
    return b - a
}
