package fr.entities.stats

import fr.entities.entities.EntityStats

class WarriorStats: EntityStats {
    override val health: Int = 100
    override val mana: Int = 50
    override val strength: Int = 10
    override val intelligence: Int = 5
    override val defense: Int = 10
    override val magicDefence: Int = 5
    override val agility: Int = 5
    override val chance: Int = 5
    override val endurance: Int = 5
    override val spirit: Int = 5
}