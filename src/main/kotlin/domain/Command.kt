package domain

enum class Command {
    L {
        override fun execute(marsRover: MarsRover, plateau: Plateau) {
            marsRover.turnToLeft()
        }
    },
    R {
        override fun execute(marsRover: MarsRover, plateau: Plateau) {
            marsRover.turnToRight()
        }
    },
    M {
        override fun execute(marsRover: MarsRover, plateau: Plateau) {
            val nextCoordinate = marsRover.getNextCoordinate()
            plateau.rovers.forEach { validateRoverCoordinatesOnThePlateau(nextCoordinate, it.coordinate) }
            validateRoverMovePlateauBoundaries(nextCoordinate, plateau)
            marsRover.moveForward()
        }
    };

    abstract fun execute(marsRover: MarsRover, plateau: Plateau)

    fun validateRoverCoordinatesOnThePlateau(nextCoordinate: Coordinate, coordinateRoverOnPlateau: Coordinate) {
        if (nextCoordinate.x == coordinateRoverOnPlateau.x
            && nextCoordinate.y == coordinateRoverOnPlateau.y
        ) {
            throw IllegalArgumentException("Invalid coordinates at x:${nextCoordinate.x} y:${nextCoordinate.y}. " +
                    "Another rover on plateau coordinates at x:${coordinateRoverOnPlateau.x} y:${coordinateRoverOnPlateau.x}")
        }
    }

    fun validateRoverMovePlateauBoundaries(coordinate: Coordinate, plateau: Plateau) {
        if (coordinate.x > plateau.coordinate.x
            || coordinate.x < 0
            || coordinate.y > plateau.coordinate.y
            || coordinate.y < 0
        ) {
            throw IllegalArgumentException("Invalid coordinates at x:${coordinate.x} y:${coordinate.y}. " +
                    "Rover can not go to beyond boundaries of plateau x:${plateau.coordinate.x} y:${plateau.coordinate.y}")
        }
    }

    companion object {
        fun charToCommand(command: Char): Command = values().find { it.name == "$command" }
            ?: throw IllegalArgumentException("Invalid command $command! Command must be 'L', 'R' or 'M'")
    }

}
