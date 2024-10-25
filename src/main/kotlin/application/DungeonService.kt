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

    fun displayDungeon(dungeon: Dungeon) {
        for (room in dungeon.rooms) {
            displayRoom(room)
            println() // Separate rooms with a blank line
        }
    }

    fun displayRoom(room: Room){
        for (y in 0 until room.height) {
            for (x in 0 until room.width) {
                val cell = room.getCell(x, y)
                val symbol = when (cell) {
                    is Cell.Empty -> "."
                    is Cell.MonsterCell -> "M"
                    is Cell.Treasure -> "T"
                    is Cell.PlayerCell -> "P"
                    else -> " "
                }
                print(symbol)
            }
            println()
        }
        println() // Separate rooms with a blank line
    }

}