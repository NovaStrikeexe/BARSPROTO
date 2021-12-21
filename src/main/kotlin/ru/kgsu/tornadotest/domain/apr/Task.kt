package ru.kgsu.tornadotest.domain.apr

import ru.kgsu.tornadotest.data.Teacher

/**
 * Задание (таск) для подуля АПР
 */
data class Task(
    val id: Long,
    val title: String,
    val subTitle: String,
    val author: Teacher,
    val text: String,
    val maxAttemptCount: Int,
    val test: TestBlock
)
