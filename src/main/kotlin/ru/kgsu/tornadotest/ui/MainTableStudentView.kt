package ru.kgsu.tornadotest.ui

import javafx.scene.paint.Color
import javafx.scene.text.Font
import ru.kgsu.tornadotest.controllers.MainTableStudentController
import ru.kgsu.tornadotest.data.Discepline
import ru.kgsu.tornadotest.data.Student
import ru.kgsu.tornadotest.data.Teacher
import tornadofx.*

class MainTableStudentView() : View() {
    val mainTableStudentController: MainTableStudentController by inject()
    val teacher = Teacher("T123", "1234", "Артур Котов")
    val disceplineOne = Discepline("Введение в паттерны проектирования", teacher, 3.6f);
    val disceplineTwo = Discepline("Объектно-ориентированное программирование", teacher, 3.7f);
    val listOfDiscepline = listOf(disceplineOne, disceplineTwo)
    val student =
        Student("7894563Student2", "7896543", "Aнна Мишкина", 3002222, listOfDiscepline,3.5F,4.2F)
    override val root = tabpane {
        prefWidth = 800.0
        prefHeight = 600.0
        tab("БРС") {
            isClosable = false
            vbox {
                textflow {
                    text(
                        "Пользователь:${student.fio}"
                    ) {
                        fill = Color.PURPLE
                        font = Font(20.0)
                    }
                }
                button("Предметы").action {
                    mainTableStudentController.showStudentDisceplines()
                }
                button("Оценки").action {
                    mainTableStudentController.ShowStudentMarks()
                }
            }
        }
        tab("Проверить") {
            isClosable = false
            borderpane {
                center = APRView().root
            }
        }
    }

}