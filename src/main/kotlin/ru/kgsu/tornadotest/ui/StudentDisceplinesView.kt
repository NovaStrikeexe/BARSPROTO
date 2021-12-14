package ru.kgsu.tornadotest.ui

import ru.kgsu.tornadotest.controllers.StudentDisceplinesController
import ru.kgsu.tornadotest.data.Discepline
import ru.kgsu.tornadotest.data.Teacher
import tornadofx.*

class StudentDisceplinesView : View() {
    val studentDisceplinesController: StudentDisceplinesController by inject()
    val teacher = Teacher("T123", "1234", "Артур", "Котов")
    val disceplineOne = Discepline("Введение в паттерны проектирования", teacher, 3.6f)
    val disceplineTwo = Discepline("Объектно-ориентированное программирование", teacher, 3.7f)
    val listOfDiscepline = listOf(disceplineOne, disceplineTwo)

    override val root = form {
        prefWidth = 800.0
        prefHeight = 600.0
        vbox {
            hbox {
                text(
                    "Дисциплины студента"
                )
                button("Назад").action {
                    studentDisceplinesController.goBack()
                }
            }
        }
    }
}