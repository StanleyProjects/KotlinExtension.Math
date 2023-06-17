package sp.kx.math.measure

import java.util.concurrent.TimeUnit
import kotlin.time.Duration

/**
 * Type for convenient conversion of values relative to speed. Special case of type [Measure].
 *
 * Usage:
 * ```
 * val speed: Speed = ...
 * assertEquals(60.0, speed.per(TimeUnit.HOURS))
 * assertEquals(120.0, speed.length(2.hours))
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.5.0
 */
interface Speed {
    /**
     * @return Speed value in [TimeUnit].
     */
    fun per(timeUnit: TimeUnit): Double

    /**
     * Calculates the distance given the elapsed time.
     */
    fun length(duration: Duration): Double

    companion object {
        /**
         * A special case of a [Speed] with zero magnitude.
         *
         * Usage:
         * ```
         * assertEquals(0.0, Speed.Zero.per(TimeUnit.HOURS))
         * assertEquals(0.0, Speed.Zero.length(2.hours))
         * ```
         * @since 0.5.0
         */
        val Zero: Speed = ZeroSpeed
    }
}
