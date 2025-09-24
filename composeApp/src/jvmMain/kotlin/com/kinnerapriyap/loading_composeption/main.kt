package com.kinnerapriyap.loading_composeption

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    val state = rememberWindowState(placement = WindowPlacement.Maximized)
    Window(
        onCloseRequest = ::exitApplication,
        state = state,
        title = "Loading... Please Wait",
        resizable = false,
    ) {
        App(state.size)
    }
}