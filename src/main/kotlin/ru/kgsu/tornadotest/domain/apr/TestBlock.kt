package ru.kgsu.tornadotest.domain.apr

/**
 * Блок с тестами и проверками
 */
@Deprecated("Изменить структуру TestBlock(Test(name, args, answers))")
data class TestBlock(
    val args: ArrayList<String>,
    val answers: ArrayList<String>
)