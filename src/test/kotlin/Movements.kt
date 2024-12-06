package tests
import fr.entities.EmptyCell
import fr.entities.MonsterCell
import fr.entities.dungeon.Dungeon
import fr.entities.entities.Monster
import fr.entities.entities.Player
import fr.entities.entities.PlayerClass
import fr.entities.room.RoomBuilder
import kotlin.test.Test

class MovementsTests{
    //Déplacement vers une case vide
    val roomSize = 5
    val player = Player("link", PlayerClass.WARRIOR)
    val dungeon = Dungeon(5, roomSize,false)
    val monster = Monster("Goblin")
    val customRoom = RoomBuilder()
        .setSize(roomSize)
        .setRandom(false)
        .placeEmpty(1,1)
        .placeMonster(1,2, monster)
        .placeTreasure(1,3, "Gold", 100)
        .placeDoor(1,4)
        .build()

    @Test
    fun `move player on an empty cell`() {
        dungeon.placePlayer(player, 0)
        dungeon.setRoom(customRoom, 0)
        //test the cell 1,1 is an instence of empty cell

        if(dungeon.rooms.get(0).getCell(1,1) !is EmptyCell){
            println("The cell 1,1 is not empty")
            assert(dungeon.movePlayerWithinRoom(player, 0, 0, 0, 1, 1))
        }
        else{
            assert(false)
        }
    }
    //Déplacement vers une case contenant un monstre
    @Test
    fun `move player on a monster cell`() {
        dungeon.placePlayer(player, 0)
        dungeon.setRoom(customRoom, 0)
        //test the cell 1,2 is an instence of monster cell
        if(dungeon.rooms.get(0).getCell(1,2) is MonsterCell){
            println("The cell 1,2 is a monster")
            assert(dungeon.movePlayerWithinRoom(player, 0, 0, 0, 1, 2))
        }
        else{
            assert(false)
        }
    }
    //Tentative de déplacement hors de la grille
    @Test
    fun `move player on a out of the grid cell`() {
        dungeon.placePlayer(player, 0)
        dungeon.setRoom(customRoom, 0)
        //test the cell 1,6 is out of the grid
        if(dungeon.rooms.get(0).getCell(1,6) == null){
            println("The cell 1,6 is out of the grid")
            assert(dungeon.movePlayerWithinRoom(player, 0, 0, 0, 1, 6))
        }
        else{
            assert(false)
        }
    }
    //Tentative de déplacement hors de la grille
    @Test
    fun `move the player multiple times`() {
        // TODO
    }
    //Rencontre d'un trésor lors du déplacement
    @Test
    fun `move player on a treasure cell`() {
        // TODO
    }
    //Déplacement bloqué par un obstacle
    @Test
    fun `move player to a obstacle cell`() {
        // TODO
    }
    //Gestion des limites de la grille
    @Test
    fun `move the player to an out of the grid cell`() {
        // TODO
    }
    //Rotation et orientation du personnage
    @Test
    fun `move the player orientation`() {
        // TODO
    }
    // Déplacement avec orientation
    @Test
    fun `move the player to the cell in the orientation's direction`() {
        // TODO
    }
    // Série de commandes complexes
    @Test
    fun `do a series of complexe movements`() {
        // TODO
    }
}