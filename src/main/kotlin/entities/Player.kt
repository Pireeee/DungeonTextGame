package entities

import fr.entities.BaseEntity
import fr.entities.EntityStats
import fr.entities.Item
import fr.entities.stats.MageStats
import fr.entities.stats.RogueStats
import fr.entities.stats.WarriorStats

class Player(
    override val name: String,
    val playerClass: PlayerClass,
    override var baseStats: EntityStats = findStatsByClass(playerClass),
    override var totalStats: EntityStats = baseStats,
    var inventory: MutableList<Item> = mutableListOf()
): BaseEntity {
    init {
        require(name.length in 3..15) { "Name must be between 3 and 15 characters." }
        require( playerClass in PlayerClass.values()) { "Invalid class" }
        totalStats = baseStats
    }
}

enum class PlayerClass {
    WARRIOR,
    MAGE,
    ROGUE
}

fun findStatsByClass(playerClass: PlayerClass): EntityStats {
    return when (playerClass) {
        PlayerClass.WARRIOR -> WarriorStats()
        PlayerClass.MAGE -> MageStats()
        PlayerClass.ROGUE -> RogueStats()
    }
}
