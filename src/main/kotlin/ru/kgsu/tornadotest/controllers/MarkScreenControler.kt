package ru.kgsu.tornadotest.controllers

import tornadofx.*

class MarkScreenControler : Controller() {
    companion object {
        fun setMark(
            codeClean: String,
            codeFun: String,
            codeFlex: String,
            codeTestPass: String,
            codeCopy: Boolean
        ): Int {
            var intCodeClean = codeClean.toInt()
            var intCodeFun = codeFun.toInt()
            var intCodeFlex = codeFlex.toInt()
            var intCodeTestPass = codeTestPass.toInt()
            if(codeCopy){
                return ((intCodeClean + intCodeFun + intCodeFlex + intCodeTestPass) / 8)
            }
            else{
                return ((intCodeClean + intCodeFun + intCodeFlex + intCodeTestPass) / 4)
            }
        }

    }

}
