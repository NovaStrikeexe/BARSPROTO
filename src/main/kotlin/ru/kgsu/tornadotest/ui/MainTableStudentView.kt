package ru.kgsu.tornadotest.ui

import javafx.scene.Parent
import javafx.scene.paint.Color
import javafx.scene.text.Font
import ru.kgsu.tornadotest.controllers.MainTableStudentController
import ru.kgsu.tornadotest.data.Discepline
import ru.kgsu.tornadotest.data.Student
import ru.kgsu.tornadotest.data.Teacher
import ru.kgsu.tornadotest.data.Mark
import tornadofx.*
import tornadofx.Stylesheet.Companion.mark

class MainTableStudentView() : View() {
    val mainTableStudentController: MainTableStudentController by inject()
    val teacher = Teacher("T123", "1234", "Артур", " Котов")
    val disceplineOne = Discepline("Введение в паттерны проектирования", teacher, 3.6f);
    val disceplineTwo = Discepline("Объектно-ориентированное программирование", teacher, 3.7f);
    val listOfDiscepline = listOf(disceplineOne, disceplineTwo)
    val student1 =
        Student("7894563Student2", "7896543", "Aнна", "Мишкина", 3002222, listOfDiscepline, 3.6f, 3.7f)
    val student2 =
        Student("7894563Student2", "7896543", "Паймон", "Вкотле", 3002222, listOfDiscepline, 4.3f,4.4f)
    val student3 =
        Student("7894563Student2", "7896543", "Тортик", "Британский", 3002222, listOfDiscepline, 4.6f, 4.7f)
    val Marks = listOf(
        Mark(1, "${student1.name} ${student1.sName}", student1.sMarkVPP, student1.sMarkOOP),
        Mark(2, "${student2.name} ${student2.sName}", student2.sMarkVPP, student2.sMarkOOP),
        Mark(3, "${student3.name} ${student3.sName}", student3.sMarkVPP, student3.sMarkOOP),
    ).asObservable()
    override val root = tabpane {
        prefWidth = 800.0
        prefHeight = 600.0
        tab("БРС") {
            vbox {
                textflow {
                    text(
                        "Пользователь: ${teacher.name}" +
                                teacher.sName
                    ) {
                        fill = Color.PURPLE
                        font = Font(20.0)
                    }
                }
                //button("Предметы").action {
                  //  mainTableStudentController.showStudentDisceplines()
                //}
                tableview(Marks) {
                    readonlyColumn("ID",Mark::id)
                    readonlyColumn("Name", Mark::mName)
                    readonlyColumn("VPP", Mark::MarkVPP)
                    readonlyColumn("OOP", Mark::MarkOOP)
                }
                //button("Оценки").action {
                  //  mainTableStudentController.ShowStudentMarks()
               // }
            }
        }
//        tab("КЕС") {//Сюда чето запихть чтобы было// }
//
//            tab("АПР") {
//                borderpane {
//                    left = vbox {
//                        button("Загрузить файл с тестом")
//                        button("Загрузить файл с кодом")
//                        button("Запуск тестов")
//                    }
//                    top = hbox {
//                        textflow {
//                            text(
//                                "Пользователь: \n${teacher.name}\n" +
//                                        "${teacher.sName}"
//                            ) {
//                                fill = Color.PURPLE
//                                font = Font(20.0)
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
    }

}