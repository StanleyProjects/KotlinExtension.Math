package util.junit

import org.junit.Assert.assertTrue

fun Double.assert(expected: Double, name: String) {
    assertTrue("Expected \"$name\" is $expected, but actual is $this!", expected == this)
}

fun String.assert(expected: String, name: String) {
    assertTrue("Expected \"$name\" is \"$expected\", but actual is \"$this\"!", expected == this)
}
