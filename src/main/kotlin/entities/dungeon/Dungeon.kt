package fr.entities.dungeon

import fr.entities.DoorCell
import fr.entities.entities.Player
import fr.entities.room.Room
import fr.entities.room.RoomBuilder

class Dungeon(rooms: Int, roomSize: Int, isRandom:Boolean = true){

    var currentRoomIndex = 0
    val rooms = generateRooms(rooms, roomSize, isRandom)

    init {
        require(rooms > 0 && roomSize > 0) { "Dungeon dimensions must be positive" }
    }

    private fun generateRooms(number: Int, size: Int, isRandom: Boolean): Array<Room> {
        return Array(number) { Room(size, isRandom) }
    }

    fun displayCurrentRoom(){
        rooms[currentRoomIndex].display()
    }

    fun placePlayer(player: Player, room:Int ) {
        rooms[room].placePlayer(player)
        currentRoomIndex = room
    }

    fun setRoom(room:Room, index:Int){
        rooms[index] = room
    }

    fun movePlayerWithinRoom(player: Player, toX: Int, toY: Int): Boolean {
        if (currentRoomIndex !in rooms.indices) {
            println("Invalid room index")
            return false
        }

        val currentRoom = rooms[currentRoomIndex]
        val (fromX, fromY) = currentRoom.findPlayerPosition(player)

        if (!currentRoom.isValidPosition(toX, toY)) {
            println("Invalid move: ($toX, $toY) is out of bounds")
            return false
        }

        if (currentRoom.getCell(toX, toY) is DoorCell) {
            currentRoom.removePlayer(fromX, fromY)
            currentRoomIndex = (currentRoomIndex + 1) % rooms.size
            rooms[currentRoomIndex].placePlayer(player, toX, toY)
            println("You moved to room $currentRoomIndex")
        } else {
            currentRoom.movePlayer(player, fromX, fromY, toX, toY)
        }

        return true
    }
    fun executeCommand(player: Player, command: Char): Boolean {
        val currentRoom = rooms[currentRoomIndex]
        val (currentX, currentY) = currentRoom.findPlayerPosition(player)

        return when (command) {
            'N' -> movePlayerWithinRoom(player, currentX , currentY- 1)
            'S' -> movePlayerWithinRoom(player, currentX , currentY+1)
            'E' -> movePlayerWithinRoom(player, currentX + 1, currentY )
            'O' -> movePlayerWithinRoom(player, currentX - 1, currentY )
            'A' -> {
                val (dx, dy) = player.moveForward()
                movePlayerWithinRoom(player, currentX + dx, currentY + dy)
            }
            'G' -> {
                player.turnLeft()
                true
            }
            'D' -> {
                player.turnRight()
                true
            }
            else -> {
                println("Invalid command")
                false
            }
        }
    }
}


