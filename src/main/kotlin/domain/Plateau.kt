package domain

data class Plateau(val coordinate: Coordinate) {
    init {
        if (coordinate.x < 0 || coordinate.y < 0) throw IllegalArgumentException("Plateau's dimension values must be positive number!")
    }
}
