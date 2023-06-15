package sp.kx.math.unsafe

import sp.kx.math.measure.Interval
import java.lang.StringBuilder
import java.util.Locale
import kotlin.time.Duration
import kotlin.time.DurationUnit

internal fun toString(interval: Interval<Duration>, durationUnit: DurationUnit, points: Int, locale: Locale): String {
    val postfix = when (durationUnit) {
        DurationUnit.NANOSECONDS -> "ns"
        DurationUnit.MICROSECONDS -> "mc"
        DurationUnit.MILLISECONDS -> "ms"
        DurationUnit.SECONDS -> "s"
        DurationUnit.MINUTES -> "m"
        DurationUnit.HOURS -> "h"
        DurationUnit.DAYS -> "d"
    }
    return StringBuilder("{")
        .append(toString(number = interval.a.toDouble(durationUnit), points, locale))
        .append(postfix)
        .append("..")
        .append(toString(number = interval.b.toDouble(durationUnit), points, locale))
        .append(postfix)
        .append("}")
        .toString()
}
