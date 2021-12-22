package ru.kgsu.tornadotest.ui

import javafx.geometry.Pos
import javafx.stage.FileChooser
import ru.kgsu.tornadotest.controllers.TestController
import ru.kgsu.tornadotest.domain.apr.TestBlock
import tornadofx.*

/**
 * Скрин для Ученика - Автопроверка
 */
class APRView : View() {
    private val controller: TestController by inject()

    override val root = vbox {
        alignment = Pos.TOP_CENTER

        spacer { setMaxSize(.0, 10.0) }
        combobox<String> {
            valueProperty().addListener(controller.changeListener)

            items = controller.taskNamesObservableList
        }
        spacer { setMaxSize(.0, 10.0) }

        textarea(controller.taCodeTextProperty) {
            isEditable = false
        }

        spacer { setMaxSize(.0, 10.0) }
        hbox {
            spacer{setMaxSize(10.0, .0)}
            label(controller.okAnswersProperty)
            spacer()
            progressbar(controller.progressProperty)
            spacer{setMaxSize(10.0, .0)}
        }
        spacer { setMaxSize(.0, 10.0) }

        button("Загрузить файл с кодом и проверить") {
            disableProperty().bind(controller.buttonDisabledProperty)

            style {
                fontFamily = "Comic Sans MS"
                fontSize = 20.px
            }


            action {
                val file =
                    chooseFile(
                        "Выберите ваш файл Python",
                        arrayOf(FileChooser.ExtensionFilter("Python script", "*.py"))
                    ).getOrNull(0)
                
                file?.path?.let { path ->
                    controller.runTest(path, arrayListOf("5"), TestBlock(arrayListOf("5"), arrayListOf("25")))
                }
            }
        }
    }
}