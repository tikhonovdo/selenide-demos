package ru.tikhonovdo.selenidedemo

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogType

fun selenoidConfig() {
    Configuration.remote = "http://localhost:4444/wd/hub" // url to selenoid
    Configuration.webdriverLogsEnabled = true
    Configuration.browserCapabilities = ChromeOptions().apply {
        browserVersion = "133.0"
        addArguments("--enable-logging")
        addArguments("--log-level=0")
        setCapability("goog:loggingPrefs", mapOf(LogType.PERFORMANCE to "ALL"))
    }
}

fun runSelenoidUseCase() {
    selenoidConfig()

    Selenide.open("https://aerokube.com/selenoid/")
    println(Selenide.screenshot("selenoid-use-case-01"))

    printWebDriverLogs(LogType.PERFORMANCE)
}

fun runSelenoidProxyUseCase() {
    selenoidConfig()
    Configuration.proxyEnabled = true

    Selenide.open("https://the-internet.herokuapp.com/")
    println(Selenide.screenshot("selenoid-proxy-use-case-01"))

    printWebDriverLogs(LogType.PERFORMANCE)
}
