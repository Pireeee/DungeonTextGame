package entities

import fr.entities.BaseEntity

class Monster (
    override val name: String,
    val baseStrength: Int,
    val baseDefense: Int,
    val baseHealth: Int,
    val baseMana: Int,
    override var totalStrength: Int = baseStrength,
    override var totalDefense: Int = baseDefense,
    override var totalHealth: Int = baseHealth,
    override var totalMana: Int = baseMana,
): BaseEntity