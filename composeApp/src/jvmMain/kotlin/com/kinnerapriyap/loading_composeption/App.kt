package com.kinnerapriyap.loading_composeption

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.kinnerapriyap.loading_composeption.ui.DroidconBerlinTheme

@Composable
@Preview
fun App(size: DpSize) {
    DroidconBerlinTheme(windowSize = size, darkTheme = true) {
        AppNavHost()
    }
}