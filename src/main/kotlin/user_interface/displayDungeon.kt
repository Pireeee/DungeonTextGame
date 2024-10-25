package user_interface

import entities.Dungeon
import entities.Cell

fun displayDungeon(dungeon: Dungeon) {
    for (y in 0 until dungeon.height) {
        for (x in 0 until dungeon.width) {
            val cell = dungeon.getCell(x, y)
            val symbol = when (cell) {
                is Cell.Empty -> "."
                is Cell.MonsterCell -> "M"
                is Cell.Treasure -> "T"
                else -> " "
            }
            print(symbol)
        }
        println()
    }
}