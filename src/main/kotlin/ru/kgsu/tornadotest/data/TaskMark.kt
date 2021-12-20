package ru.kgsu.tornadotest.data

class TaskMark(
    var numberOfTask: Long,
    var nameOfTask: String,
    var authorOfTask: Teacher,
    var responsibleExecutor: Student,
    var mark: Float
) {
}