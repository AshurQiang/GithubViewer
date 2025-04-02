package com.ashur.github.githubviewer.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ashur.github.githubviewer.ui.pages.GitHubRootView
import com.ashur.github.githubviewer.ui.theme.GitHubViewerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubViewerTheme {
                GitHubRootView()
            }
        }
    }
}