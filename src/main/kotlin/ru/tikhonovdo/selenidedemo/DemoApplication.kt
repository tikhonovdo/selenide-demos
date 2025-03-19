package ru.tikhonovdo.selenidedemo

import com.codeborne.selenide.Selenide
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication {
    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            runApplication<DemoApplication>(*args)
//            runProxyUseCase()
            runSelenoidUseCase()
//            runSelenoidProxyUseCase()
        }
    }
}

fun printWebDriverLogs(logType: String) {
    println("$logType logs:")
    Selenide.getWebDriverLogs(logType).forEach { println(it) }
    println()
}