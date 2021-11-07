import domain.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class MarsRoverTest {

    private val plateau: Plateau = Plateau(Coordinate(5, 5))

    @Test
    fun `mars rover execute commands initial position at coordinate x=1 and y=2 and facing to N should be final position x=1, y=3 and facing to N`() {
        val coordinate1 = Coordinate(1, 2)
        val command: List<Command> = listOf(Command.L, Command.M, Command.L, Command.M,
            Command.L, Command.M, Command.L, Command.M, Command.M)

        val marsRover = MarsRover(coordinate1, Direction.N)
        marsRover.executeCommand(command, plateau)
        println("$marsRover")
        assertEquals(1, marsRover.coordinate.x)
        assertEquals(3, marsRover.coordinate.y)
        assertEquals(Direction.N, marsRover.facing)
    }

    @Test
    fun `mars rover execute commands initial position at coordinate x=3 and y=3 and facing to E should be final position x=5, y=1 and facing to E`() {
        val coordinate = Coordinate(3, 3)
        val command: List<Command> = listOf(Command.M, Command.M, Command.R, Command.M,
            Command.M, Command.R, Command.M, Command.R, Command.R, Command.M)
        val marsRover = MarsRover(coordinate, Direction.E)
        marsRover.executeCommand(command, plateau)
        println("$marsRover")

        assertEquals(5, marsRover.coordinate.x)
        assertEquals(1, marsRover.coordinate.y)
        assertEquals(Direction.E, marsRover.facing)
    }


}