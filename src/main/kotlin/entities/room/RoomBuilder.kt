package fr.entities.room

import fr.entities.entities.Monster
import fr.entities.entities.player.Player
import fr.entities.*
import fr.entities.entities.Treasure

class RoomBuilder {
    private var size: Int = 5
    private var isRandom: Boolean = true
    private val entities: MutableList<Triple<Int, Int, Cell>> = mutableListOf()

    init {
        for (i in 0 until size) {
            for (j in 0 until size) {
                entities.add(Triple(i, j, EmptyCell()))
            }
        }
    }

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

    fun placeTreasure(x: Int, y: Int, treasure: Treasure): RoomBuilder {
        entities.add(Triple(x, y, TreasureCell(treasure)))
        return this
    }

    fun placeObstacle(x: Int, y: Int): RoomBuilder {
        entities.add(Triple(x, y, ObstacleCell()))
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