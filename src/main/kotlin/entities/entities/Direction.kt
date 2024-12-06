package fr.entities.entities

enum class Direction {
    NORTH, SOUTH, EAST, WEST;

    val displayChar: Char
        get() = when (this) {
            NORTH -> '^'
            SOUTH -> 'v'
            EAST -> '>'
            WEST -> '<'
        }
    fun turnLeft(): Direction {
        return when (this) {
            NORTH -> WEST
            WEST -> SOUTH
            SOUTH -> EAST
            EAST -> NORTH
        }
    }

    fun turnRight(): Direction {
        return when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }
}