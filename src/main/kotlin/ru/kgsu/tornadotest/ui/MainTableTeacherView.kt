package ru.kgsu.tornadotest.ui

import javafx.geometry.Pos
import javafx.scene.control.TextArea
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.Font
import ru.kgsu.tornadotest.controllers.ATSControler
import ru.kgsu.tornadotest.data.Task
import ru.kgsu.tornadotest.data.Teacher
import tornadofx.*

class MainTableTeacherView : View() {
    val teacher = Teacher("T123", "1234", "Артур", "Котов")
    val taskOne = Task(
        10001,
        "Концольный калькулятор на языке Python",
        teacher,
        "Написать программу," +
                "\nкоторая выполняет над двумя вещественными числами одну из четырех арифметических операций: " +
                "\n(сложение, вычитание, умножение или деление). " +
                "\nПрограмма должна завершаться только по желанию пользователя."
    )
    override val root = tabpane {
        var taskCodeField: TextArea by singleAssign()
        prefWidth = 800.0
        prefHeight = 600.0
        tab("БРС") {
            vbox {
                textflow {
                    text(
                        "Пользователь: \n${teacher.name}\n" +
                                "${teacher.sName}"
                    ) {
                        fill = Color.PURPLE
                        font = Font(20.0)
                    }
                }
                button("Button 1")
                button("Button 2")
            }
        }
        tab("КЕС") {//Сюда чето запихть чтобы было//
        }
        tab("АПР") {
            borderpane {
                left = vbox {
                    menubar {
                        menu("Меню") {
                            item("Просмотр условия задачи").action {
                                ATSControler.showTaskText(taskCodeField)
                            }
                            item("Просмотр кода").action {
                                ATSControler.showStudetCode()
                            }
                            item("Просмотр тестового набора").action {
                                ATSControler.showTestList()
                            }
                            item("Загрузить файл с тестом").action {
                                ATSControler.loadTest()
                            }
                            item("Загрузить файл с кодом").action {
                                ATSControler.loadCode()
                            }
                            item("Запуск тестов").action {
                                ATSControler.launchTest()
                            }
                            item("Поставить оценку").action {
                                ATSControler.showMarkSetter()
                            }

                        }
                    }
                }
                right = hbox {
                    //taskCodeField.setVisible(false)
                    //taskCodeField =
                    textarea(
                        "Задание номер:${taskOne.numberOfTask}\nНазавние задачи:${taskOne.nameOfTask}\n" +
                                "Автор задачи: ${taskOne.authorOfTask.name} ${taskOne.authorOfTask.sName}\nТекст задачи: ${taskOne.textOfTask}"
                    ) {
                    }
                    //val numbers = (1..10).toList()
                    //Дата грид вью
                    /***datagrid(numbers) {
                    cellHeight = 75.0
                    cellWidth = 75.0

                    multiSelect = true

                    cellCache {
                    stackpane {
                    circle(radius = 25.0) {
                    fill = Color.FORESTGREEN
                    }
                    label(it.toString())
                    }
                    }
                    }*/

                }
                top = hbox {
                    textflow {
                        text(
                            "Пользователь: \n${teacher.name} " +
                                    "${teacher.sName}"
                        ) {
                            fill = Color.PURPLE
                            font = Font(20.0)
                        }
                    }

                }
            }
        }

    }
}

