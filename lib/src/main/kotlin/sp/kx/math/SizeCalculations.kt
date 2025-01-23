package sp.kx.math

/**
 * Usage:
 * ```
 * val size: Size = sizeOf(width = 3, height = 2)
 * val vector = Point.Center + pointOf(size.width, size.height)
 * assertEquals(vector.length(), size.diagonal())
 * ```
 *
 * ```
 *   ^
 *   |
 * 3 -
 *   |
 * 2 -   -   -   *
 *   |           .
 * 1 -           .
 *   |           .
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 * @return The size of the diagonal of a rectangle that has dimensions [Size.width] x [Size.height] of [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
fun Size.diagonal(): Double {
    return kotlin.math.sqrt(width * width + height * height)
}

/**
 * Usage:
 * ```
 * val size: Size = sizeOf(width = 3, height = 2)
 * val vector = Point.Center + pointOf(size.width, size.height)
 * assertEquals(vector.angle(), size.diagonalAngle())
 * ```
 *
 * ```
 *   ^
 *   |
 * 3 -
 *   |
 * 2 -   -   -   *
 *   |           .
 * 1 -           .
 *   |           .
 * 0 +---|---|---|---|--->
 *   0   1   2   3   4
 * ```
 *
 * Special cases:
 * ```
 * val size: Size = sizeOf(1, 1)
 * assertEquals(kotlin.math.PI / 4, size.diagonalAngle())
 * ```
 *
 * ```
 *   ^
 *   |
 *   -
 *   |
 * 1 -   -   *
 *   |       .
 *   -       .
 *   |       .
 * 0 +---|---|---|---|--->
 *   0       1       2
 * ```
 *
 * ```
 * val size: Size = sizeOf(-1, -1)
 * assertEquals(-(kotlin.math.PI / 4) * 3, size.diagonalAngle())
 * ```
 *
 * ```
 *   -2      -1       0
 * ---|---|---|---|---+
 *            .       |
 *            .       -
 *            .       |
 *            *   -   - -1
 *                    |
 *                    -
 *                    |
 * ```
 * @return The angle in radians between the x-axis and the diagonal of a rectangle
 * that has dimensions [Size.width] x [Size.height] of [this] receiver.
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.8.0
 */
fun Size.diagonalAngle(): Double {
    return angleOf(x = width, y = height)
}
