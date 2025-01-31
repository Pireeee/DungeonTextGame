package fr.entities.entities.player

import fr.entities.EmptyCell
import fr.entities.Grid
import fr.entities.PlayerCell
import fr.entities.TreasureCell

class PlayerMovement(private val grid: Grid) {
    fun placePlayer(player: Player, x: Int = 0, y: Int = 0) {
        if (grid.isValidPosition(x, y)) {
            if (checkTreasure(x, y)) {
                val treasure = grid.getCell(x, y) as TreasureCell
                player.pickUpTreasure(treasure.treasure)
            }
            grid.setCell(x, y, PlayerCell(player))
        }
    }

    fun removePlayer(x: Int, y: Int) {
        grid.setCell(x, y, EmptyCell())
    }

    fun movePlayer(player: Player, fromX: Int, fromY: Int, toX: Int, toY: Int) {
        removePlayer(fromX, fromY)
        placePlayer(player, toX, toY)
    }

    fun findPlayerPosition(player: Player): Pair<Int, Int> {
        for (x in 0 until grid.size) {
            for (y in 0 until grid.size) {
                val cell = grid.getCell(x, y)
                if (cell is PlayerCell && cell.player == player) {
                    return Pair(x, y)
                }
            }
        }
        System.err.println("Player not found in room")
        return Pair(-1, -1)
    }

    private fun checkTreasure(x: Int, y: Int): Boolean {
        return grid.getCell(x, y) is TreasureCell
    }
}