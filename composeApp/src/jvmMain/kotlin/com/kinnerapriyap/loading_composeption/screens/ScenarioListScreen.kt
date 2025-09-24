package com.kinnerapriyap.loading_composeption.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

enum class Scenario(val text: String) {
    NETWORK_REQUEST("The Network Request"),
    LAZY_LIST("The Lazy List"),
    SKELETON("The Skeleton"),
    STATE_TRANSITION("The State Transition"),
    EXTRA("The Extras")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScenarioListScreen(
    onBack: () -> Unit,
    onScenarioSelected: (Scenario) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        }
    ) { inner ->
        ScenarioListContent(inner, Scenario.entries.toList(), onScenarioSelected)
    }
}

@Composable
private fun ScenarioListContent(
    innerPadding: PaddingValues,
    scenarios: List<Scenario>,
    onScenarioSelected: (Scenario) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Scenarios",
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(32.dp))
        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(scenarios) { scenario ->
                ListItem(
                    headlineContent = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = scenario.text,
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center
                        )
                    },
                    modifier = Modifier.wrapContentSize().clickable { onScenarioSelected(scenario) }
                )
            }
        }
    }
}

