package com.ashur.github.githubviewer.ui.pages

import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ashur.github.githubviewer.R
import com.ashur.github.githubviewer.constants.ViewerGithubOAuth
import com.ashur.github.githubviewer.ui.theme.LightGray
import com.ashur.github.githubviewer.ui.theme.LightPurple40
import com.ashur.github.githubviewer.ui.theme.labelSmall
import com.ashur.github.githubviewer.ui.theme.title

@Composable
fun ViewerLogonPage() {
    val context = LocalContext.current
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(LightGray),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.login_title),
                style = title,
                color = LightPurple40
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = stringResource(R.string.login_subtitle),
                style = labelSmall,
                color = Color.Gray
            )

            Spacer(Modifier.height(20.dp))
            Button(
                onClick = {
                    val intent = CustomTabsIntent.Builder().build()
                    intent.launchUrl(context, ViewerGithubOAuth.OAUTH_LOGIN_URL)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(stringResource(R.string.login_button))
            }
        }
        Modifier.padding(16.dp)

    }
}