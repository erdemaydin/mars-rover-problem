package domain

data class Plateau(var x: Int = 0, var y: Int = 0) {
    init {
        if (x < 0 || y < 0) throw IllegalArgumentException("domain.Plateau's dimension values can not be negative!")
    }
}
