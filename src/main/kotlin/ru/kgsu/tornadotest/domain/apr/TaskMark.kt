package ru.kgsu.tornadotest.domain.apr

import ru.kgsu.tornadotest.data.Student

/**
 * Отметка о сданном [Task]
 */
data class TaskMark(
    val task: Task,
    val student: Student,
    val lastCode: String,
    val attemptCount: Int = 1,
    val score: Float = 1f
) {

    /**
     * Копировать текущую оценку с увелечением
     */
    fun copyNext(code: String, score: Float): TaskMark =
        TaskMark(
            task = this.task,
            student = this.student,
            lastCode = code,
            attemptCount = this.attemptCount + 1,
            score = score
        )
}
