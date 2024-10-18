import fr.entities.BaseEntity

class CombatService {
    fun attack(attacker:BaseEntity, defender:BaseEntity) {
        // recupere l'attaque de l'attaquant et la defense du defenseur
        val attack = attacker.totalStrength
        val defense = defender.totalDefense
        // calcul des degats
        val damage = attack - defense
        // si les degats sont positifs, on les applique au defenseur
        if (damage > 0) {
            damage(defender, damage)
        }
    }

    fun regen(target:BaseEntity, amount:Int) {
        target.totalHealth += amount
    }

    fun defend(target:BaseEntity, amount:Int) {
        target.totalDefense += amount
    }

    fun damage(target:BaseEntity, amount:Int) {
        target.totalHealth -= amount
    }
}