package application

import entities.*

class PlayerService {


    fun movePlayer(direction: String, dungeon: Dungeon, currentRoom: Room): Room {
        // Logique de déplacement
        return currentRoom;
    }

    fun attack(monster: Monster, player: Player) {
        // Logique d'attaque
    }

    fun createPlayer(): Player {
        intro()
        val name = nameSelect()
        val playerClass = classSelect()
        val player = Player(name, playerClass, 10, 5, 100, 10)
        println("Welcome ${player.name} the ${player.playerClass}! with stats: ${player.totalStrength} strength, ${player.totalDefense} defense, ${player.totalHealth} health, ${player.totalMana} mana.")
        return player
    }
}

fun classSelect(): PlayerClass {
    println("Please choose your class: (warrior, mage, rogue)")
    val validClasses = setOf("warrior", "mage", "rogue")
    var classInput: String?

    do {
        classInput = readLine()
        if (classInput !in validClasses) {
            println("$classInput ? Please choose your class between: (warrior, mage, rogue)")
        }
    } while (classInput !in validClasses)
    val playerClass = when (classInput) {
        "warrior" -> PlayerClass.WARRIOR
        "mage" -> PlayerClass.MAGE
        "rogue" -> PlayerClass.ROGUE
        else -> PlayerClass.WARRIOR // This case will never be reached
    }
    return playerClass
}
fun nameSelect(): String {
    println("Please enter your name: ")
    var name = readLine() ?: "Hero"
     while (!checkName(name)) {
         nameSelect();
     }
    return name

}

fun checkName(name: String): Boolean {
    if (name.length < 3 || name.length > 15) {
        println("Name must be between 3 and 15 characters.")
        return false
    } else {
        return true
    }
}

fun intro() {
    println("Hello mighty hero!")
    println("Welcome to the dungeon game.")
    println("Please enter your name: ")
}