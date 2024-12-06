package fr.entities.entities

import fr.entities.entities.stats.MageStats
import fr.entities.entities.stats.RogueStats
import fr.entities.entities.stats.WarriorStats

class Player(
    override val name: String,
    val playerClass: PlayerClass,
    var direction: Direction = Direction.SOUTH,
    override var baseStats: EntityStats = findStatsByClass(playerClass),
    override var totalStats: EntityStats = baseStats,
    var inventory: MutableList<Item> = mutableListOf()
): BaseEntity {
    init {
        require(name.length in 3..15) { "Name must be between 3 and 15 characters." }
        require( playerClass in PlayerClass.values()) { "Invalid class" }
        totalStats = baseStats
    }

    fun moveForward(): Pair<Int, Int> {
        return when (direction) {
            Direction.NORTH -> Pair(0, -1)
            Direction.SOUTH -> Pair(0, 1)
            Direction.EAST -> Pair(1, 0)
            Direction.WEST -> Pair(-1, 0)
        }
    }

    fun turnLeft() {
        direction = direction.turnLeft()
    }

    fun turnRight() {
        direction = direction.turnRight()
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
