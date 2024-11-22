package tests
import application.checkName
import application.setPlayerClass
import entities.Player
import entities.PlayerClass
import kotlin.test.Test
import kotlin.reflect.full.memberProperties
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse

class PlayerTest {
    val playerData = mapOf(
        "name" to "Link",
        "totalStrength" to 5,
        "totalDefense" to 5,
        "totalHealth" to 100,
        "totalMana" to 10,
        "playerClass" to PlayerClass.WARRIOR
    )
    @Test
    fun `creation valid player`() {
        val playerProperties = Player::class.memberProperties.associateBy { it.name }
        val player = Player(
            playerData["name"] as String,
            playerData["playerClass"] as PlayerClass,
            playerData["totalStrength"] as Int,
            playerData["totalDefense"] as Int,
            playerData["totalHealth"] as Int,
            playerData["totalMana"] as Int
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
        assertFails { Player(name, PlayerClass.WARRIOR, 10, 5, 100, 10) }
    }

    @Test
    fun `create player, invalid player name, too long`() {
        val name = "Aazerqsdgeargqsdfzaedgh"
        assertFails { Player(name, PlayerClass.WARRIOR, 10, 5, 100, 10) }
    }

    @Test
    fun `invalid player name (empty)`() {
        assertFalse { checkName("") }
    }

    @Test
    fun `invalid player name (too long)`() {
        assertFalse{checkName("ThisNameIsTooLong")}
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
}

   