package com.ashur.github.githubviewer.models

import com.ashur.github.githubviewer.constants.ViewerGithubOAuth
import com.google.gson.annotations.SerializedName

data class ViewerOAuthRequest(
    @SerializedName("client_id")
    val clientId: String = ViewerGithubOAuth.OAUTH_CLIENT_ID,
    @SerializedName("client_secret")
    val clientSecret: String = ViewerGithubOAuth.OAUTH_CLIENT_SECRET,
    val code: String
)

data class ViewerOAuthResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String
)
