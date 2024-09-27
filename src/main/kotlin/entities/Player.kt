package entities

import fr.entities.Item

data class Player(
    val name: String,
    val playerClass: PlayerClass,
    var baseStrength: Int,
    var baseDefense: Int,
    var baseHealth: Int,
    var baseMana: Int,
    var totalStrength: Int = baseStrength,
    var totalDefense: Int = baseDefense,
    var totalHealth: Int = baseHealth,
    var totalMana: Int = baseMana,
    var inventory: MutableList<Item> = mutableListOf()
)


enum class PlayerClass {
    WARRIOR,
    MAGE,
    ROGUE
}

enum class PlayerStats{
    NAME,
    CLASS,
    STRENGTH,
    DEFENCE,
    HEALTH,
    MANA,
    INVENTORY
}