package fr.entities.room

import fr.entities.entities.Monster
import fr.entities.entities.Player
import fr.entities.*
import fr.entities.entities.stats.WarriorStats
import kotlin.random.Random

class Room(val size: Int, isRandom: Boolean) {

    private val grid: Array<Array<Cell>> = generateGrid(size, isRandom)

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

    private fun generateGrid(size: Int, isRandom: Boolean): Array<Array<Cell>> {
        val monsterCell = MonsterCell(Monster("Goblin", WarriorStats(), WarriorStats()))
        val treasureCell = TreasureCell("Gold Coin", 100)
        val doorCell = DoorCell()
        val emptyCells: Array<Array<Cell>> = Array(size) { Array(size) { EmptyCell() } }

        // Create a list of all possible coordinates
        val coordinates = mutableListOf<Pair<Int, Int>>()
        for (x in 1 until size) {
            for (y in 1 until size) {
                coordinates.add(Pair(x, y))
            }
        }

        // Shuffle the list to randomize the order with a unique seed
        if (isRandom){
            coordinates.shuffle(Random(System.nanoTime()))
        }

        // Place the special cells at the first few coordinates
        val (monsterX, monsterY) = coordinates[0]
        emptyCells[monsterX][monsterY] = monsterCell

        val (treasureX, treasureY) = coordinates[1]
        emptyCells[treasureX][treasureY] = treasureCell

        val (doorX, doorY) = coordinates[2]
        emptyCells[doorX][doorY] = doorCell

        return emptyCells
    }

    fun display() {
        // Print column headers
        print("   ")
        for (x in 0 until size) {
            print(" $x ")
        }
        println()

        for (y in 0 until size) {
            // Print row header
            print(" $y ")

            for (x in 0 until size) {
                val cell = getCell(x, y)
                val symbol = cell?.displayChar ?: " "
                print(" $symbol ")
            }
            println()
        }
        println() // Separate rooms with a blank line
    }

    fun placePlayer(player: Player, x: Int = 0, y: Int = 0) {
        if(isValidPosition(x, y)){
            setCell(x, y, PlayerCell(player))
        }
    }

    fun removePlayer(x: Int, y: Int) {
        setCell(x, y, EmptyCell())
    }

    fun movePlayer(player: Player, fromX: Int, fromY: Int, toX: Int, toY: Int) {
        removePlayer(fromX, fromY)
        placePlayer(player, toX, toY)
    }

    fun findPlayerPosition(player: Player): Pair<Int, Int> {
        for (x in 0 until size) {
            for (y in 0 until size) {
                val cell = getCell(x, y)
                if (cell is PlayerCell && cell.player == player) {
                    return Pair(x, y)
                }
            }
        }
        System.err.println("Player not found in room")
        return Pair(-1, -1)
    }

    fun isValidPosition(x: Int, y: Int): Boolean {
        return x in 0 until size && y in 0 until size && getCell(x, y) !is ObstacleCell
    }
}

