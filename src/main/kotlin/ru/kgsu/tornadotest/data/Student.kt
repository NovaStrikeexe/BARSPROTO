package ru.kgsu.tornadotest.data

import java.time.LocalDate

class Student(
    login: String,
    pWord: String,
    name: String,
    sName: String,
    var numberOfGrp: Long,
    var dListName: List<Discepline>,
    val sMarkVPP: Float,
    val sMarkOOP: Float)
: User(
    login, pWord, name,
    sName
) {
}