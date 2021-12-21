package ru.kgsu.tornadotest.ui

import javafx.geometry.Pos
import javafx.scene.control.Alert
import javafx.stage.FileChooser
import ru.kgsu.tornadotest.controllers.TaskMarkSetter
import ru.kgsu.tornadotest.controllers.TestController
import ru.kgsu.tornadotest.data.*
import ru.kgsu.tornadotest.domain.apr.TestBlock
import tornadofx.*


class APRView : View() {
    private val controller: TestController by inject()
    var tryOfTask: Int = 5
    val teacher = Teacher("T123", "1234", "Артур Котов")
    val disceplineOne = Discepline("Введение в паттерны проектирования", teacher, 3.6f);
    val disceplineTwo = Discepline("Объектно-ориентированное программирование", teacher, 3.7f);
    val disceplineThree = Discepline("Функциональное программирование", teacher, 4.7f);
    val listOfDiscepline = listOf(disceplineOne, disceplineTwo, disceplineThree)
    val student =
        Student("7894563Student2", "7896543", "Aнна Мишкина", 3002222, listOfDiscepline)
    var studentTaskTry = StudentTaskTry(student, tryOfTask)
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
    var taskMark = TaskMark(taskOne, teacher, studentTaskTry, 4.38f)
    override val root = vbox {
        alignment = Pos.TOP_CENTER

        val taCode = textarea(controller.taCodeTextProperty) {
            isEditable = false
        }

        spacer { setMaxSize(.0, 10.0) }
        hbox {
            label(controller.okAnswersProperty)
            spacer()
            progressbar(controller.progressProperty)
        }
        spacer { setMaxSize(.0, 10.0) }

        val btnUploadCode = button("Загрузить файл с кодом") {
            action {
                if (tryOfTask == 0) {
                    alert(
                        Alert.AlertType.INFORMATION,
                        "Внимание",
                        "Количество ваших попыток сдачи данно задачи изчерпано,\n все дальнейшие вопросы обсуждать с преподавателем",
                        owner = currentWindow
                    )

                } else {
                    val file = chooseFile(
                        "Выберите ваш файл Python",
                        arrayOf(FileChooser.ExtensionFilter("Python script", "*.py"))
                    ).getOrNull(0)
                    file?.path?.let { path ->
                        controller.runTest(
                            path,
                            arrayListOf("5"),
                            TestBlock(arrayListOf("5"), arrayListOf("25"))
                        )

                    }
                }
                tryOfTask = -1
            }
        }
    }
}