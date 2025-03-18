package ru.tikhonovdo.selenidedemo

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogType

fun runProxyUseCase() {
    System.setProperty("webdriver.chrome.driver", "C:\\tmp\\chromedriver-win64\\chromedriver.exe");
    Configuration.browserBinary = "C:\\tmp\\chrome-win64\\chrome.exe"
    Configuration.webdriverLogsEnabled = true
    Configuration.browserCapabilities = ChromeOptions().apply {
        browserVersion = "134.0.6944.2"
        addArguments("--enable-logging")
        addArguments("--log-level=0")
        setCapability("goog:loggingPrefs", mapOf(LogType.PERFORMANCE to "ALL"))
    }
    Configuration.proxyEnabled = true

    Selenide.open("https://the-internet.herokuapp.com/")
    println(Selenide.screenshot("proxy-test-01"))

    printLogs(LogType.PERFORMANCE)

    Selenide.sleep(600_000)
}

fun printLogs(logType: String) {
    println("$logType logs:")
    Selenide.getWebDriverLogs(logType).forEach { println(it) }
    println()
}