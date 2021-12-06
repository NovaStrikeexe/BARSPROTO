package ru.kgsu.tornadotest.data

import java.time.LocalDate

class Teacher(login: String, pword: String, name: String, sName: String) : User(
    login, pword, name,
    sName
) {

}
