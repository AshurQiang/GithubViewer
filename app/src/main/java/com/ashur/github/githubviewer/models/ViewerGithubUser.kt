package com.ashur.github.githubviewer.models

import com.google.gson.annotations.SerializedName

data class ViewerGithubUser(
    val login: String,
    val id: Int,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val url: String,
    val name: String?,
    val email: String?,
    val followers: Int = 0,
    val following: Int = 0,

    )

data class ViewerGithubUserState(
    var isLoggedIn: Boolean = false,
    var userInformation: ViewerGithubUser? = null
)