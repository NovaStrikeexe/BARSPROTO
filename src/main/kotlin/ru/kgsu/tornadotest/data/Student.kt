package ru.kgsu.tornadotest.data

import java.time.LocalDate

class Student(
    login: String,
    pWord: String,
    fio: String,
    var numberOfGrp: Long,
    var dListName: List<Discepline>,
    val sMarkVPP: Float,
    val sMarkOOP: Float,
    val sMarkFP: Float,
)
: User(
    login, pWord, fio
) {
}