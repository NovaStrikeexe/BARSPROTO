package ru.kgsu.tornadotest.ui

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
        "Концольный калькулятор на языке Python 3.7",
        teacher,
        "Написать программу, " +
                "которая выполняет над двумя вещественными числами одну из четырех арифметических операций: " +
                "(сложение, вычитание, умножение или деление). " +
                "Программа должна завершаться только по желанию пользователя."
    )
    override val root = tabpane {
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
        tab("КЕС") {//Сюда чето запихть чтобы было// }

            tab("АПР") {
                borderpane {
                    left = vbox {
                        button("Загрузить файл с тестом").action {
                            ATSControler.loadTest()
                        }
                        button("Загрузить файл с кодом").action {
                            ATSControler.loadCode()
                        }
                        button("Запуск тестов").action {
                            ATSControler.launchTest()
                        }
                    }
                    right = hbox {
                        //TODO Пофиксить проблему с отображение данных из taskOne
                        textarea("Задание номер:10001\n") {
                        }

                    }
                    top = hbox {
                        textflow {
                            text(
                                "Пользователь: \n${teacher.name}\n" +
                                        "${teacher.sName}"
                            ) {
                                fill = Color.PURPLE
                                font = Font(20.0)
                            }
                        }
                        menubar {
                            menu("Файл") {
                                item("Просмотр условия задачи").action {
                                    ATSControler.showTaskText()
                                }
                                item("Просмотр кода").action {
                                    ATSControler.showStudetCode()
                                }
                                item("Просмотр тестового набора").action {
                                    ATSControler.showTestList()
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
