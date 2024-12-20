package fr.controllers

import fr.entities.dungeon.Commands
import fr.entities.dungeon.Dungeon
import fr.entities.entities.Player
import fr.entities.entities.returnPlayerInfoString
import java.util.Scanner

class GameController(private val player: Player, private val dungeon: Dungeon) {

    private val scanner = Scanner(System.`in`)

    fun startGame() {
    while (true) {
        clearTerminal()
        displayHeader()
        dungeon.displayCurrentRoom()
        println("Enter a command (N, S, E, O, G, D, A) or I for info or Q to quit: ")
        val input = scanner.next().uppercase().first()
        val command = try {
            Commands.fromChar(input)
        } catch (e: IllegalArgumentException) {
            println("Invalid command")
            continue
        }
        when (command) {
            Commands.QUIT -> {
                println("Exiting game. Goodbye!")
                break
            }/*
            Commands.SAVE -> saveGame()
            Commands.LOAD -> loadGame()*/
            Commands.INFOS -> displayPlayerInfo(player)
            else -> {
                val moveResult = dungeon.executeCommand(player, command)
                if (moveResult == fr.entities.MoveResult.END_OF_DUNGEON) {
                    println("Congratulations! You have reached the end of the dungeon.")
                    break
                }
            }
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

    private fun displayPlayerInfo(player:Player) {
        val data = returnPlayerInfoString(player)
        println(data)
    }

}