package ru.kgsu.tornadotest.controllers


import javafx.stage.FileChooser

class ATSControler {

    private val typeOfFiles = arrayOf(FileChooser.ExtensionFilter("Document files (*.py)"))

    companion object {
        fun loadTest() {
            val fileChooser = FileChooser();
            val file = fileChooser.showOpenDialog(null)
        }

        fun loadCode() {
            val fileChooser = FileChooser();
            val file = fileChooser.showOpenDialog(null)
        }

        fun launchTest() {}
    }
}