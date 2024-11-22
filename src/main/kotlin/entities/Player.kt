package entities

import fr.entities.BaseEntity
import fr.entities.EntityStats
import fr.entities.Item

class Player(
    override val name: String,
    val playerClass: PlayerClass,
    override var baseStats: EntityStats,
    override var totalStats: EntityStats,
    var inventory: MutableList<Item> = mutableListOf()
): BaseEntity {
    init {
        require(name.length in 3..15) { "Name must be between 3 and 15 characters." }
        require( playerClass in PlayerClass.values()) { "Invalid class" }
    }
}


enum class PlayerClass {
    WARRIOR,
    MAGE,
    ROGUE
}

