package sp.kx.math

private class EmptyVector(point: Point) : Vector {
    override val start: Point = point
    override val finish: Point = point
}
