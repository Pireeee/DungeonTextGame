package entities

import fr.entities.BaseEntity

class Monster (
    override val name: String,
    var strength: Int,
    var defense: Int,
    var health: Int,
    var mana: Int
): BaseEntity(name, strength, defense, health, mana)