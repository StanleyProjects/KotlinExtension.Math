package util.junit

import org.junit.Assert.assertTrue

internal fun Double.assert(expected: Double, name: String) {
    assertTrue("Expected \"$name\" is $expected, but actual is $this!", expected == this)
}

internal fun String.assert(expected: String, name: String) {
    assertTrue("Expected \"$name\" is \"$expected\", but actual is \"$this\"!", expected == this)
}
