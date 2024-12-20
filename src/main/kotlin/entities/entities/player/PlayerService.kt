package fr.entities.entities.player

import fr.entities.entities.printStats

class PlayerService {

    fun createPlayer(): Player {
        var player: Player? = null

        // Boucle jusqu'à ce qu'un joueur valide soit créé
        while (player == null) {
            try {
                val name = nameSelect() // Demande le nom du joueur
                val playerClass = classSelect() // Demande la classe du joueur

                // Tentative de création du joueur
                player = Player(name, playerClass)

                // Affiche les informations du joueur créé
                println("Welcome ${player.name} the ${player.playerClass}!")
                player.printStats()
            } catch (e: IllegalArgumentException) {
                // Si une exception est levée, affiche le message d'erreur et redemande le nom
                println("Erreur: ${e.message}")
            }
        }

        // Retourne le joueur une fois qu'il est correctement créé
        return player
    }
    private fun classSelect(): PlayerClass {
        val validClasses = mutableSetOf<String>()
        enumValues<PlayerClass>().forEach {

            validClasses.add(it.name.lowercase())
        }
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
    return PlayerClass.values().find { clazz ->
        clazz.name.equals(input, ignoreCase = true)
    }
}
fun nameSelect(): String {
    println("Please enter your name: ")
    var name = readLine() ?: "Hero"
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