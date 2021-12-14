package ru.kgsu.tornadotest.controllers

import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import ru.kgsu.tornadotest.data.Teacher
import ru.kgsu.tornadotest.ui.LoginScreen
import ru.kgsu.tornadotest.ui.MainTableStudentView
import ru.kgsu.tornadotest.ui.MainTableTeacherView
import tornadofx.Controller


class LoginController : Controller() {
    /**
     * Заполнения данных
     * */
    val teacherLogin: String = "T123"
    val teacherPWord: String = "1234"
    val studentLogin: String = "S123"
    val studentPWord: String = "1234"
    val teacher = Teacher("T123", "1234", "Артур", "Котов")

    //val student = Student("7894563Student2","7896543","Aнна","Мишкина",3002222)


    fun tryLogin(login: String?, password: String?) {
        if (login == teacherLogin && password == teacherPWord) {
            showMainTeacherScreen()
            return
        }
        if (login == studentLogin && password == studentPWord) {
            showMainStudentScreen()
            return
        } else {
            //showErrorMsg()
            showMainStudentScreen() //TODO Убрать
            return
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
        find(LoginScreen::class).replaceWith(
            MainTableStudentView::class,
            sizeToScene = true,
            centerOnScreen = true
        )
        //find(MainTableView::class).
    }

    private fun showMainTeacherScreen() {
        find(LoginScreen::class).replaceWith(
            MainTableTeacherView::class,
            sizeToScene = true,
            centerOnScreen = true
        )
    }
}

