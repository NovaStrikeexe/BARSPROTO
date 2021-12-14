package ru.kgsu.tornadotest.controllers

import ru.kgsu.tornadotest.ui.MainTableStudentView
import ru.kgsu.tornadotest.ui.StudentDisceplinesView
import tornadofx.*

class StudentDisceplinesController : Controller() {
    fun goBack() {
        find(StudentDisceplinesView::class).replaceWith(
            MainTableStudentView::class,
            sizeToScene = true,
            centerOnScreen = true
        )
    }
}