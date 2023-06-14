package sp.kx.math.measure

import java.util.concurrent.TimeUnit
import kotlin.time.Duration

interface Speed {
    fun per(timeUnit: TimeUnit): Double
    fun length(duration: Duration): Double
}
