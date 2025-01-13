package sp.kx.math.unsafe

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import sp.kx.math.eq

internal class NumberUnsafeTest {
    @Test
    fun eqTest() {
        val v1 = 0.12
        val v2 = 0.10
        assertNotEquals(v1, v2)
        assertEquals(v1, v2, 0.1)
        assertNotEquals(v1, v2, 0.01)
        val message = """
            v1: $v1
            v2: $v2
        """.trimIndent()
        assertTrue(v1.eq(other = v2, points = 1), message)
        assertFalse(v1.eq(other = v2, points = 2), message)
    }
}
