import domain.*
import util.readConsoleLine
import util.toIntOrThrowException

fun main() {
    var commandLine: String = readConsoleLine("Please enter two value for domain.Plateau dimensions! For example : 5 5")
    val (x, y) = commandLine.split(' ')
    val plateau = Plateau(toIntOrThrowException(x), toIntOrThrowException(y))
    commandLine = readConsoleLine("Please enter three value for Rover coordinate and facing direction! For example: 1 2 N")
    val (rover1x, rover1y, rover1Direction) = commandLine.split(' ')
    val marsRover1 = MarsRover(
        Coordinate(toIntOrThrowException(rover1x), toIntOrThrowException(rover1y)),
        Direction.findDirection(rover1Direction)
    )

    commandLine = readConsoleLine("Please enter command for domain.MarsRover! For example: LMLMLMLMM")
    val command1: List<Command> = commandLine.toList().map(Command::charToCommand).toList()

    commandLine = readConsoleLine("Please enter three value for Rover coordinate and facing direction! For example: 1 2 N")
    val (rover2x, rover2y, rover2Direction) = commandLine.split(' ')
    val marsRover2 = MarsRover(
        Coordinate(toIntOrThrowException(rover2x), toIntOrThrowException(rover2x)),
        Direction.findDirection(rover2Direction)
    )

    commandLine = readConsoleLine("Please enter command for domain.MarsRover! For example: LMLMLMLMM")
    val command2: List<Command> = commandLine.toList().map(Command::charToCommand).toList()


    marsRover1.executeCommand(command1, plateau)
    println(marsRover1)
    marsRover2.executeCommand(command2, plateau)
    println(marsRover2)
}

