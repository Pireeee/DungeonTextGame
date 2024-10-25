package application

import entities.Cell
import entities.Dungeon

class DungeonService {

    fun generateDungeon(gridSize: Int): Dungeon {
        // Logique de génération de donjon
        val dungeon = Dungeon(
            width = gridSize,
            height = gridSize,
            grid = Array(gridSize) { Array(gridSize) { Cell.Empty } }
        )
        return dungeon
    }


}