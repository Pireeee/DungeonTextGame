package fr.entities

import fr.entities.entities.Monster
import fr.entities.entities.Player

interface Cell {
    val displayChar: Char
}

class DoorCell : Cell {
    override val displayChar: Char
        get() = '#'
}

class EmptyCell() : Cell{
    override val displayChar: Char
        get() = '.'
}

class MonsterCell(val monster: Monster) : Cell{
    override val displayChar: Char
        get() = 'M'
}
class TreasureCell(val description: String, val value: Int) : Cell{
    override val displayChar: Char
        get() = 'T'
}

class ObstacleCell : Cell {
    override val displayChar: Char
        get() = 'X'
}

class PlayerCell(val player: Player) : Cell {
    override val displayChar: Char
        get() = player.direction.displayChar
}
