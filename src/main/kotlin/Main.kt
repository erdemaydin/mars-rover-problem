import domain.Command
import domain.Coordinate
import domain.Direction.Companion.findDirection
import domain.MarsRover
import domain.Plateau
import util.toIntOrThrowException

fun main() {
    val (x, y) = readLine()!!.split(' ').map(::toIntOrThrowException)
    val plateau = Plateau(Coordinate(x, y))
    val (rover1x, rover1y, rover1Direction) = readLine()!!.split(' ')
    val marsRover1 = MarsRover(
        Coordinate(toIntOrThrowException(rover1x), toIntOrThrowException(rover1y)),
        findDirection(rover1Direction)
    )

    val command1: List<Command> = readLine()!!.toList().map(Command::charToCommand).toList()

    val (rover2x, rover2y, rover2Direction) = readLine()!!.split(' ')
    val marsRover2 = MarsRover(
        Coordinate(toIntOrThrowException(rover2x), toIntOrThrowException(rover2y)),
        findDirection(rover2Direction)
    )

    val command2: List<Command> = readLine()!!.toList().map(Command::charToCommand).toList()


    marsRover1.executeCommand(command1, plateau)
    println(marsRover1)
    marsRover2.executeCommand(command2, plateau)
    println(marsRover2)
}

