package entities

class Dungeon(number: Int, size: Int){

    var currentRoomIndex = 0
    val rooms = generateRooms(number, size)

    init {
        require(number > 0 && size > 0) { "Dungeon dimensions must be positive" }
    }
    private fun generateRooms(number: Int,size: Int ): Array<Room> {
        return Array(number) { Room(size) }
    }

    fun display(){
        for (room in rooms) {
            room.display()
        }
    }

    fun displayCurrentRoom(){
        rooms[currentRoomIndex].display()
    }

    fun placePlayer(player: Player,room:Int ) {
        rooms[room].placePlayer(player)
        currentRoomIndex = room
    }

    fun movePlayerWithinRoom(player: Player, roomIndex: Int, fromX: Int, fromY: Int, toX: Int, toY: Int) {
        if (roomIndex in rooms.indices) {
            rooms[roomIndex].movePlayer(player, fromX, fromY, toX, toY)
        } else {
            println("Invalid room index")
        }
    }
}


