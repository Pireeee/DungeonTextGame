class CombatService {
    fun attack(attacker, defender) {
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

    fun regen(target, amount) {
        target.totalHealth += amount
    }

    fun defend(target, amount) {
        target.totalDefense += amount
    }

    fun damage(target, amount) {
        target.totalHealth -= amount
    }
}