package tests
import fr.entities.*
import fr.entities.dungeon.Dungeon
import fr.entities.entities.*
import fr.entities.room.RoomBuilder
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test

class MovementsTests{
    //Déplacement vers une case vide
    val roomSize = 5
    val player = Player("link", PlayerClass.WARRIOR)
    val dungeon = Dungeon(5, roomSize,false)
    val monster = Monster("Goblin")

    @Test
    fun `When player try move to an empty cell, it move`() {
        //given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(0,0, player)
            .build()
        dungeon.setRoom(customRoom, 0)
        //when
        val playerMoved = dungeon.executeCommand(player, 'E')
        //then
        assertTrue(playerMoved)
    }
    //Déplacement vers une case contenant un monstre
    @Test
    fun `When player moves to monster cell, then it moves`() {
        //given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(0,0, player)
            .placeMonster(0,1, monster)
            .build()
        dungeon.setRoom(customRoom, 0)
        //when
        val playerMoved = dungeon.executeCommand(player, 'S')
        //then
        assertTrue(playerMoved)
    }
    //Tentative de déplacement hors de la grille
    @Test
    fun `When player moves out of the grid, then it does not move`() {
        //given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(0,0, player)
            .build()
        dungeon.setRoom(customRoom, 0)
        //when
        val playerMoved = dungeon.executeCommand(player, 'N')
        //then
        assertTrue(!playerMoved)
    }
    //Tentative de déplacement multiple
    @Test
    fun `When player moves multiple times, then it reaches the expected position`() {
        //given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(0,0, player)
            .build()
        dungeon.setRoom(customRoom, 0)
        dungeon.displayCurrentRoom()
        val directions = arrayOf('S', 'E', 'S')
        //when

        for (i in directions) {
            dungeon.executeCommand(player, i)
            dungeon.displayCurrentRoom()
        }
        //then
        assertTrue(dungeon.rooms[0].getCell(1, 2) is PlayerCell)
    }
    //Rencontre d'un trésor lors du déplacement
    @Test
    fun `When player moves to treasure cell, then it moves`() {
        //given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(1,2, player)
            .placeTreasure(1, 3, Treasure("Gold coin",10))
            .build()
        dungeon.setRoom(customRoom, 0)
        dungeon.displayCurrentRoom()
        //when
        val playerMoved = dungeon.executeCommand(player, 'S')
        //then
        assertTrue(dungeon.rooms[0].getCell(1, 3) is PlayerCell && playerMoved)

    }
    //Déplacement bloqué par un obstacle
    @Test
    fun `When player moves to obstacle cell, then it does not move`() {
        //given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(1,3, player)
            .placeObstacle(1,4)
            .build()
        dungeon.setRoom(customRoom, 0)
        dungeon.displayCurrentRoom()
        //when
        val playerMoved = dungeon.executeCommand(player, 'S')
        //then
        assertFalse(playerMoved)
    }
    //Rotation et orientation du personnage
    @Test
    fun `When player moves to the cell in the orientation's direction, then it moves`() {
        //given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(2,2, player)
            .build()
        dungeon.setRoom(customRoom, 0)
        //when
        val playerMoved = dungeon.executeCommand(player, 'G')
        //then
        assertTrue(playerMoved && player.direction == Direction.EAST)
    }
    // Déplacement avec orientation
    @Test
    fun `When player changes orientation, then it updates direction`() {
        //given
        player.direction = Direction.EAST
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(2,2, player)
            .build()
        dungeon.setRoom(customRoom, 0)
        //when
        val playerMoved = dungeon.executeCommand(player, 'A')
        //then
        assertTrue(playerMoved && dungeon.rooms[0].getCell(3, 2) is PlayerCell)
    }
    // Série de commandes complexes
    @Test
    fun `When player executes a series of complex movements, then it reaches the expected position`() {
        //given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(2,1, player)
            .build()
        dungeon.setRoom(customRoom, 0)
        val directions = arrayOf('A', 'D', 'A', 'G', 'A', 'A')
        //when
        for (i in directions) {
            dungeon.executeCommand(player, i)
            dungeon.displayCurrentRoom()
        }
        //then
        assertTrue(dungeon.rooms[0].getCell(1, 4) is PlayerCell)
    }
}