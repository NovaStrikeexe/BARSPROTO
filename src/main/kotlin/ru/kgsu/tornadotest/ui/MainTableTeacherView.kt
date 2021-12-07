package ru.kgsu.tornadotest.ui

import javafx.scene.Parent
import javafx.scene.control.Alert
import javafx.scene.paint.Color
import javafx.scene.text.Font
import ru.kgsu.tornadotest.data.Teacher
import tornadofx.*

class MainTableTeacherView : View() {
    val teacher = Teacher("T123", "1234", "Артур", "Котов")
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
                        button("Загрузить файл с тестом")
                        button("Загрузить файл с кодом")
                        button("Запуск тестов")
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
                    }
                }
            }

        }
    }
}
