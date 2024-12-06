package fr

import fr.controllers.PlayerController
import fr.entities.dungeon.Dungeon
import fr.services.PlayerService
import fr.entities.dungeon.DungeonBuilder
import fr.entities.entities.Player
import java.awt.Desktop
import java.io.File
import java.io.IOException
import java.util.Scanner

fun main() {
    // Game initialization
    introText()
    val (player, dungeon) = InitPlayerAndDungeon()
    val playerController = PlayerController(player, dungeon)
    playerController.startGame()
}

fun introText() {
    println("Hello mighty hero!")
    println("Welcome to the dungeon game.")
}

fun InitPlayerAndDungeon(): Pair<Player, Dungeon> {
    val playerService = PlayerService()
    val player = playerService.createPlayer()
    val dungeon = DungeonBuilder().setRooms(5).setRoomSize(5).build()
    dungeon.placePlayer(player, 0)
    return Pair(player, dungeon)
}