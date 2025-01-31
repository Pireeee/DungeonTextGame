package fr.entities.dungeon

import fr.entities.MoveResult
import fr.entities.entities.player.Player
import fr.entities.entities.player.returnPlayerInfoString

interface Command {
    fun execute(player: Player, dungeon: Dungeon): MoveResult
}

class MoveNorthCommand : Command {
    override fun execute(player: Player, dungeon: Dungeon): MoveResult {
        val currentRoom = dungeon.roomsArray[dungeon.currentRoomIndex]
        val (currentX, currentY) = currentRoom.findPlayerPosition(player)
        return dungeon.movePlayerWithinRoom(player, currentX, currentY - 1)
    }
}

class MoveSouthCommand : Command {
    override fun execute(player: Player, dungeon: Dungeon): MoveResult {
        val currentRoom = dungeon.roomsArray[dungeon.currentRoomIndex]
        val (currentX, currentY) = currentRoom.findPlayerPosition(player)

        return dungeon.movePlayerWithinRoom(player, currentX, currentY + 1)
    }
}

class MoveEastCommand : Command {
    override fun execute(player: Player, dungeon: Dungeon): MoveResult {
        val currentRoom = dungeon.roomsArray[dungeon.currentRoomIndex]
        val (currentX, currentY) = currentRoom.findPlayerPosition(player)
        return dungeon.movePlayerWithinRoom(player, currentX + 1, currentY)
    }
}

class MoveWestCommand : Command {
    override fun execute(player: Player, dungeon: Dungeon): MoveResult {
        val currentRoom = dungeon.roomsArray[dungeon.currentRoomIndex]
        val (currentX, currentY) = currentRoom.findPlayerPosition(player)
        return dungeon.movePlayerWithinRoom(player, currentX - 1, currentY)
    }
}

class TurnLeftCommand : Command {
    override fun execute(player: Player, dungeon: Dungeon): MoveResult {
        player.turnLeft()
        return MoveResult.CHANGED_DIRECTION
    }
}

class TurnRightCommand : Command {
    override fun execute(player: Player, dungeon: Dungeon): MoveResult {
        player.turnRight()
        return MoveResult.CHANGED_DIRECTION
    }
}

class MoveForwardCommand : Command {
    override fun execute(player: Player, dungeon: Dungeon): MoveResult {
        val currentRoom = dungeon.roomsArray[dungeon.currentRoomIndex]
        val (currentX, currentY) = currentRoom.findPlayerPosition(player)
        val (dx, dy) = player.moveForward()
        return dungeon.movePlayerWithinRoom(player, currentX + dx, currentY + dy)
    }
}

class QuitCommand : Command {
    override fun execute(player: Player, dungeon: Dungeon): MoveResult {
        println("Exiting game. Goodbye!")
        return MoveResult.END_OF_DUNGEON
    }
}

class InfoCommand : Command {
    override fun execute(player: Player, dungeon: Dungeon): MoveResult {
        println(returnPlayerInfoString(player))
        return MoveResult.INFO_DISPLAYED
    }
}