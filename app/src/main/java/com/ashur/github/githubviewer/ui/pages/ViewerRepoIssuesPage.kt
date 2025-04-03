package com.ashur.github.githubviewer.ui.pages

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashur.github.githubviewer.R
import com.ashur.github.githubviewer.models.ViewerGithubIssue
import com.ashur.github.githubviewer.ui.pages.components.ViewerLoadingView
import com.ashur.github.githubviewer.ui.viewmodels.ViewerIssueViewModel
import com.ashur.github.githubviewer.ui.viewmodels.ViewerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewerRepoIssuesPage(
    viewModel: ViewerViewModel,
    owner: String,
    repo: String,
    navigateToIssuePage: () -> Unit,
    popback: () -> Unit
) {
    val issueViewModel: ViewerIssueViewModel = hiltViewModel()
    val context = LocalContext.current
    val issuesList = issueViewModel.repoIssues.collectAsState()
    LaunchedEffect(Unit) {
        issueViewModel.getIssues(owner, repo)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.repository_issues_title)) },
                navigationIcon = {
                    IconButton(onClick = { popback() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "back")
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (viewModel.loginState.value.isLoggedIn) {
                        navigateToIssuePage()
                    } else {
                        Toast.makeText(
                            context,
                            context.getString(R.string.repository_issues_require_logon),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                Icon(Icons.Default.Add, contentDescription = "add issue")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(issuesList.value.size) {
                IssueItem(issue = issuesList.value[it])
            }
        }
    }
    if (issueViewModel.loadingState.collectAsState().value) {
        ViewerLoadingView()
    }
}

@Composable
fun IssueItem(issue: ViewerGithubIssue) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = issue.title,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = issue.body ?: "",
                maxLines = 20,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.repository_issues_status, issue.state),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "#${issue.number}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
