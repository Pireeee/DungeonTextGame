package fr.entities.entities

import fr.entities.entities.stats.MonsterStats

class Monster (
    override val name: String,
    override var baseStats: EntityStats = MonsterStats(),
    override var totalStats: EntityStats = baseStats
): BaseEntity