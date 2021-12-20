package ru.kgsu.tornadotest.controllers

import ru.kgsu.tornadotest.ui.MainTableTeacherView
import tornadofx.*
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Tab
import javafx.scene.control.TextArea
import javafx.stage.FileChooser
import ru.kgsu.tornadotest.data.Task
import ru.kgsu.tornadotest.data.Teacher
import ru.kgsu.tornadotest.ui.MarkScreen
import tornadofx.chooseFile
import java.io.File

class ATSControler {

    val teacher = Teacher("T123", "1234", "Артур Котов")
    val taskOne = Task(
        10001,
        "Концольный калькулятор на языке Python",
        teacher,
        "Написать программу," +
                "\nкоторая выполняет над двумя вещественными числами одну из четырех арифметических операций: " +
                "\n(сложение, вычитание, умножение или деление). " +
                "\nПрограмма должна завершаться только по желанию пользователя."
    )
    private val typeOfFiles = arrayOf(FileChooser.ExtensionFilter("Document files (*.py)"))

    companion object {
        var file = ""
        val infoTestProperty = SimpleStringProperty()

        /***
         * Мега выполнил свои задачи. Лекс тут нужен твой допил
         */
        fun loadTest() {
            val files = chooseFile(
                "",
                arrayOf(FileChooser.ExtensionFilter("Document files (*.py)", "*.py"))
            )
        }

        /***
         * Мега выполнил свои задачи
         */
        fun loadCode() {
            val files = chooseFile(
                "",
                arrayOf(FileChooser.ExtensionFilter("Document files (*.py)", "*.py"))
            )
            file = files[0].toString()

            checkCode()
        }

        /***
         * Экз это для тебя задачка, на крайний случай нужно воткнуть заглушку
         */
        fun launchTest() {

        }

        /***
         * Мега выполнил свои задачи
         */
        fun showTaskText(taskCodeField: TextArea) {
            taskCodeField.setVisible(true)
        }

        /***
         * Мега выполнил свои задачи
         */
        fun showStudetCode() {
            infoTestProperty.set(File(file).readText())
        }


        fun showCheckCode() {
            infoTestProperty.set(File("log.txt").readText())
        }

        fun checkCode() {
            var checkFileStart = File("check.bat")
            checkFileStart.createNewFile()
            checkFileStart.writeText("flake8 $file > log.txt")

            Runtime.getRuntime().exec("check.bat")

            showCheckCode()
        }

        /***
         * Экз это для тебя задачка
         */
        fun showTestList() {

        }

        fun showMarkSetter() {

            find(MainTableTeacherView::class).replaceWith(
                MarkScreen::class,
                sizeToScene = true,
                centerOnScreen = true
            )
        }

        fun showAutoTestResult() {
            TODO("Not yet implemented")
        }
    }
}