package fr.entities.dungeon

class DungeonBuilder {
    private var rooms =1
    private var roomSize =1
    private var isRandom=true

    fun setRooms(number: Int): DungeonBuilder {
        this.rooms = number
        return this
    }

    fun setRoomSize(size: Int): DungeonBuilder {
        this.roomSize = size
        return this
    }

    fun setRandom(isRandom: Boolean): DungeonBuilder {
        this.isRandom = isRandom
        return this
    }

    fun build(): Dungeon {
        return Dungeon(rooms, roomSize, isRandom)
    }
}