package fr.entities.room

import fr.entities.entities.Monster
import fr.entities.entities.Player
import fr.entities.*

class RoomBuilder {
    private var size: Int = 1
    private var isRandom: Boolean = false
    private val entities: MutableList<Triple<Int, Int, Cell>> = mutableListOf()

    fun setSize(size: Int): RoomBuilder {
        this.size = size
        return this
    }

    fun setRandom(isRandom: Boolean): RoomBuilder {
        this.isRandom = isRandom
        return this
    }

    fun addEntity(x: Int, y: Int, entity: Cell): RoomBuilder {
        entities.add(Triple(x, y, entity))
        return this
    }

    fun placeMonster(x: Int, y: Int, monster: Monster): RoomBuilder {
        entities.add(Triple(x, y, MonsterCell(monster)))
        return this
    }

    fun placeTreasure(x: Int, y: Int, name: String, value: Int): RoomBuilder {
        entities.add(Triple(x, y, Treasure(name, value)))
        return this
    }

    fun placeDoor(x: Int, y: Int): RoomBuilder {
        entities.add(Triple(x, y, DoorCell()))
        return this
    }

    fun placePlayer(x: Int, y: Int,player: Player): RoomBuilder {
        entities.add(Triple(x, y, PlayerCell(player)))
        return this
    }

    fun placeEmpty(x: Int, y: Int): RoomBuilder {
        entities.add(Triple(x, y, EmptyCell()))
        return this
    }

    fun build(): Room {
        val room = Room(size, isRandom)
        for ((x, y, entity) in entities) {
            room.setCell(x, y, entity)
        }
        return room
    }
}