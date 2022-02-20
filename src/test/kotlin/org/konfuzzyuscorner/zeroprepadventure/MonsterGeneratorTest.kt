package org.konfuzzyuscorner.zeroprepadventure

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MonsterGeneratorTest {
    val gen = MonsterGenerator()

    @Test
    fun generateMonsterOfLevel() {
        val expectedLvl = 3
        val expectedRole = Role.Controller

        val monster = gen.builder(expectedLvl, expectedRole)
            .build()
        assertEquals(expectedLvl, monster.level)
        assertEquals(expectedRole, monster.role)
    }

}