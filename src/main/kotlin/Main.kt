package fr

import application.DungeonService
import application.PlayerService
import entities.Cell
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

    //Start the game loop
    // Create player
    val player = playerService.createPlayer()
    val dungeon = dungeonService.generateDungeon(5)

    dungeon.Rooms.get(0).setCell(0, 0, Cell.PlayerCell(player))
    dungeon.Rooms.get(0).setCell(2, 2, Cell.MonsterCell(Monster("Goblin", 10, 5, 20, 0)))
    dungeon.Rooms.get(0).setCell(1, 3, Cell.Treasure("Gold Coin", 100))

    // Display the dungeon map
    displayDungeon(dungeon)
    
}

