package fr

import fr.controllers.GameController
import fr.entities.dungeon.Dungeon
import fr.services.PlayerService
import fr.entities.dungeon.DungeonBuilder
import fr.entities.entities.Player

fun main() {
    // Game initialization
    introText()
    val (player, dungeon) = initPlayerAndDungeon()
    val gameController = GameController(player, dungeon)
    gameController.startGame()
}

fun introText() {
    println("Hello mighty hero!")
    println("Welcome to the dungeon game.")
}

fun initPlayerAndDungeon(): Pair<Player, Dungeon> {
    val playerService = PlayerService()
    val player = playerService.createPlayer()
    val dungeon = DungeonBuilder().setRooms(5).setRoomSize(5).build()
    dungeon.placePlayer(player, 0)
    return Pair(player, dungeon)
}