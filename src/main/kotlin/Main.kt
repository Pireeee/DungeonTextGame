package fr

import fr.services.PlayerService
import fr.entities.dungeon.Dungeon

fun main() {
    // Game initialization
    intro()
    val playerService = PlayerService()

    // Create player
    val player = playerService.createPlayer()
    val dungeon = Dungeon(5, 5, true)

    // Place the player in the first room at (0,0)
    dungeon.placePlayer(player, 0)

    dungeon.displayCurrentRoom()

    // Move the player within the first room
    println("Moving player within the first room to (2,2)...")
    dungeon.movePlayerWithinRoom(player, 0, 0, 0, 2, 2)

    dungeon.displayCurrentRoom()
}

fun intro() {
    println("Hello mighty hero!")
    println("Welcome to the dungeon game.")
}