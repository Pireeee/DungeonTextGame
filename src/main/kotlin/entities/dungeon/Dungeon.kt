package fr.entities.dungeon

import Room
import fr.entities.DoorCell
import fr.entities.MoveResult
import fr.entities.entities.player.Player


class Dungeon(rooms: Int, roomSize: Int, isRandom:Boolean = true){

    var currentRoomIndex = 0
    val roomsArray = generateRooms(rooms, roomSize, isRandom)

    init {
        require(rooms > 0 && roomSize > 0) { "Dungeon dimensions must be positive" }
    }

    private fun generateRooms(number: Int, size: Int, isRandom: Boolean): Array<Room> {
        return Array(number) { Room(size, isRandom) }
    }

    fun displayCurrentRoom(){
        roomsArray[currentRoomIndex].display()
    }

    fun placePlayer(player: Player, room:Int ) {
        roomsArray[room].placePlayer(player)
        currentRoomIndex = room
    }

    fun setRoom(room:Room, index:Int){
        roomsArray[index] = room
    }

    fun movePlayerWithinRoom(player: Player, toX: Int, toY: Int): MoveResult {
        if (currentRoomIndex !in roomsArray.indices) {
            println("Invalid room index")
            return MoveResult.NOT_ALLOWED
        }

        val currentRoom = roomsArray[currentRoomIndex]
        val (fromX, fromY) = currentRoom.findPlayerPosition(player)

        if (!currentRoom.isValidPosition(toX, toY)) {
            println("Invalid move: ($toX, $toY) is out of bounds")
            return MoveResult.NOT_ALLOWED
        }

        if (currentRoom.getCell(toX, toY) is DoorCell) {
            if (currentRoomIndex == roomsArray.size - 1) {
                println("Congratulations! You have reached the end of the dungeon.")
                return MoveResult.END_OF_DUNGEON
            }

            currentRoom.removePlayer(fromX, fromY)
            currentRoomIndex++
            roomsArray[currentRoomIndex].placePlayer(player, toX, toY)
            println("You moved to room $currentRoomIndex")
            return MoveResult.MOVED_TO_NEXT_ROOM
        }

        currentRoom.movePlayer(player, fromX, fromY, toX, toY)
        return MoveResult.MOVED_WITHIN_ROOM
    }

}


