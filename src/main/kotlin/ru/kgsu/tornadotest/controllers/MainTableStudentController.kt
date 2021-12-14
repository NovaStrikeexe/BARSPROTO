package ru.kgsu.tornadotest.controllers

import ru.kgsu.tornadotest.ui.MainTableStudentView
import ru.kgsu.tornadotest.ui.StudentDisceplinesView
import ru.kgsu.tornadotest.ui.StudentMarksView
import tornadofx.*

class MainTableStudentController : Controller() {
    fun showStudentDisceplines() {
        find(MainTableStudentView::class).replaceWith(
            StudentDisceplinesView::class,
            sizeToScene = true,
            centerOnScreen = true
        )
    }

    fun ShowStudentMarks() {
        find(MainTableStudentView::class).replaceWith(
            StudentMarksView::class,
            sizeToScene = true,
            centerOnScreen = true
        )
    }
}