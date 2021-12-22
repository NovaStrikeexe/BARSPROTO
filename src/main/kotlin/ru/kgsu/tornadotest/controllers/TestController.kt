package ru.kgsu.tornadotest.controllers

import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import ru.kgsu.tornadotest.domain.apr.ResultTest
import ru.kgsu.tornadotest.domain.apr.TestBlock
import tornadofx.ChangeListener
import tornadofx.Controller
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

class TestController : Controller() {
    val taCodeTextProperty = SimpleStringProperty("")
    val progressProperty = SimpleFloatProperty(0.0f)
    val okAnswersProperty = SimpleStringProperty("")
    val taskNamesObservableList = FXCollections.observableArrayList("Задание №1 - Возведение в квадрат")

    val buttonDisabledProperty = SimpleBooleanProperty(true)
    val comboboxValueProperty = SimpleStringProperty("")
    val changeListener = ChangeListener<String>{ observableValue: ObservableValue<out String>?, s: String?, s1: String? ->
        s1?.let {
            buttonDisabledProperty.set(false)
        }
    }

    private fun test(path: String, args: List<String>): ResultTest {
        val argsString = args.joinToString { "$it " }.trim()
        val pyProcess = Runtime.getRuntime().exec("python $path $argsString")

        val stdInput = BufferedReader(InputStreamReader(pyProcess.inputStream))
        val stdError = BufferedReader(InputStreamReader(pyProcess.errorStream))

        var outError: String? = null
        val outAnswers: ArrayList<String> = arrayListOf()

        var s = stdInput.readLine()
        while (s != null) {
            outAnswers.add(s)

            println("Answ $s")
            s = stdInput.readLine()
        }

        var e = stdError.readLine()
        e?.let {
            outError = "Err: "
            while (e != null) {
                outError += "$e+\\n"

                println(e)
                e = stdError.readLine()
            }
        }

        return ResultTest(outError, outAnswers)
    }

    fun runTest(path: String, args: List<String>, testBlock: TestBlock) {
        taCodeTextProperty.set(File(path).readText())

        val result = test(path, args)
        val okAnswersNum = checkResult(result, testBlock)
        okAnswersProperty.value = "Успешных тестов: $okAnswersNum"
        progressProperty.value = okAnswersNum.toFloat() / testBlock.answers.size
    }

    private fun checkResult(result: ResultTest, testBlock: TestBlock): Int {
        if (result.error != null) {
            // TODO Обработать ошибки
            println("Err TestController::checkResult >>> ${result.error}")
        }

        val usrAnswers = result.answers
        var numOkAnswers = 0

        testBlock.answers.forEachIndexed { ind, mustBeStr ->
            if (usrAnswers.getOrNull(ind) == mustBeStr) {
                numOkAnswers++
            }
        }

        return numOkAnswers
    }
}