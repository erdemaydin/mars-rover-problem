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
            marsRover.moveForward()
            validateMove(marsRover, plateau)
        }
    };

    abstract fun execute(marsRover: MarsRover, plateau: Plateau)

    protected fun validateMove(marsRover: MarsRover, plateau: Plateau) {
        if (marsRover.coordinate.x > plateau.x
            || marsRover.coordinate.x < 0
            || marsRover.coordinate.y > plateau.y
            || marsRover.coordinate.y < 0
        ) {
            throw IllegalArgumentException("Invalid coordinates at x:${marsRover.coordinate.x} y:${marsRover.coordinate.y}. " +
                    "Rover can not go to beyond boundaries of plateau x:${plateau.x} y:${plateau.y}")
        }
    }

    companion object {
        fun charToCommand(command: Char): Command = values().find { it.name == "$command" }
            ?: throw IllegalArgumentException("Invalid command $command! domain.Command must be 'L', 'R' or 'M'")
    }
}