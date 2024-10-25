package tests
import entities.Player
import entities.PlayerClass
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.reflect.full.memberProperties
import kotlin.test.assertEquals

class PlayerTest {
    val playerData = mapOf(
        "name" to "Link",
        "strength" to 5,
        "defense" to 5,
        "health" to 100,
        "mana" to 10,
        "playerClass" to PlayerClass.WARRIOR
    )
    @Test
    fun `creation valid player`() {
        val playerProperties = Player::class.memberProperties.associateBy { it.name }
        val player = Player(
            playerData["name"] as String,
            playerData["playerClass"] as PlayerClass,
            playerData["strength"] as Int,
            playerData["defense"] as Int,
            playerData["health"] as Int,
            playerData["mana"] as Int
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
    fun `invalid player name`() {
        assertThrows<IllegalArgumentException> {
            Player("J", PlayerClass.WARRIOR, 10, 5, 100, 10)
        }
    }

    @Test
}