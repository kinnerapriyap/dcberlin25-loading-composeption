package com.kinnerapriyap.loading_composeption

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "loading_composeption",
    ) {
        App()
    }
}