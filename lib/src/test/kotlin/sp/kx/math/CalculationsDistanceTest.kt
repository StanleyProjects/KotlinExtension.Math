package sp.kx.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CalculationsDistanceTest {
    @Test
    fun distanceOfTest() {
        val targets = listOf(
            pointOf(x = 1, y = 3),
            pointOf(x = 5, y = 3),
            pointOf(x = 3, y = 1),
            pointOf(x = 3, y = 5),
        )
        check(targets.size == 4)
        check(targets.toSet().size == targets.size)
        targets.forEach { a ->
            val actual = distanceOf(
                aX = a.x,
                aY = a.y,
                bX = 3.0,
                bY = 3.0,
            )
            Assertions.assertEquals(2.0, actual) {
                "a: $a"
            }
        }
    }
}
