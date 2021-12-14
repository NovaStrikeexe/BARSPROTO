package ru.kgsu.tornadotest.controllers

import javafx.scene.control.TextField
import ru.kgsu.tornadotest.ui.MainTableTeacherView
import ru.kgsu.tornadotest.ui.MarkScreen
import tornadofx.*

class MarkScreenControler : Controller() {
    companion object {
        fun setMark(
            codeClean: Float,
            codeFun: Float,
            codeFlex: Float,
            codeTestPass: Float,
            codeCopy: Boolean
        ): Float {
            if (codeCopy) {
                return ((codeClean + codeFun + codeFlex + codeTestPass) / 8)
            } else {
                return ((codeClean + codeFun + codeFlex + codeTestPass) / 4)
            }
        }

        fun backToMainView() {
            find(MarkScreen::class).replaceWith(
                MainTableTeacherView::class,
                sizeToScene = true,
                centerOnScreen = true
            )
        }

    }

}
