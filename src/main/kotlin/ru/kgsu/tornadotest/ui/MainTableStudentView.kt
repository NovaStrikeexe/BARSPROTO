package ru.kgsu.tornadotest.ui

import javafx.scene.paint.Color
import javafx.scene.text.Font
import ru.kgsu.tornadotest.controllers.MainTableStudentController
import ru.kgsu.tornadotest.data.Discepline
import ru.kgsu.tornadotest.data.Student
import ru.kgsu.tornadotest.data.Task
import ru.kgsu.tornadotest.data.Teacher
import ru.kgsu.tornadotest.data.Mark
import tornadofx.*

class MainTableStudentView() : View() {
    val mainTableStudentController: MainTableStudentController by inject()
    val teacher = Teacher("T123", "1234", "Артур Котов")
    val disceplineOne = Discepline("Введение в паттерны проектирования", teacher, 3.6f);
    val disceplineTwo = Discepline("Объектно-ориентированное программирование", teacher, 3.7f);
    val disceplineThree = Discepline("Функциональное программирование", teacher, 4.7f);
    val listOfDiscepline = listOf(disceplineOne, disceplineTwo, disceplineThree)
    val student =
        Student("7894563Student2", "7896543", "Aнна Мишкина", 3002222, listOfDiscepline,3.6f, 3.7f, 3.8f)
    val student1 =
        Student("7894563Student2", "7896543", "Aнна Мишкина", 3002222, listOfDiscepline, 3.6f, 3.7f, 3.8f)
    val student2 =
        Student("7894563Student2", "7896543", "Паймон Вкотле", 3002222, listOfDiscepline, 4.3f, 4.4f, 3.5f)
    val student3 =
        Student("7894563Student2", "7896543", "Тортик Британский", 3002222, listOfDiscepline, 4.6f, 4.7f, 4.8f)
    val Marks = listOf(
        Mark(1, "${student1.fio}", student1.sMarkVPP, student1.sMarkOOP, student1.sMarkFP),
        Mark(2, "${student2.fio}", student2.sMarkVPP, student2.sMarkOOP, student2.sMarkFP),
        Mark(3, "${student3.fio}", student3.sMarkVPP, student3.sMarkOOP, student3.sMarkFP),
    ).asObservable()
    val taskOne = Task(
        10001,
        "Лабораторная работа",
        "Концольный калькулятор на языке Python",
        teacher,
        "Написать программу," +
                "\nкоторая выполняет над двумя вещественными числами одну из четырех арифметических операций: " +
                "\n(сложение, вычитание, умножение или деление). " +
                "\nПрограмма должна завершаться только по желанию пользователя."
    )
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
                tableview(Marks) {
                    readonlyColumn("ID", Mark::id)
                    readonlyColumn("Name", Mark::mName)
                    readonlyColumn("VPP", Mark::MarkVPP)
                    readonlyColumn("OOP", Mark::MarkOOP)
                    readonlyColumn("FP", Mark::MarkFP)
                    /*(button("Предметы").action {
                    mainTableStudentController.showStudentDisceplines()
                }
                button("Оценки").action {
                    mainTableStudentController.ShowStudentMarks()
                }*/
                }
            }
            tab("Авто Проверка") {
                isClosable = false
                borderpane {
                    center = APRView().root
                }

            }
        }

    }
}

