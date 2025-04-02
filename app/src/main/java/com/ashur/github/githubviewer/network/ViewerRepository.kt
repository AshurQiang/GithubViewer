package com.ashur.github.githubviewer.network

import com.ashur.github.githubviewer.models.GitHubSearchModel
import com.ashur.github.githubviewer.models.GitHubSearchResponse
import com.ashur.github.githubviewer.models.ViewerGithubUser
import retrofit2.http.Header
import retrofit2.http.Query

interface ViewerRepository {
    suspend fun searchRepositories(
        language: String?,
        sort: String = "stars",
        order: String = "desc",
        page: Int = 1
    ): Result<GitHubSearchResponse>

    suspend fun getUserInformation(
        @Header("Authorization") token: String
    ): Result<ViewerGithubUser>

    suspend fun getUserRepos(
        @Header("Authorization") token: String
    ): Result<List<GitHubSearchModel>>
}