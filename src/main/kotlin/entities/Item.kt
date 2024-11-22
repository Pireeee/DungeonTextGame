package fr.entities

sealed class Item (
    val name: String

)

// cree un equipement qui est un super item

data class Equipment(
    val type: EquipmentType,
    val strength: Int,
    val defense: Int,
    val health: Int,
    val mana: Int
): Item("$type") {
    enum class EquipmentType {
        WEAPON,
        ARMOR,
        SHIELD
    }
}

//cré un potion
data class Potion(
    val type: PotionType,
    val value: Int
): Item("$type potion") {
    enum class PotionType {
        HEALING,
        MANA,
        STRENGTH,
        DEFENSE,
        DAMAGE,
    }

    fun usePotion(target: BaseEntity) {
        /*
        when (type) {
            PotionType.HEALING -> target.totalHealth += value
            PotionType.MANA -> target.totalMana += value
            PotionType.STRENGTH -> target.totalStrength += value
            PotionType.DEFENSE -> target.totalDefense += value
            PotionType.DAMAGE -> target.totalHealth -= value
        }*/
    }
}