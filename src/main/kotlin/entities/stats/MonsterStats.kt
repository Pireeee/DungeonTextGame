package fr.entities.stats

import fr.entities.entities.EntityStats

class MonsterStats: EntityStats {
    override val health: Int = 20
    override val mana: Int = 0
    override val strength: Int = 2
    override val intelligence: Int = 0
    override val defense: Int = 1
    override val magicDefence: Int = 1
    override val agility: Int = 1
    override val chance: Int = 9999
    override val endurance: Int = 1
    override val spirit: Int = 12

}