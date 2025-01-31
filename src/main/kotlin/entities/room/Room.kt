import entities.room.RoomDisplay
import fr.entities.Cell
import fr.entities.Grid
import fr.entities.entities.TreasureManagement
import fr.entities.entities.player.Player
import fr.entities.entities.player.PlayerMovement

class Room(size: Int, isRandom: Boolean) {
    private val grid = Grid(size, isRandom)
    private val display = RoomDisplay(grid)
    private val playerMovement = PlayerMovement(grid)
    private val treasureManagement = TreasureManagement(grid)

    fun getCell(x: Int, y: Int): Cell? = grid.getCell(x, y)
    fun setCell(x: Int, y: Int, cell: Cell) = grid.setCell(x, y, cell)
    fun display() = display.display()
    fun placePlayer(player: Player, x: Int = 0, y: Int = 0) = playerMovement.placePlayer(player, x, y)
    fun removePlayer(x: Int, y: Int) = playerMovement.removePlayer(x, y)
    fun movePlayer(player: Player, fromX: Int, fromY: Int, toX: Int, toY: Int) = playerMovement.movePlayer(player, fromX, fromY, toX, toY)
    fun findPlayerPosition(player: Player): Pair<Int, Int> = playerMovement.findPlayerPosition(player)
    fun isValidPosition(x: Int, y: Int): Boolean = grid.isValidPosition(x, y)
    fun checkTreasure(x: Int, y: Int): Boolean = treasureManagement.checkTreasure(x, y)
}