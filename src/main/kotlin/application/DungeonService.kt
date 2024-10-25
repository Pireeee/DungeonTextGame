package application

import entities.Dungeon
import entities.Monster
import entities.Room
import fr.entities.*
import kotlin.random.Random

class DungeonService {

    var DUNGEON_SIZE = 5

    fun displayDungeon(dungeon: Dungeon) {
        for (room in dungeon.rooms) {
            displayRoom(room)
            println() // Separate rooms with a blank line
        }
    }

    fun displayRoom(room: Room){
        for (y in 0 until room.size) {
            for (x in 0 until room.size) {
                val cell = room.getCell(x, y)
                val symbol = cell?.displayChar
                print(symbol)
            }
            println()
        }
        println() // Separate rooms with a blank line
    }

}