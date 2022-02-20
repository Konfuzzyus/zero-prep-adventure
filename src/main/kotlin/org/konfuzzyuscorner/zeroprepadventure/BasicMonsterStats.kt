package org.konfuzzyuscorner.zeroprepadventure

fun armorClassByLevel(lvl: Int): Int {
    // TODO: complete table
    return when (lvl) {
        in lt(-5) -> 10
        -5 -> 11
        -4 -> 12
        -3, -2, -1 -> 13
        0, 1, 2, 3 -> 14
        4 -> 15
        5, 6, 7 -> 16
        8 -> 17
        9, 10, 11, 12 -> 18
        13, 14, 15 -> 19
        16 -> 20
        in gt(16) -> 21
        else -> throw IllegalArgumentException()
    }
}

fun hitPointsByLevel(lvl: Int): Int {
    // TODO: complete table
    return when (lvl) {
        in lt(-5) -> 1
        -5, -4 -> 1
        -3 -> 4
        -2 -> 8
        -1 -> 12
        0 -> 16
        1 -> 26
        2 -> 30
        3 -> 33
        in gt(3) -> 35
        else -> throw IllegalArgumentException()
    }
}

fun savingThrowsByLevel(lvl: Int): List<Int> {
    // TODO: complete table
    return when (lvl) {
        in lt(-5) -> listOf(1, 0, -1)
        -5 -> listOf(1, 0, -1)
        in gt(-5) -> listOf(1, 0, -1)
        else -> throw IllegalArgumentException()
    }
}

fun attackBonusPerLevel(lvl: Int): Int {
    // TODO: enter table
    return 0
}

fun damagePerActionPerLevel(lvl: Int): Int {
    // TODO: enter table
    return 0
}

fun spellDcPerLevel(lvl: Int): Pair<Int, Int> {
    // TODO: enter table
    return Pair(12, 10)
}

fun proficiencyBonusByLevel(lvl: Int) : Int {
    // TODO: enter table
    return 0
}

fun ipsBonusByLevel(lvl:Int) : Int {
    // TODO: enter table
    return 0
}