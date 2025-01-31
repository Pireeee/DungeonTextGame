package tests

import fr.entities.*
import fr.entities.dungeon.*
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
        val command = MoveSouthCommand()
        val playerMoved = command.execute(player, dungeon)
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
        val command = MoveSouthCommand()
        val playerMoved = command.execute(player, dungeon)
        // Then
        assertTrue(playerMoved == MoveResult.MOVED_WITHIN_ROOM)
    }

    @Test
    fun `When player moves out of the grid, then it does not move`() {
        // Given
        val customRoom = RoomBuilder().setRandom(false).placePlayer(0, 0, player).build()
        dungeon.setRoom(customRoom, 0)
        // When
        val command = MoveNorthCommand()
        val playerMoved = command.execute(player, dungeon)
        // Then
        assertTrue(playerMoved == MoveResult.NOT_ALLOWED)
    }

    @Test
    fun `When player moves multiple times, then it reaches the expected position`() {
        // Given
        val customRoom = RoomBuilder().setRandom(false).placePlayer(0, 0, player).build()
        dungeon.setRoom(customRoom, 0)
        val directions = arrayOf(MoveSouthCommand(),MoveEastCommand(), MoveSouthCommand())
        // When
        for (i in directions) {
            i.execute(player, dungeon)
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
        val command = MoveSouthCommand()
        val playerMoved = command.execute(player, dungeon)
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
        val command = MoveSouthCommand()
        val playerMoved = command.execute(player, dungeon)
        // Then
        assertTrue(playerMoved == MoveResult.NOT_ALLOWED)
    }

    @Test
    fun `When player moves to the cell in the orientation's direction, then it moves`() {
        // Given
        val customRoom = RoomBuilder().setRandom(false).placePlayer(2, 2, player).build()
        dungeon.setRoom(customRoom, 0)
        // When
        val command = MoveForwardCommand()
        val playerMoved = command.execute(player, dungeon)
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
        val command = TurnRightCommand()
        val playerMoved = command.execute(player, dungeon)
        // Then
        assertTrue(playerMoved == MoveResult.CHANGED_DIRECTION)
    }

    @Test
    fun `When player executes a series of complex movements, then it reaches the expected position`() {
        // Given
        val customRoom = RoomBuilder().setRandom(false).placePlayer(2, 1, player).build()
        dungeon.setRoom(customRoom, 0)
        val directions = arrayOf(MoveForwardCommand(), TurnRightCommand(), MoveForwardCommand(), TurnLeftCommand(), MoveForwardCommand(), MoveForwardCommand())
        // When
        for (i in directions) {
            i.execute(player, dungeon)
        }
        // Then
        assertTrue(dungeon.roomsArray[0].getCell(1, 4) is PlayerCell)
    }
}