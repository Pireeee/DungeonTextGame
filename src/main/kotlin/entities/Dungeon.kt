package entities

class Dungeon(number: Int, size: Int){

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
}


