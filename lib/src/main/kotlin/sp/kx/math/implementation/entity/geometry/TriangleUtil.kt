package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Point
import sp.kx.math.foundation.entity.geometry.Triangle

fun Triangle.getShortest(vertex: Triangle.Vertex): Double {
    return when (vertex) {
        Triangle.Vertex.A -> getShortest(start = b, finish = c, target = a)
        Triangle.Vertex.B -> getShortest(start = a, finish = c, target = b)
        Triangle.Vertex.C -> getShortest(start = a, finish = b, target = c)
    }
}

fun Triangle.getPerpendicular(vertex: Triangle.Vertex): Point {
    return when (vertex) {
        Triangle.Vertex.A -> getPerpendicular(a = a, b = b, c = c)
        Triangle.Vertex.B -> getPerpendicular(a = b, b = a, c = c)
        Triangle.Vertex.C -> getPerpendicular(a = c, b = a, c = b)
    }
}
