package com.ashur.github.githubviewer.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ashur.github.githubviewer.R
import com.ashur.github.githubviewer.constants.ViewerUIConfiguration
import com.ashur.github.githubviewer.models.GitHubSearchModel
import com.ashur.github.githubviewer.ui.pages.components.ViewerDropDownMenu
import com.ashur.github.githubviewer.ui.pages.components.ViewerHomePageSearchItem
import com.ashur.github.githubviewer.ui.theme.title
import com.ashur.github.githubviewer.ui.viewmodels.ViewerViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ViewerHomePage(
    viewModel: ViewerViewModel,
    onItemClicked: (item: GitHubSearchModel) -> Unit
) {

    val lazyListState = rememberLazyListState()
    val searchResult = viewModel.searchResult.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.searchRepositories(forceRefresh = false)
        viewModel.searchResult.collectLatest {
            lazyListState.scrollToItem(0)
        }
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row(
            Modifier.background(Color.Gray)
        ) {
            ViewerDropDownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                ViewerUIConfiguration.LANGUAGE_DROP_DOWN
            ) {
                viewModel.searchRepositories(language = it)
            }
            ViewerDropDownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), ViewerUIConfiguration.SORT_DROP_DOWN
            ) {
                viewModel.searchRepositories(sort = it)
            }
        }
        Spacer(Modifier.height(4.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            state = lazyListState
        ) {
            item {
                Text(
                    stringResource(R.string.repository_search_hot_repos),
                    style = title,
                )
                Spacer(Modifier.height(8.dp))
            }
            searchResult.value?.let {
                items(it.items.toList()) {
                    ViewerHomePageSearchItem(
                        item = { it },
                        onItemClicked
                    )
                }
            }
        }
    }
}