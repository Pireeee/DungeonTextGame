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
        //val playerClass = classSelect()
        val playerClass = classSelect()
        val player = Player(name, playerClass, 10, 5, 100, 10)
        println("Welcome ${player.name} the ${player.playerClass}! with stats: ${player.totalStrength} strength, ${player.totalDefense} defense, ${player.totalHealth} health, ${player.totalMana} mana.")
        return player
    }

    private fun classSelect(): PlayerClass {
        val validClasses = mutableSetOf<String>()
        enumValues<PlayerClass>().forEach {

            validClasses.add(it.name.toLowerCase())
        }
        println(validClasses)
        println("Please choose your class: (${validClasses.joinToString(", ")})")
        val playerclass = readLine()?.let { setPlayerClass(it) }
        if ( playerclass != null) {
            return playerclass
        } else {
            println("Invalid class")
            return classSelect()
        }
    }
}

fun setPlayerClass(input: String): PlayerClass? {
    val exists = PlayerClass.values().any { clazz ->
        clazz.name.equals(input, ignoreCase = true)
    }

    // If it doesn't exist, return null
    if (!exists) {
        return null
    }

    // If it exists, find and return the corresponding PlayerClass
    return PlayerClass.values().find { clazz ->
        clazz.name.equals(input, ignoreCase = true)
    }
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
}