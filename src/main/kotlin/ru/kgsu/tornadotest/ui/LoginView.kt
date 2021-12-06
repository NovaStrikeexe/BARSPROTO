package ru.kgsu.tornadotest.ui

import javafx.geometry.Pos
import javafx.scene.control.Alert
import tornadofx.*

class LoginView : View() {
    override val root = vbox {
        hbox {
            alignment = Pos.CENTER
            label("Логин")
            textfield()
        }
        hbox {
            alignment = Pos.CENTER
            label("Пароль")
            passwordfield() {
                requestFocus()
            }
        }
        vbox {
            alignment = Pos.CENTER
            button("Войти") {
                action {
                    replaceWith<MainTableView>()
                    useMaxWidth = true
                }
            }
        }
        vbox {
            alignment = Pos.CENTER

        }
    }
}
