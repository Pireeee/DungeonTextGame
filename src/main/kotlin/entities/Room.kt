package entities

import fr.entities.*
import kotlin.random.Random

class Room(val size: Int) {

    private val grid: Array<Array<Cell>> = generateGrid(size)

    fun getCell(x: Int, y: Int): Cell? {
        return if (x in 0 until size && y in 0 until size) {
            grid[x][y]
        } else {
            null
        }
    }

    fun setCell(x: Int, y: Int, cell: Cell) {
        if (x in 0 until size && y in 0 until size) {
            grid[x][y] = cell
        }
    }

    fun generateGrid(size: Int): Array<Array<Cell>> {
        val monsterCell = MonsterCell(Monster("Goblin", 10, 5, 20, 0))
        val treasureCell = Treasure("Gold Coin", 100)
        val doorCell = DoorCell()
        val emptyCells:Array<Array<Cell>> = Array(size) { Array(size) { EmptyCell() } }

        // Create a list of all possible coordinates
        val coordinates = mutableListOf<Pair<Int, Int>>()
        for (x in 0 until size) {
            for (y in 0 until size) {
                coordinates.add(Pair(x, y))
            }
        }

        // Shuffle the list to randomize the order
        coordinates.shuffle(Random(System.currentTimeMillis()))

        // Place the special cells at the first few coordinates
        val (monsterX, monsterY) = coordinates[0]
        emptyCells[monsterX][monsterY] = monsterCell

        val (treasureX, treasureY) = coordinates[1]
        emptyCells[treasureX][treasureY] = treasureCell

        val (doorX, doorY) = coordinates[2]
        emptyCells[doorX][doorY] = doorCell

        return emptyCells
    }

}

