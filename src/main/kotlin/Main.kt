package fr

import application.DungeonService
import application.PlayerService
import entities.Player
import entities.PlayerClass
import user_interface.CommandHandler

fun main() {
    // Game initialization
    val playerService = PlayerService()
    val dungeonService = DungeonService()
    val commandHandler = CommandHandler(playerService, dungeonService)
    val player = playerService.createPlayer()


    println("Hello World!")
}

