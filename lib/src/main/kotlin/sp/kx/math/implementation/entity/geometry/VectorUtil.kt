package sp.kx.math.implementation.entity.geometry

import sp.kx.math.foundation.entity.geometry.Vector

fun Vector.isEmpty(epsilon: Double): Boolean {
    return start.isSame(finish, epsilon = epsilon)
}
