package fr.entities.entities

import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

interface BaseEntity {
    val name: String
    var baseStats : EntityStats
    var totalStats : EntityStats
}
fun BaseEntity.printStats() {
    println("\nTotal Stats:")
    val stats = totalStats.getDynamicStatsString()
    println(stats)
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
    companion object {
        val propertyOrder = listOf(
            "health",
            "mana",
            "strength",
            "intelligence",
            "defense",
            "magicDefence",
            "agility",
            "chance",
            "endurance",
            "spirit"
        )
    }
}
fun EntityStats.getDynamicStatsString(): String {
    val propsByName = this::class.memberProperties.associateBy { it.name }

    return EntityStats.propertyOrder.mapNotNull { propName ->
        val property = propsByName[propName] as? KProperty1<EntityStats, Int>
        val value = property?.get(this)
        value?.let { "${propName.replaceFirstChar { it.uppercaseChar() }}: $value" }
    }.joinToString("\n")
}