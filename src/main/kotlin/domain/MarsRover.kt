package domain

class MarsRover(var coordinate: Coordinate, var facing: Direction) {
    init {
        if (coordinate.x < 0 || coordinate.y < 0)
            throw IllegalArgumentException("Rover's coordinates must be greater than -1!")
    }

    fun executeCommand(orientations: List<Command>, plateau: Plateau) =
        orientations.forEach { it.execute(this, plateau) }

    fun moveForward() {
        facing.moveForward(coordinate)
    }

    fun turnToRight() {
        facing = facing.turnToRight()
    }

    fun turnToLeft() {
        facing = facing.turnToLeft()
    }

    fun getNextCoordinate(): Coordinate {
        var nextCoordinate = Coordinate(coordinate.x, coordinate.y)
        facing.moveForward(nextCoordinate)
        return nextCoordinate
    }

    override fun toString() = "coordinate x: ${coordinate.x} coordinate y: ${coordinate.y} facing : $facing"
}

