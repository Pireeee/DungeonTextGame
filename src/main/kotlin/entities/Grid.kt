package fr.entities

import fr.entities.entities.Monster
import fr.entities.entities.Treasure
import fr.entities.entities.stats.WarriorStats
import kotlin.random.Random

class Grid(val size: Int, isRandom: Boolean) {
    private val grid: Array<Array<Cell>> = generateGrid(size, isRandom)

    private fun generateGrid(size: Int, isRandom: Boolean): Array<Array<Cell>> {
        val monsterCell = MonsterCell(Monster("Goblin", WarriorStats(), WarriorStats()))
        val treasureCell = TreasureCell(Treasure(name = "Gold", value = 100))
        val doorCell = DoorCell()
        val emptyCells: Array<Array<Cell>> = Array(size) { Array(size) { EmptyCell() } }

        val coordinates = mutableListOf<Pair<Int, Int>>()
        for (x in 1 until size) {
            for (y in 1 until size) {
                coordinates.add(Pair(x, y))
            }
        }

        if (isRandom) {
            coordinates.shuffle(Random(System.nanoTime()))
        }

        val (monsterX, monsterY) = coordinates[0]
        emptyCells[monsterX][monsterY] = monsterCell

        val (treasureX, treasureY) = coordinates[1]
        emptyCells[treasureX][treasureY] = treasureCell

        val (doorX, doorY) = coordinates[2]
        emptyCells[doorX][doorY] = doorCell

        return emptyCells
    }

    fun getCell(x: Int, y: Int): Cell? {
        if (x in 0 until size && y in 0 until size) {
            return grid[x][y]
        }
        return null
    }

    fun setCell(x: Int, y: Int, cell: Cell) {
        if (x in 0 until size && y in 0 until size) {
            grid[x][y] = cell
        }
    }

    fun isValidPosition(x: Int, y: Int): Boolean {
        return x in 0 until size && y in 0 until size && getCell(x, y) !is ObstacleCell
    }
}