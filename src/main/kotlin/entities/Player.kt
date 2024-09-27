package entities

data class Player(
    val name: String,
    val playerClass: PlayerClass,
    var strength: Int,
    var defense: Int,
    var health: Int,
    var mana: Int,
)

enum class PlayerClass {
    WARRIOR,
    MAGE,
    ROGUE
}

enum class PlayerStats{
    NAME,
    CLASS,
    STRENGTH,
    DEFENCE,
    HEALTH,
    MANA,
    INVENTORY
}