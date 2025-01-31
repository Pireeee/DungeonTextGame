package fr.entities.entities

import fr.entities.Grid
import fr.entities.TreasureCell

class TreasureManagement(private val grid: Grid) {
    fun checkTreasure(x: Int, y: Int): Boolean {
        return grid.getCell(x, y) is TreasureCell
    }
}