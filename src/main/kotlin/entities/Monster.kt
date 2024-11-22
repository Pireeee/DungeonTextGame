package entities

import fr.entities.BaseEntity
import fr.entities.EntityStats

class Monster (
    override val name: String,
    override var baseStats: EntityStats,
    override var totalStats: EntityStats
): BaseEntity