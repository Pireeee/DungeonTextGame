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
): BaseEntity


enum class PlayerClass {
    WARRIOR,
    MAGE,
    ROGUE
}

