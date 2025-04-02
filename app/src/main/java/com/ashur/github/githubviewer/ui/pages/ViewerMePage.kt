package com.ashur.github.githubviewer.ui.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.ashur.github.githubviewer.ui.ViewerViewModel

@Composable
fun ViewerMePage(viewModel: ViewerViewModel) {
    if (viewModel.loginState.collectAsState().value.let { it.isLoggedIn && it.userInformation != null }) {
        ViewerUserPage(viewModel)
    } else {
        ViewerLogonPage()
    }
}