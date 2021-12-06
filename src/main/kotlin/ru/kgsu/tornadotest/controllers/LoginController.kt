package ru.kgsu.tornadotest.controllers

import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.ButtonType
import ru.kgsu.tornadotest.data.Discepline
import ru.kgsu.tornadotest.data.Student
import ru.kgsu.tornadotest.data.Teacher
import ru.kgsu.tornadotest.ui.LoginScreen
import tornadofx.*


class LoginController : Controller() {
    /**
     * Заполнения данных
     * */
    val teacherLogin: String = "Teacher1"
    val teacherPWord: String = "1234567"
    val studentLogin: String = "Student2"
    val studentPWord: String = "7896543"
    val teacher = Teacher("123456Teacher1", "1234567", "Артур", "Котов")

    //val student = Student("7894563Student2","7896543","Aнна","Мишкина",3002222)
    val disceplineOne = Discepline("Введение в паттерны проектирования", teacher,3.6f);
    val disceplineTwo = Discepline("Объектно-ориентированное программирование", teacher,3.7f);
    val listOfDiscepline = listOf(disceplineOne, disceplineTwo)
    val student =
        Student("7894563Student2", "7896543", "Aнна", "Мишкина", 3002222, listOfDiscepline)

    fun tryLogin(login: String, password: String) {
        if (login == teacherLogin && password == teacherPWord) {
            showMainTeacherScreen()
        }
        if (login ==  studentLogin && password == studentPWord) {
            showMainStudentScreen()
        }

        else{
            showErrorMsg()
        }
    }

    private fun showErrorMsg() {
        val alert = Alert(AlertType.WARNING)
        alert.title = "Ошибка"
        alert.headerText = "Ошибка авторизации"
        alert.contentText = "Проверьте ваш логин и пароль."
        alert.showAndWait()
    }

    private fun showMainStudentScreen() {
        println("ITSWORKS")
    }

    private fun showMainTeacherScreen() {
        println("ITSWORKS")
    }
}

