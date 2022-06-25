package sp.kx.math.foundation.entity.geometry

interface Triangle {
    enum class Vertex {
        A, B, C
    }

    val a: Point
    val b: Point
    val c: Point
}
