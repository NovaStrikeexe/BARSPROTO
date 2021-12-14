package ru.kgsu.tornadotest.controllers

import ru.kgsu.tornadotest.ui.MainTableStudentView
import ru.kgsu.tornadotest.ui.StudentMarksView
import tornadofx.*

class StudentMarksController : Controller() {
    fun goBack() {
        find(StudentMarksView::class).replaceWith(
            MainTableStudentView::class,
            sizeToScene = true,
            centerOnScreen = true
        )
    }
}