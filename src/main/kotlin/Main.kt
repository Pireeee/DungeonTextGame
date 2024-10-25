package fr

import application.DungeonService
import application.PlayerService
import entities.Monster
import entities.Player
import entities.PlayerClass
import user_interface.CommandHandler

fun main() {
    // Game initialization
    val playerService = PlayerService()
    val dungeonService = DungeonService()
    val commandHandler = CommandHandler(playerService, dungeonService)
    val player = playerService.createPlayer()
    val monster1 = Monster.createMonster("Goblin", 5, 2, 10, 0)
    println("Welcome ${player.name} the ${player.playerClass}! with stats: ${player.totalStrength} strength, ${player.totalDefense} defense, ${player.totalHealth} health, ${player.totalMana} mana.")
}

