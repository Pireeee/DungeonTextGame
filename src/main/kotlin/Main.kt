package fr

import application.DungeonService
import application.PlayerService
import entities.Monster
import entities.Player
import entities.PlayerClass
import user_interface.CommandHandler
import user_interface.displayDungeon

fun main() {
    // Game initialization
    val playerService = PlayerService()
    val dungeonService = DungeonService()
    val commandHandler = CommandHandler(playerService, dungeonService)

    val monster1 = Monster.createMonster("Goblin", 5, 2, 10, 0)
    println("Welcome ${player.name} the ${player.playerClass}! with stats: ${player.totalStrength} strength, ${player.totalDefense} defense, ${player.totalHealth} health, ${player.totalMana} mana.")

    //Start the game loop
    // Create player
    val player = playerService.createPlayer()
    val dungeon = dungeonService.generateDungeon(5)

    dungeon.setCell(0, 0, Cell.PlayerCell(player))
    dungeon.setCell(2, 2, Cell.MonsterCell(Monster("Goblin", 10, 5, 20, 0)))
    dungeon.setCell(1, 3, Cell.Treasure("Gold Coin", 100))

    // Display the dungeon map
    displayDungeon(dungeon)

    
}

