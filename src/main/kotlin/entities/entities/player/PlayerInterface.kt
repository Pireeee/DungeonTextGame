package fr.entities.entities.player

import fr.entities.entities.BaseEntity
import fr.entities.entities.Treasure

interface PlayerInterface : BaseEntity {
    val  playerClass: PlayerClass
    var direction: Direction
    var inventory: MutableList<Treasure>
    fun moveForward(): Pair<Int, Int>
    fun turnLeft()
    fun turnRight()
    fun pickUpTreasure(treasure: Treasure)
}