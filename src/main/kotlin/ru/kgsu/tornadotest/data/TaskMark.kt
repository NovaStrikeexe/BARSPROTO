package ru.kgsu.tornadotest.data

@Deprecated("Bad design")
class TaskMark(
    var Task: Task,
    var authorOfTask: Teacher,
    var responsibleExecutor: StudentTaskTry,
    var mark: Float
) {
}