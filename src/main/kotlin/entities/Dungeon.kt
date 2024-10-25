package entities

data class Dungeon(
    val width: Int,
    val height: Int,
    val grid: Array<Array<Cell>>
){
    init {
        require(width > 0 && height > 0) { "Dungeon dimensions must be positive" }
    }

    fun getCell(x: Int, y:Int): Cell? {
        return if (x in 0 until width && y in 0 until height) {
            grid[x][y]
        } else {
            null
        }
    }
    fun setCell(x: Int, y: Int, cell: Cell) {
        if (x in 0 until width && y in 0 until height) {
            grid[x][y] = cell
        }
    }
}

sealed class Cell {
    object Empty : Cell()
    data class MonsterCell(val monster: Monster) : Cell()
    data class Treasure(val description: String, val value: Int) : Cell()
}