package org.konfuzzyuscorner.zeroprepadventure

class MonsterGenerator {
    fun builder(level: Int, role: Role): MonsterBuilder = MonsterBuilder(level, role)

    class MonsterBuilder(val level: Int, val role: Role) {

        fun build(): Monster {
            return Monster(level, role)
        }

    }
}

enum class Role(val modifier: (Monster) -> Monster) {
    Controller({ m ->
        m.copy(armorClass = m.armorClass - 2,
            savingThrows = m.savingThrows.map { it - 1 })
    }),
    Defender({ m ->
        m.copy(
            armorClass = m.armorClass + 2,
            savingThrows = m.savingThrows.map { it + 1 },
            speed = m.speed - 10
        )
    }),
    Lurker({ m ->
        m.copy(
            armorClass = m.armorClass - 4,
            hitPoints = m.hitPoints / 2,
            savingThrows = m.savingThrows.map { it - 2 },
            attackBonus = m.attackBonus + 2,
            damagePerAction = m.damagePerAction * 3 / 2
        )
    }),
    Scout({ m ->
        m.copy(
            armorClass = m.armorClass - 2,
            hitPoints = m.hitPoints * 3 / 4,
            savingThrows = m.savingThrows.map { it - 1 },
            damagePerAction = m.damagePerAction * 3 / 4,
            speed = m.speed + 10
        )
    }),
    Sniper({ m ->
        m.copy(
            hitPoints = m.hitPoints * 3 / 4,
            damagePerAction = m.damagePerAction * 5 / 4
        )
    }),
    Striker({ m ->
        m.copy(
            armorClass = m.armorClass - 4,
            hitPoints = m.hitPoints * 5 / 4,
            savingThrows = m.savingThrows.map { it - 4 },
            attackBonus = m.attackBonus + 2,
            damagePerAction = m.damagePerAction * 5 / 4
        )
    }),
    Supporter({ m ->
        m.copy(
            armorClass = m.armorClass - 2,
            hitPoints = m.hitPoints * 3 / 4,
            savingThrows = m.savingThrows.map { it - 2 },
            damagePerAction = m.damagePerAction * 3 / 4
        )
    })
}
/*
Role      Armor Class Saving Throws Hit Points Attack Bonus Damage per Action Speed Perception Stealth Initiative
Controller −2 −1 —       —      —   — — — Trained
Defender   +2 +1 —       —      — −10 Trained — —
Lurker     −4 −2 x 0.5  +2 x 1.5    — Trained Trained —
Scout      −2 −1 —       — x 0.75 +10 Trained Trained Trained
Sniper      —  — x 0.75  — x 1.25   — — Trained —
Striker    −4 −2 x 1.25 +2 x 1.25   — — — —
Supporter  −2 −1 x 0.75  — x 0.75   — — — Trained
 */


data class Monster(
    val level: Int,
    val role: Role,
    val armorClass: Int = armorClassByLevel(level),
    val hitPoints: Int = hitPointsByLevel(level),
    val savingThrows: List<Int> = savingThrowsByLevel(level),
    val attackBonus: Int = attackBonusPerLevel(level),
    val damagePerAction: Int = damagePerActionPerLevel(level),
    val spellDc: Pair<Int, Int> = spellDcPerLevel(level),
    val speed: Int = 30,
    val proficiencyBonus: Int = proficiencyBonusByLevel(level),
    val ipsBonus: Int = ipsBonusByLevel(level),
    val skills: Map<>
)

fun lt(upper: Int): IntRange = Int.MIN_VALUE until upper
fun gt(lower: Int): IntRange = (lower + 1)..Int.MAX_VALUE

