package ru.kgsu.tornadotest.ui

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Alert
import ru.kgsu.tornadotest.controllers.LoginController
import tornadofx.*

class LoginScreen : View() {
    val loginController: LoginController by inject()
    val login = SimpleStringProperty(this, "login", config.string("username"))
    val password = SimpleStringProperty(this, "password", config.string("password"))

    override val root = form {
        prefWidth = 800.0
        prefHeight = 600.0
        fieldset("Авторизация") {
            field("Логин:") { textfield(login) }
            field("Пароль:") { passwordfield(password) }
            buttonbar {
                button("Войти").action {
                    loginController.tryLogin(login.value, password.value)
                }
                button("Забыл пароль") {
                    action {
                        alert(
                            Alert.AlertType.INFORMATION,
                            "Внимание",
                            "В данном случаее рекомендуем обратиться к админстратару",
                            owner = currentWindow
                        )
                    }
                }
            }
        }
    }
}