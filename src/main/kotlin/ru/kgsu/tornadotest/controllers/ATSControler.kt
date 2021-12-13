package ru.kgsu.tornadotest.controllers


import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.TextArea
import javafx.stage.FileChooser
import ru.kgsu.tornadotest.data.Task
import ru.kgsu.tornadotest.data.Teacher
import tornadofx.chooseFile
import java.io.File

class ATSControler {

    val teacher = Teacher("T123", "1234", "Артур", "Котов")
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
        val infoTestProperty = SimpleStringProperty("Задание номер:10001\nНазавние задачи:Концольный калькулятор на языке Python\n" +
                "Автор задачи: Артур Котов\nТекст задачи: Написать программу,\n" +
                "которая выполняет над двумя вещественными числами одну из четырех арифметических операций: \n" +
                "(сложение, вычитание, умножение или деление). \n" +
                "Программа должна завершаться только по желанию пользователя.")

        //Так это доделать мне (Trigger)
        fun loadTest() {
            val files = chooseFile("",
                arrayOf(FileChooser.ExtensionFilter("Document files (*.py)", "*.py")))
        }

        //Так это доделать мне (Trigger)
        fun loadCode() {
            val files = chooseFile("",
                arrayOf(FileChooser.ExtensionFilter("Document files (*.py)", "*.py")))
            file = files[0].toString()

            checkCode()
        }

        /***
         * Экз это для тебя задачка
         */
        fun launchTest() {}

        //Так это доделать мне (Trigger)
        fun showTaskText(taskCodeField: TextArea) {
            taskCodeField.setVisible(true)
        }

        /***
         * Мега, это тебе задачка
         */
        fun showStudetCode() {
            infoTestProperty.set(File(file).readText())
        }


        private fun showCheckCode() {
            infoTestProperty.set(File("log.txt").readText())
        }

        private fun checkCode() {
            var checkFileStart = File("check.bat")
            checkFileStart.createNewFile()
            checkFileStart.writeText("flake8 $file > log.txt")

            Runtime.getRuntime().exec("check.bat")

            showCheckCode()
        }

        //Пока беру себе
        fun showTestList() {
        }
    }
}