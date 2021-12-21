package ru.kgsu.tornadotest.data

class TaskMark(
    var Task: Task,
    var authorOfTask: Teacher,
    var responsibleExecutor: StudentTaskTry,
    var mark: Float
) {
}