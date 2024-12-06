package fr.entities.entities

class Monster (
    override val name: String,
    override var baseStats: EntityStats,
    override var totalStats: EntityStats
): BaseEntity