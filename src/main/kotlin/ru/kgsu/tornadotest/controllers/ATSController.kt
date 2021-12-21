package ru.kgsu.tornadotest.controllers

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Alert
import javafx.scene.control.TextArea
import javafx.stage.FileChooser
import ru.kgsu.tornadotest.data.Task
import ru.kgsu.tornadotest.data.Teacher
import ru.kgsu.tornadotest.domain.apr.TestBlock
import ru.kgsu.tornadotest.ui.MainTableTeacherView
import ru.kgsu.tornadotest.ui.MarkScreen
import tornadofx.Controller
import tornadofx.alert
import tornadofx.chooseFile
import tornadofx.find
import java.io.File

class ATSController : Controller() {

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

    //private val typeOfFiles = arrayOf(FileChooser.ExtensionFilter("Document files (*.py)"))
    private val test = TestBlock(arrayListOf("1", "2", "3"), arrayListOf("1", "4", "9"))

    fun showTestList() {
        var text = "Входные параметры -> Выходные параметры для проверки\n"

        test.args.forEachIndexed { i, arg ->
            text += "$arg -> ${test.answers[i]}\n"
        }

        mainTextProperty.set(text)
    }

    //Зачем это? Почему все функции в объекте?
    companion object {
        var file = ""
        val mainTextProperty = SimpleStringProperty()
        val enableFileProperty = SimpleBooleanProperty(true)

        fun loadTest() {
            val files = chooseFile(
                "",
                arrayOf(FileChooser.ExtensionFilter("Document files (*.py)", "*.py"))
            )
        }

        fun loadCode() {
            val files = chooseFile(
                "",
                arrayOf(FileChooser.ExtensionFilter("Document files (*.py)", "*.py"))
            )
            file = files[0].toString()

            enableFileProperty.set(file == "")

            checkCode()
        }

        fun showTaskText(taskCodeField: TextArea) {
            taskCodeField.setVisible(true)
        }

        fun showStudetCode() {
            mainTextProperty.set(File(file).readText())
        }


        fun showCheckCode() {
            mainTextProperty.set(File("log.txt").readText())
        }

        fun checkCode() {
            var checkFileStart = File("check.bat")
            checkFileStart.createNewFile()
            checkFileStart.writeText("flake8 $file > log.txt")

            Runtime.getRuntime().exec("check.bat")

            showCheckCode()
        }

        fun showMarkSetter() {

            find(MainTableTeacherView::class).replaceWith(
                MarkScreen::class,
                sizeToScene = true,
                centerOnScreen = true
            )
        }

        fun showAutoTestResult() {

        }

        fun findTask(nmbOfTask: String) {
            if (nmbOfTask != "10001"){
                alert(
                    Alert.AlertType.ERROR,
                    "Ошибка",
                    "Задание с данным номером не найдено"
                )
            } else{
                alert(
                    Alert.AlertType.INFORMATION,
                    "Информация",
                    "Задание с данным номером найдено"
                )
            }
        }
    }
}