package user_interface

import entities.Dungeon
import application.PlayerService
import entities.Player

class CommandHandler(
    private val playerService: PlayerService,
) {
    fun handleCommand(command: String, player: Player, dungeon: Dungeon) {
        when (command) {
            "move" -> {
                println("Enter the room index to move to:")
                val newRoomIndex = readLine()?.toIntOrNull()
                if (newRoomIndex != null) {
                    dungeon.placePlayer(player, newRoomIndex)
                } else {
                    println("Invalid room index")
                }
            }
            // Other commands (attack, etc.)
        }
    }
}