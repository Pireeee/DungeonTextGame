package fr.entities.entities

import kotlin.reflect.full.memberProperties

interface BaseEntity {
    val name: String
    var baseStats : EntityStats
    var totalStats : EntityStats
}
fun BaseEntity.printStats() {
    println("\nTotal Stats:")
    totalStats.printDynamicStats()
}
interface EntityStats {
    val health: Int
    val mana : Int
    val strength: Int
    val intelligence: Int
    val defense: Int
    val magicDefence : Int
    val agility: Int
    val chance: Int
    val endurance: Int
    val spirit: Int
}
fun EntityStats.printDynamicStats() {
    this::class.memberProperties.forEach { property ->
        // Vérifie que la propriété est bien de type Int avant de l'utiliser
        val value = (property as? kotlin.reflect.KProperty1<EntityStats, Int>)?.get(this)
        if (value != null) {
            println("${property.name.capitalize()}: $value")
        }
    }
}
