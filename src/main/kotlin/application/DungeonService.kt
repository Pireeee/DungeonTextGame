package application

import entities.Cell
import entities.Dungeon
import entities.Room

class DungeonService {

    fun generateDungeon(rooms: Int): Dungeon {
        // Logique de génération de donjon
        // create one room for now
        val rooms = Array(rooms) { createRoom(5) }
        // create the dungeon
        val dungeon = Dungeon(
            rooms
        )
        return dungeon
    }

    fun createRoom(size: Int): Room {
        // Logique de création de salle
        return Room(size, size, Array(size) { Array(size) { Cell.Empty } })
    }
}