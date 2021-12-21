package ru.kgsu.tornadotest.ui

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.control.Alert
import javafx.scene.control.Tab
import javafx.scene.control.TextArea
import javafx.scene.paint.Color
import javafx.scene.text.Font
import ru.kgsu.tornadotest.controllers.ATSControler
import ru.kgsu.tornadotest.controllers.MainTableStudentController
import ru.kgsu.tornadotest.data.Task
import ru.kgsu.tornadotest.data.Teacher
import tornadofx.*

class MainTableTeacherView : View() {
    val teacher = Teacher("T123", "1234", "Артур Котов")
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
        var taskCodeField: TextArea by singleAssign()
        prefWidth = 800.0
        prefHeight = 600.0
        tab("БРС") {
            isClosable = false
            vbox {
                textflow {
                    text("Пользователь:${teacher.fio}") {
                        fill = Color.PURPLE
                        font = Font(20.0)
                    }
                    separator {

                    }
                }
                button("Button 1")
                button("Button 2")
            }
        }
        tab("КЕС") {
            isClosable = false//Сюда чето запихть чтобы было//
        }
        tab("АПР") {
            isClosable = false
            borderpane {
                left = vbox {
                    spacing = 7.0
                    paddingLeft = 5
                    paddingRight = 5

                    textflow {
                        text(
                            "Пользователь: ${teacher.fio}"
                        ) {
                            fill = Color.PURPLE
                            font = Font(20.0)
                        }

                    }
                    separator {
                    }
                    button("Просмотр условия задачи").action {
                        alert(
                            Alert.AlertType.INFORMATION,
                            "Условие задачи: ${taskOne.numberOfTask}",
                            "${taskOne.textOfTask}",
                            owner = currentWindow
                        )
                    }
                    button("Загрузить файл с кодом").action {
                        ATSControler.loadCode()
                    }
                    button("Просмотр файла с кодом") {
                        disableWhen {
                            ATSControler.enableFileProperty
                        }

                        action {
                            ATSControler.showStudetCode()
                        }
                    }
                    button("Загрузить файл с тестом").action {
                        ATSControler.loadTest()
                    }
                    button("Просмотр тестового набора").action {
                        ATSControler.showTestList()
                    }
                    button("Показать резульатат статического тестирование") {
                        disableWhen {
                            ATSControler.enableFileProperty
                        }

                        action {
                            ATSControler.checkCode()
                        }
                    }
                    button("Поставить оценку").action {
                        ATSControler.showMarkSetter()
                    }
                }
                center = pane {
                    setMinSize(500.0, 500.0)
                    setMaxSize(1000.0, 1000.0)
                    textarea(ATSControler.infoTestProperty) {
                        setMinSize(500.0, 500.0)
                        setMaxSize(1000.0, 1000.0)
                        isEditable = false

                    }
                }
            }

        }

    }
}

