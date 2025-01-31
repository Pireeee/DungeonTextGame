package entities.room;

import fr.entities.Grid

class RoomDisplay(private val grid: Grid) {
    fun display() {
        print("   ")
        for (x in 0 until grid.size) {
            print(" $x ")
        }
        println()

        for (y in 0 until grid.size) {
            print(" $y ")
            for (x in 0 until grid.size) {
                val cell = grid.getCell(x, y)
                val symbol = cell?.displayChar ?: " "
                print(" $symbol ")
            }
            println()
        }
        println()
    }
}