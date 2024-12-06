package fr.entities.dungeon

import fr.entities.entities.Player
import fr.entities.room.Room

class Dungeon(number: Int, size: Int,isRandom:Boolean){

    var currentRoomIndex = 0
    val rooms = generateRooms(number, size,isRandom)

    init {
        require(number > 0 && size > 0) { "Dungeon dimensions must be positive" }
    }
    private fun generateRooms(number: Int, size: Int, isRandom: Boolean): Array<Room> {
        return Array(number) { Room(size, isRandom) }
    }

    fun display(){
        for (room in rooms) {
            room.display()
        }
    }

    fun displayCurrentRoom(){
        rooms[currentRoomIndex].display()
    }

    fun placePlayer(player: Player, room:Int ) {
        rooms[room].placePlayer(player)
        currentRoomIndex = room
    }

    fun movePlayerWithinRoom(player: Player, roomIndex: Int, fromX: Int, fromY: Int, toX: Int, toY: Int):Boolean {
        if (roomIndex in rooms.indices) {
            rooms[roomIndex].movePlayer(player, fromX, fromY, toX, toY)
            return true
        } else {
            println("Invalid room index")
            return false
        }
    }
}


