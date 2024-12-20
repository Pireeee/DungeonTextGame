package fr.controllers

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
            val command = scanner.next().first().uppercaseChar()
            if (command == 'Q') {
                println("Exiting game. Goodbye!")
                break
            }
            if (command in listOf('N', 'S', 'E', 'O', 'G', 'D', 'A')) {
                dungeon.executeCommand(player, command)
            } else if (command == 'I') {
                displayPlayerInfo(player)
            } else {
                println("Invalid command")
            }
        }
    }

    fun clearTerminal() {
        //flush terminal
        System.out.flush()
    }
    fun displayHeader() {
        println("Dungeon Game")
        println("------------")
        // player name and stats
        println("Player: ${player.name}")
        println("HP: ${player.totalStats.health}")
        println("")
    }

    fun displayPlayerInfo(player:Player) {
        val data = returnPlayerInfoString(player)
        println(data)
    }

}