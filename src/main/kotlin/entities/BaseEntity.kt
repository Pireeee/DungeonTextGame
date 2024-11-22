package fr.entities

interface BaseEntity {
    val name: String
    var baseStats : EntityStats
    var totalStats : EntityStats
}
interface EntityStats {
    val health: Int
    val mana : Int
    val strength: Int
    val inteligence: Int
    val defense: Int
    val magicDefence : Int
    val agility: Int
    val chance: Int
    val endurence: Int
    val spirit: Int
}