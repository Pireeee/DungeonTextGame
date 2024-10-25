package fr

import application.DungeonService
import application.PlayerService
import entities.Cell
import entities.Monster
import entities.Player
import entities.PlayerClass
import user_interface.CommandHandler

fun main() {
    // Game initialization
    intro()
    val playerService = PlayerService()
    val dungeonService = DungeonService()
    val commandHandler = CommandHandler(playerService, dungeonService)

    //Start the game loop
    // Create player
    val player = playerService.createPlayer()
    val dungeon = dungeonService.generateDungeon(5)

    dungeon.rooms.get(0).setCell(0, 0, Cell.PlayerCell(player))
    dungeon.rooms.get(0).setCell(2, 2, Cell.MonsterCell(Monster("Goblin", 10, 5, 20, 0)))
    dungeon.rooms.get(0).setCell(1, 3, Cell.Treasure("Gold Coin", 100))


    // Display the dungeon map
    println("see the entire dungeon map :")
    dungeonService.displayDungeon(dungeon)
    
}

fun intro() {
    println("Hello mighty hero!")
    println("Welcome to the dungeon game.")
}