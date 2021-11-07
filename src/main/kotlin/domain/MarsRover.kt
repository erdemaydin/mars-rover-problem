package domain

class MarsRover(var coordinate: Coordinate, var facing: Direction) {
    init {
        if (coordinate.x < 0 || coordinate.y < 0) throw IllegalArgumentException("Rover's coordinates can not be negative!")
    }

    fun executeCommand(orientations: List<Command>, plateau: Plateau) {
        orientations.forEach { command: Command ->
            command.execute(this, plateau)
        }
    }

    fun moveForward() {
        facing.moveForward(coordinate)
    }

    fun turnToRight() {
        facing = facing.turnToRight()
    }

    fun turnToLeft() {
        facing = facing.turnToLeft()
    }

    override fun toString(): String {
        return "${coordinate.x} ${coordinate.y} $facing"
    }
}

