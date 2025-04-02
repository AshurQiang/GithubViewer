package com.ashur.github.githubviewer.ui.pages

import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import com.ashur.github.githubviewer.ui.ViewerViewModel

@Composable
fun ViewerMePage(viewModel: ViewerViewModel) {
    Text("this is me page")
    val clientId = "Ov23li535orxf4i911lB"
    val redirectUri = "githubviewer://callback"
    val url =
        "https://github.com/login/oauth/authorize?client_id=Ov23li535orxf4i911lB&redirect_uri=githubviewer://callback"
    val context = LocalContext.current
    Button(onClick = {
        val intent = CustomTabsIntent.Builder().build()
        intent.launchUrl(context, url.toUri())
    }) {
        Text("logon")
    }
}