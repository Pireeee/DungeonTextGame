package tests
import fr.entities.entities.player.checkName
import fr.entities.entities.player.setPlayerClass
import fr.entities.entities.player.Player
import fr.entities.entities.player.PlayerClass
import kotlin.test.Test
import kotlin.reflect.full.memberProperties
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import fr.entities.entities.player.returnPlayerInfoString

class PlayerTest {

    private val playerData = mapOf(
        "name" to "Link",
        "playerClass" to PlayerClass.WARRIOR
    )
    @Test
    fun `creation valid player`() {
        val playerProperties = Player::class.memberProperties.associateBy { it.name }
        val player = Player(
            playerData["name"] as String,
            playerData["playerClass"] as PlayerClass,
        )

        playerData.forEach { (key, value) ->
            val property = playerProperties[key]
            if (property != null) {
                val playerValue = property.get(player) // Récupère la valeur de la propriété du joueur
                assertEquals(value, playerValue, "La propriété $key ne correspond pas.")
            } else {
                throw IllegalArgumentException("Propriété $key non trouvée dans l'objet Player.")
            }
        }
    }

    @Test
    fun `create player, invalid player name, too short`() {
        val name = "A"
        assertFails { Player(name, PlayerClass.WARRIOR ) }
    }

    @Test
    fun `create player, invalid player name, too long`() {
        val name = "Aazerqsdgeargqsdfzaedgh"
        assertFails { Player(name, PlayerClass.WARRIOR) }
    }

    @Test
    fun `invalid player name (empty)`() {
        assertFalse { checkName("") }
    }

    @Test
    fun `invalid player name (too long)`() {
        assertFalse{ checkName("ThisNameIsTooLong") }
    }
    @Test
    fun `invalid player name (too short)`() {
        assertFalse { checkName("A") }
    }

    @Test
    fun `valid player class`() {
        assert(setPlayerClass("rogue") == (PlayerClass.ROGUE))
    }

    @Test
    fun `invalid player class`() {
        assert(setPlayerClass("bard") == null)
    }
    /*@Test
fun `create player, invalid player class`() {
    assertFails { Player("link", "oui", 10, 5, 100, 10) }
}*/
    @Test
    fun `player infos are displayed correctly`() {
        //given un warrior et les stats d'un warrior
        val player = Player("Link", PlayerClass.WARRIOR)
        val data = "Name: Link\n" +
                "Class: WARRIOR\n" +
                "Stats: Health: 100\n" +
                "Mana: 50\n" +
                "Strength: 10\n" +
                "Intelligence: 5\n" +
                "Defense: 10\n" +
                "MagicDefence: 5\n" +
                "Agility: 5\n" +
                "Chance: 5\n" +
                "Endurance: 5\n" +
                "Spirit: 5\n"+
                "Direction: SOUTH\n" +
                "Inventory: []"
        //When je renvoie les infos du joueur
        //Then les infos du joueur sont les bonnes
        assertEquals(data, returnPlayerInfoString(player))
    }
}

   