package domain

data class Plateau(val coordinate: Coordinate, var rovers: List<MarsRover>) {
    init {
        if (coordinate.x < 0 || coordinate.y < 0) throw IllegalArgumentException("Plateau's dimension values must be greater than -1!")
    }
}
