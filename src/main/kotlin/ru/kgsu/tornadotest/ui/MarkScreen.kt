package ru.kgsu.tornadotest.ui

import javafx.scene.control.ToggleGroup
import ru.kgsu.tornadotest.controllers.MarkScreenControler
import tornadofx.*

class MarkScreen : View() {
    override val root = form {
        val toggleGroup = ToggleGroup()
        var codeClean: String = ""
        var codeFun: String = ""
        var codeFlex: String = ""
        var codeTestPass: String = ""
        var isCodeCopy: Boolean = false
        vbox {
            fieldset("Итог") {
                field("Чистота кода:") {
                    textfield(codeClean)
                }
                field("Функциональнось:") {
                    textfield(codeFun)
                }
                field("Гибкость:") {
                    textfield(codeFlex)
                }
                field("Кол-во пройденых тестов:") {
                    textfield(codeTestPass)
                }
                label("Подозрение в плагите")
                radiobutton("Да", toggleGroup)
                radiobutton("Нет", toggleGroup)
                button("Выставить оценку").action {
                    MarkScreenControler.setMark(codeClean,codeFun,codeFlex,codeTestPass,isCodeCopy)
                }
            }
        }
    }
}