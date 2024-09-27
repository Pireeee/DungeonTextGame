package entities

data class Room(
    val description: String,
    var monster: Monster? = null,
)