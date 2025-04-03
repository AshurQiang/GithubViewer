package com.ashur.github.githubviewer.models

data class ViewerGithubIssue(
    val number: Int,
    val title: String,
    val body: String?,
    val state: String
)