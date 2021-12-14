package ru.kgsu.tornadotest.ui

import javafx.scene.control.TextArea
import javafx.scene.paint.Color
import javafx.scene.text.Font
import ru.kgsu.tornadotest.controllers.ATSControler
import ru.kgsu.tornadotest.controllers.MainTableStudentController
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
                        "Пользователь: \n${teacher.name}" +
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
                                //ATSControler.showTaskText(taskCodeField)
                                /**
                                 * Необходима доработка
                                 * */
                            }
                            item("Просмотр файла с кодом").action {
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
                            item("Показать резульатат статического тестирование:").action {
                                ATSControler.checkCode()
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
                    textarea(ATSControler.infoTestProperty) {
                        setMinSize(100.00, 100.00)
                    }
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

