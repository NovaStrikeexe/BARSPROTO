package ru.kgsu.tornadotest.controllers


import javafx.stage.FileChooser
import ru.kgsu.tornadotest.data.Task
import ru.kgsu.tornadotest.data.Teacher

class ATSControler {

    val teacher = Teacher("T123", "1234", "Артур", "Котов")
    val taskOne = Task(
        10001,
        "Концольный калькулятор на языке Python 3.7",
        teacher,
        "Написать программу, " +
                "которая выполняет над двумя вещественными числами одну из четырех арифметических операций: " +
                "(сложение, вычитание, умножение или деление). " +
                "Программа должна завершаться только по желанию пользователя."
    )
    private val typeOfFiles = arrayOf(FileChooser.ExtensionFilter("Document files (*.py)"))

    companion object {
        //Так это доделать мне (Trigger)
        fun loadTest() {
            val fileChooser = FileChooser();
            val file = fileChooser.showOpenDialog(null)
        }
        //Так это доделать мне (Trigger)
        fun loadCode() {
            val fileChooser = FileChooser();
            val file = fileChooser.showOpenDialog(null)
        }
        /***
         * Экз это для тебя задачка
         */
        fun launchTest() {}
        //Так это доделать мне (Trigger)
        fun showTaskText() {
        }

        /***
         * Мега, это тебе задачка
         */
        fun showStudetCode() {

        }
        //Пока беру себе
        fun showTestList() {

        }
    }
}