package fr.controllers

import fr.entities.dungeon.Dungeon
import fr.entities.dungeon.DungeonBuilder
import fr.entities.entities.player.Player
import fr.entities.entities.player.PlayerService

class GameInitializer {
    fun initialize(): Pair<Player, Dungeon> {
        val playerService = PlayerService()
        val player = playerService.createPlayer()
        val dungeon = DungeonBuilder().setRooms(5).setRoomSize(5).build()
        dungeon.placePlayer(player, 0)
        return Pair(player, dungeon)
    }
}