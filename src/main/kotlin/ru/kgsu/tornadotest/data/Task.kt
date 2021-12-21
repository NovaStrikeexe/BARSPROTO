package ru.kgsu.tornadotest.data

@Deprecated("Bad design")
class Task(var numberOfTask: Long, var typeOfTask:String, var nameOfTask: String, var authorOfTask: Teacher, var textOfTask:String) {
}