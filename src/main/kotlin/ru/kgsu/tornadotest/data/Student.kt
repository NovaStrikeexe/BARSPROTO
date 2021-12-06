package ru.kgsu.tornadotest.data

import java.time.LocalDate

class Student(
    login: String,
    pWord: String,
    name: String,
    sName: String,
    var numberOfGrp: Long,
    var dListName: List<Discepline>)
: User(
    login, pWord, name,
    sName
) {
}