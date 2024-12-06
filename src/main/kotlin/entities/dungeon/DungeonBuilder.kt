package fr.entities.dungeon

class DungeonBuilder {
    private var number=1
    private var size=1
    private var isRandom=true

    fun setNumber(number: Int): DungeonBuilder {
        this.number = number
        return this
    }

    fun setSize(size: Int): DungeonBuilder {
        this.size = size
        return this
    }

    fun setRandom(isRandom: Boolean): DungeonBuilder {
        this.isRandom = isRandom
        return this
    }

    fun build(): Dungeon {
        return Dungeon(number, size, isRandom)
    }
}