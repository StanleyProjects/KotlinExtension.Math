package sp.kx.math.unsafe

import sp.kx.math.measure.Speed
import java.util.Locale
import java.util.concurrent.TimeUnit

internal fun toString(speed: Speed, timeUnit: TimeUnit, points: Int, locale: Locale): String {
    return "{speed: ${toString(number = speed.per(timeUnit), points, locale)} per ${timeUnit.name}}"
}
