package fr.entities.dungeon

enum class Commands(val shortName: Char) {
    NORTH('N'), SOUTH('S'), EAST('E'), WEST('W'),
    GAUCHE('G'), DROITE('D'), QUIT('Q'), INFOS('I'),
    SAVE('K'), LOAD('L');

    companion object {
        fun fromChar(char: Char): Commands? {
            return values().find { it.shortName == char }
        }
    }
}
