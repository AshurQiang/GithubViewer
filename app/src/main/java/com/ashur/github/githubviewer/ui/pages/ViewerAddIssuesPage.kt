package com.ashur.github.githubviewer.ui.pages

import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.ashur.github.githubviewer.R
import com.ashur.github.githubviewer.constants.ViewerGithubOAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewerAddIssuesPage(
    popback: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.repository_issues_add_title)) },
                navigationIcon = {
                    IconButton(onClick = { popback() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "back")
                    }
                })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = { },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.repository_issues_input_tittle)) },
                placeholder = { Text(stringResource(R.string.repository_issues_input_tittle_hint)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    imeAction = ImeAction.Next
                )
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                label = { Text(stringResource(R.string.repository_issues_input_description)) },
                placeholder = { Text(stringResource(R.string.repository_issues_input_description_hint)) },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    imeAction = ImeAction.Default
                )
            )

            Button(
                onClick = {
                    popback()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                androidx.compose.material.Text(stringResource(R.string.repository_issues_add_submit))
            }
        }
    }
}
