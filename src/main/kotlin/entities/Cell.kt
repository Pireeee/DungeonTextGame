package fr.entities

import entities.Monster
import entities.Player

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
class Treasure(val description: String, val value: Int) : Cell{
    override val displayChar: Char
        get() = 'T'
}
class PlayerCell(val player: Player) : Cell{
    override val displayChar: Char
        get() = 'P'
}
