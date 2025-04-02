package com.ashur.github.githubviewer.models

import com.google.gson.annotations.SerializedName

data class GitHubSearchResponse(
    val items: List<GitHubSearchModel>
)

data class GitHubSearchModel(
    val id: Int,
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("html_url")
    val htmlUrl: String,
    val language: String?,
    val description: String?,
    val owner: GithubUserModel
)

data class GithubUserModel(
    @SerializedName("avatar_url")
    val avatarUrl: String
)