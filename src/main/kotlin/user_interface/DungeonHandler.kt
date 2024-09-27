package user_interface

import entities.Dungeon
import entities.Room
import application.DungeonService
import application.PlayerService
import entities.Player

class CommandHandler(
    private val playerService: PlayerService,
    private val dungeonService: DungeonService
) {
    fun handleCommand(command: String, player: Player, currentRoom: Room, dungeon: Dungeon) {
        // Logique pour traiter les commandes (se déplacer, attaquer, etc.)
    }
}

