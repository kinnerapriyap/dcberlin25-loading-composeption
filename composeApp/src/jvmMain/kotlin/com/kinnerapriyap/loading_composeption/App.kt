package com.kinnerapriyap.loading_composeption

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.kinnerapriyap.loading_composeption.ui.DemoTheme

@Composable
@Preview
fun App() {
    DemoTheme {
        AppNavHost()
    }
}