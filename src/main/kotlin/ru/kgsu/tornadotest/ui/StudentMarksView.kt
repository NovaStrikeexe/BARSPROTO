package ru.kgsu.tornadotest.ui

import ru.kgsu.tornadotest.controllers.StudentMarksController
import ru.kgsu.tornadotest.data.Discepline
import ru.kgsu.tornadotest.data.Teacher
import tornadofx.*

class StudentMarksView : View() {
    val studentMarksController: StudentMarksController by inject()
    val teacher = Teacher("T123", "1234", "Артур", "Котов")
    val disceplineOne = Discepline("Введение в паттерны проектирования", teacher, 3.6f)
    val disceplineTwo = Discepline("Объектно-ориентированное программирование", teacher, 3.7f)

    override val root = form {
        prefWidth = 800.0
        prefHeight = 600.0
        vbox {
            hbox {
                text(
                    "Оценки студента"
                )
                button("Назад").action {
                    studentMarksController.goBack()
                }
            }
            listview<String> {
                items.add(getRow(disceplineOne))
                items.add(getRow(disceplineTwo))
            }

        }
    }

    private fun getRow(discepline: Discepline) = discepline.dName + " - " + discepline.curentMark
}