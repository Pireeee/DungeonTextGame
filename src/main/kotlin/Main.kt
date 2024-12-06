package fr

import fr.services.PlayerService
import fr.entities.dungeon.DungeonBuilder

fun main() {
    // Game initialization
    intro()
    val playerService = PlayerService()

    // Create player
    val player = playerService.createPlayer()
    val dungeon = DungeonBuilder().setRooms(5).setRoomSize(5).build()

    // Place the player in the first room at (0,0)
    dungeon.placePlayer(player, 0)

    dungeon.displayCurrentRoom()

    val commands= listOf('S', 'N', 'E', 'O', 'G', 'D','A')
    for (command in commands) {
        println("Executing command $command")
        dungeon.executeCommand(player, command)
        dungeon.displayCurrentRoom()
    }
}

fun intro() {
    println("Hello mighty hero!")
    println("Welcome to the dungeon game.")
}