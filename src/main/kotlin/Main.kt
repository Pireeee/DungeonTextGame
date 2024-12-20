package fr

import fr.controllers.GameController
import fr.controllers.GameInitializer

fun main() {
    // Game initialization
    introText()
    val playerAndDungeon = GameInitializer().initialize()
    val gameController = GameController(playerAndDungeon.first, playerAndDungeon.second)
    gameController.startGame()
}

fun introText() {
    println("Hello mighty hero!")
    println("Welcome to the dungeon game.")
}

