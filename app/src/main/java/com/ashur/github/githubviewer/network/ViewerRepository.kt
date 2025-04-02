package com.ashur.github.githubviewer.network

import com.ashur.github.githubviewer.models.GitHubSearchResponse
import retrofit2.http.Query

interface ViewerRepository {
    suspend fun searchRepositories(
        language: String?,
        sort: String = "stars",
        order: String = "desc",
        page: Int = 1
    ): Result<GitHubSearchResponse>
}