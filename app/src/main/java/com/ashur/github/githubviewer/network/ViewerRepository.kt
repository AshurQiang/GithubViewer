package com.ashur.github.githubviewer.network

import com.ashur.github.githubviewer.models.GitHubSearchModel
import com.ashur.github.githubviewer.models.GitHubSearchResponse
import com.ashur.github.githubviewer.models.ViewerGithubIssue
import com.ashur.github.githubviewer.models.ViewerGithubUser

interface ViewerRepository {
    suspend fun searchRepositories(
        language: String?,
        sort: String = "stars",
        order: String = "desc",
        page: Int = 1
    ): Result<GitHubSearchResponse>

    suspend fun getUserInformation(
        token: String
    ): Result<ViewerGithubUser>

    suspend fun getUserRepos(
        token: String
    ): Result<List<GitHubSearchModel>>

    suspend fun getRepoIssues(
        owner: String, repo: String
    ): Result<List<ViewerGithubIssue>>
}