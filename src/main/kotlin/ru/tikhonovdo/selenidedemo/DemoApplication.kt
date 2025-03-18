package ru.tikhonovdo.selenidedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication {
    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            runApplication<DemoApplication>(*args)
            runProxyUseCase()
        }
    }
}