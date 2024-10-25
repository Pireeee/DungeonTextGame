package fr

import application.PlayerService
import entities.Dungeon
import entities.Monster
import entities.Player
import entities.PlayerClass
import user_interface.CommandHandler

fun main() {
    // Game initialization
    intro()
    val playerService = PlayerService()
    val commandHandler = CommandHandler(playerService)

    //Start the game loop
    // Create player
    val player = playerService.createPlayer()
    val dungeon = Dungeon(5, 5)

    // Display the dungeon map
    println("see the entire dungeon map :")
    dungeon.display()
    
}

fun intro() {
    println("Hello mighty hero!")
    println("Welcome to the dungeon game.")
}