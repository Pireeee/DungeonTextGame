package fr.entities.entities.player

import fr.entities.entities.*
import fr.entities.entities.stats.MageStats
import fr.entities.entities.stats.RogueStats
import fr.entities.entities.stats.WarriorStats

class Player(
    override val name: String,
    override val playerClass: PlayerClass,
    override var direction: Direction = Direction.SOUTH,
    override var baseStats: EntityStats = findStatsByClass(playerClass),
    override var totalStats: EntityStats = baseStats,
    override var inventory: MutableList<Treasure> = mutableListOf(),

): PlayerInterface {
    init {
        require(name.length in 3..15) { "Name must be between 3 and 15 characters." }
        require( playerClass in PlayerClass.values()) { "Invalid class" }
        totalStats = baseStats
    }

    override fun moveForward(): Pair<Int, Int> {
        return when (direction) {
            Direction.NORTH -> Pair(0, -1)
            Direction.SOUTH -> Pair(0, 1)
            Direction.EAST -> Pair(1, 0)
            Direction.WEST -> Pair(-1, 0)
        }
    }

    override fun turnLeft() {
        direction = direction.turnLeft()
    }

    override fun turnRight() {
        direction = direction.turnRight()
    }

    override fun pickUpTreasure(treasure: Treasure) {
        println("$name picked up ${treasure.name}")
        inventory.add(treasure)
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

fun returnPlayerInfoString(player: Player): String {
    return "Name: ${player.name}\n" +
            "Class: ${player.playerClass}\n" +
            "Stats: ${player.totalStats.getDynamicStatsString()}\n" +
            "Direction: ${player.direction}\n" +
            "Inventory: ${player.inventory}"
}
