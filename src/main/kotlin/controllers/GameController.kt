package fr.controllers

import fr.entities.MoveResult
import fr.entities.dungeon.*
import fr.entities.entities.player.Player
import fr.entities.entities.player.returnPlayerInfoString
import java.util.Scanner

class GameController(private val player: Player, private val dungeon: Dungeon) {

    private val scanner = Scanner(System.`in`)

    private val commandMap: Map<Char, Command> = mapOf(
        'N' to MoveNorthCommand(),
        'S' to MoveSouthCommand(),
        'E' to MoveEastCommand(),
        'O' to MoveWestCommand(),
        'G' to TurnLeftCommand(),
        'D' to TurnRightCommand(),
        'A' to MoveForwardCommand(),
        'Q' to QuitCommand(),
        'I' to InfoCommand()
    )

    fun startGame() {
        while (true) {
            clearTerminal()
            displayHeader()
            dungeon.displayCurrentRoom()
            println("Enter a command (N, S, E, O, G, D, A) or I for info or Q to quit: ")
            val input = scanner.next().uppercase().first()
            val command = commandMap[input]
            if (command != null) {
                val moveResult = command.execute(player, dungeon)
                if (moveResult == MoveResult.END_OF_GAME) {
                    println("Game over!")
                    break
                }
                if (moveResult == MoveResult.MOVED_WITHIN_ROOM) {
                    displayPlayerInfo(player)
                }
                if (moveResult == MoveResult.END_OF_DUNGEON) {
                    println("Congratulations! You have reached the end of the dungeon.")
                    break
                }
            } else {
                println("Invalid command")
            }
        }
    }

    private fun clearTerminal() {
        //flush terminal
        System.out.flush()
    }

    private fun displayHeader() {
        println("Dungeon Game")
        println("------------")
        // player name and stats
        println("Player: ${player.name}")
        println("HP: ${player.totalStats.health}")
        println("")
    }

    private fun displayPlayerInfo(player: Player) {
        val data = returnPlayerInfoString(player)
        println(data)
    }
}