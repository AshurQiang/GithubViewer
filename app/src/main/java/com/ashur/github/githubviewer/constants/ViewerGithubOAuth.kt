package com.ashur.github.githubviewer.constants

import androidx.core.net.toUri

object ViewerGithubOAuth {
    const val OAUTH_CLIENT_ID = "Ov23li535orxf4i911lB"
    const val OAUTH_CLIENT_SECRET = "698f4cb1627be6527a25808926817c032585755b"
    const val OAUTH_CALLBACK_URI = "githubviewer://callback"
    val OAUTH_LOGIN_URL =
        "https://github.com/login/oauth/authorize?client_id=$OAUTH_CLIENT_ID&redirect_uri=$OAUTH_CALLBACK_URI".toUri()
}