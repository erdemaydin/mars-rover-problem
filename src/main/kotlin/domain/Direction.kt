package domain

interface Orientation {
    fun turnToLeft(): Direction
    fun turnToRight(): Direction
    fun moveForward(coordinate: Coordinate)
}

enum class Direction : Orientation {
    N {
        override fun turnToLeft() = W
        override fun turnToRight() = E
        override fun moveForward(coordinate: Coordinate) {
            coordinate.y += 1
        }
    },
    S {
        override fun turnToLeft() = E
        override fun turnToRight() = W
        override fun moveForward(coordinate: Coordinate) {
            coordinate.y -= 1
        }
    },
    W {
        override fun turnToLeft() = S
        override fun turnToRight() = N
        override fun moveForward(coordinate: Coordinate) {
            coordinate.x -= 1
        }
    },
    E {
        override fun turnToLeft() = N
        override fun turnToRight() = S
        override fun moveForward(coordinate: Coordinate) {
            coordinate.x += 1
        }
    };

    companion object {
        fun findDirection(direction: String): Direction = values().find { it.name == "$direction" }
            ?: throw IllegalArgumentException("Invalid direction '$direction'! Direction must be 'N', 'S', 'W' or 'E'")
    }
}
