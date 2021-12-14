package ru.kgsu.tornadotest.ui

import ru.kgsu.tornadotest.controllers.StudentMarksController
import tornadofx.*

class StudentMarksView : View() {
    val studentMarksController: StudentMarksController by inject()

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
        }
    }
}