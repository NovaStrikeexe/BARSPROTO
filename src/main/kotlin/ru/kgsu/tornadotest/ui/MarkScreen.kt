package ru.kgsu.tornadotest.ui

import javafx.scene.control.Alert
import javafx.scene.control.TextField
import javafx.scene.control.ToggleGroup
import ru.kgsu.tornadotest.controllers.MarkScreenControler
import tornadofx.*

class MarkScreen : View() {
    override val root = form {
        var codeClean: TextField by singleAssign()
        var codeFun: TextField by singleAssign()
        var codeFlex: TextField by singleAssign()
        var codeTestPass: TextField by singleAssign()
        var isCodeCopy: Boolean = false
        val toggleGroup = ToggleGroup()
        vbox {

            //По хорошему это все нужно делать с базой
            //Но хей мы как обычно
            label("Итог по заданию: 10001 \nСтудента(тки) \'Aнна Мишкина\'\n по дисцеплине:\n \' Вводный курс по прогрмированию \' ")
            label("Чистота кода:")
            codeClean = textfield()
            label("Функциональнось:")
            codeFun = textfield()
            label("Гибкость:")
            codeFlex = textfield()
            label("Кол-во пройденых тестов:")
            codeTestPass = textfield()
            label("Подозрение в плагите")
            radiobutton("Да", toggleGroup).action { isCodeCopy = true }
            radiobutton("Нет", toggleGroup).action { isCodeCopy = false }
            button("Выставить оценку").action {
                alert(
                    Alert.AlertType.INFORMATION,
                    "Внимание",
                    "Текущий балл студента(тки): 'Aнна Мишкина'\n" +
                            " по дисцеплине: " + getMark(codeClean, codeFun, codeFlex, codeTestPass, isCodeCopy) + "\n" +
                            " ' Вводный курс по прогрмированию ' был изменен.",
                    owner = currentWindow
                )

            }
            button("Вернуться на главный экран").action {
                MarkScreenControler.backToMainView()
            }
        }
    }

    private fun getMark(
        codeClean: TextField,
        codeFun: TextField,
        codeFlex: TextField,
        codeTestPass: TextField,
        isCodeCopy: Boolean
    ): Float {
        return MarkScreenControler.setMark(
            codeClean.text.toFloat(),
            codeFun.text.toFloat(),
            codeFlex.text.toFloat(),
            codeTestPass.text.toFloat(),
            isCodeCopy
        )
    }
}
