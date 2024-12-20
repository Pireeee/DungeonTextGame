package tests

import fr.entities.*
import fr.entities.dungeon.Dungeon
import fr.entities.entities.*
import fr.entities.entities.player.Direction
import fr.entities.entities.player.Player
import fr.entities.entities.player.PlayerClass
import fr.entities.room.RoomBuilder
import kotlin.test.Test
import kotlin.test.assertTrue

class MovementsTests {
    val roomSize = 5
    val player = Player("link", PlayerClass.WARRIOR)
    val dungeon = Dungeon(5, roomSize, false)
    val monster = Monster("Goblin")

    @Test
    fun `When player try move to an empty cell, it move`() {
        // Given
        val customRoom = RoomBuilder().setRandom(false).placePlayer(0, 0, player).build()
        dungeon.setRoom(customRoom, 0)
        // When
        val playerMoved = dungeon.executeCommand(player, 'E')
        // Then
        assertTrue(playerMoved == MoveResult.MOVED_WITHIN_ROOM)
    }

    @Test
    fun `When player moves to monster cell, then it moves`() {
        // Given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(0, 0, player)
            .placeMonster(0, 1, monster)
            .build()
        dungeon.setRoom(customRoom, 0)
        // When
        val playerMoved = dungeon.executeCommand(player, 'S')
        // Then
        assertTrue(playerMoved == MoveResult.MOVED_WITHIN_ROOM)
    }

    @Test
    fun `When player moves out of the grid, then it does not move`() {
        // Given
        val customRoom = RoomBuilder().setRandom(false).placePlayer(0, 0, player).build()
        dungeon.setRoom(customRoom, 0)
        // When
        val playerMoved = dungeon.executeCommand(player, 'N')
        // Then
        assertTrue(playerMoved == MoveResult.NOT_ALLOWED)
    }

    @Test
    fun `When player moves multiple times, then it reaches the expected position`() {
        // Given
        val customRoom = RoomBuilder().setRandom(false).placePlayer(0, 0, player).build()
        dungeon.setRoom(customRoom, 0)
        val directions = arrayOf('S', 'E', 'S')
        // When
        for (i in directions) {
            dungeon.executeCommand(player, i)
            dungeon.displayCurrentRoom()
        }
        // Then
        assertTrue(dungeon.roomsArray[0].getCell(1, 2) is PlayerCell)
    }

    @Test
    fun `When player moves to treasure cell, then it moves`() {
        // Given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(1, 2, player)
            .placeTreasure(1, 3, Treasure("Gold coin", 10))
            .build()
        dungeon.setRoom(customRoom, 0)
        // When
        val playerMoved = dungeon.executeCommand(player, 'S')
        // Then
        assertTrue(player.inventory.size == 1 && playerMoved == MoveResult.MOVED_WITHIN_ROOM)
    }

    @Test
    fun `When player moves to obstacle cell, then it does not move`() {
        // Given
        val customRoom = RoomBuilder()
            .setRandom(false)
            .placePlayer(1, 3, player)
            .placeObstacle(1, 4)
            .build()
        dungeon.setRoom(customRoom, 0)
        // When
        val playerMoved = dungeon.executeCommand(player, 'S')
        // Then
        assertTrue(playerMoved == MoveResult.NOT_ALLOWED)
    }

    @Test
    fun `When player moves to the cell in the orientation's direction, then it moves`() {
        // Given
        val customRoom = RoomBuilder().setRandom(false).placePlayer(2, 2, player).build()
        dungeon.setRoom(customRoom, 0)
        // When
        val playerMoved = dungeon.executeCommand(player, 'A')
        // Then
        assertTrue(playerMoved == MoveResult.MOVED_WITHIN_ROOM)
    }

    @Test
    fun `When player changes orientation, then it updates direction`() {
        // Given
        player.direction = Direction.EAST
        val customRoom = RoomBuilder().setRandom(false).placePlayer(2, 2, player).build()
        dungeon.setRoom(customRoom, 0)
        // When
        val playerMoved = dungeon.executeCommand(player, 'D')
        // Then
        assertTrue(playerMoved == MoveResult.CHANGED_DIRECTION)
    }

    @Test
    fun `When player executes a series of complex movements, then it reaches the expected position`() {
        // Given
        val customRoom = RoomBuilder().setRandom(false).placePlayer(2, 1, player).build()
        dungeon.setRoom(customRoom, 0)
        val directions = arrayOf('A', 'D', 'A', 'G', 'A', 'A')
        // When
        for (i in directions) {
            dungeon.executeCommand(player, i)
        }
        // Then
        assertTrue(dungeon.roomsArray[0].getCell(1, 4) is PlayerCell)
    }
}