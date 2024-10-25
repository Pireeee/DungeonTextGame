package entities

import fr.entities.BaseEntity
import fr.entities.Item

class Player(
    override val name: String,
    val playerClass: PlayerClass,
    val baseStrength: Int,
    val baseDefense: Int,
    val baseHealth: Int,
    val baseMana: Int,
    override var totalStrength: Int = baseStrength,
    override var totalDefense: Int = baseDefense,
    override var totalHealth: Int = baseHealth,
    override var totalMana: Int = baseMana,
    var inventory: MutableList<Item> = mutableListOf()
): BaseEntity


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