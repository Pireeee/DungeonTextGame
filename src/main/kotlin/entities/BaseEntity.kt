package fr.entities

interface BaseEntity {
    val name: String
    open var totalStrength: Int
    open var totalDefense: Int
    open var totalHealth: Int
    open var totalMana: Int
}