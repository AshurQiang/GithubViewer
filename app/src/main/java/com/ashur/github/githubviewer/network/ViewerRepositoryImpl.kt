package com.ashur.github.githubviewer.network

import com.ashur.github.githubviewer.models.GitHubSearchResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewerRepositoryImpl @Inject constructor(
    private val client: ViewerRetrofitClient
) : ViewerRepository {
    override suspend fun searchRepositories(
        language: String?,
        sort: String,
        order: String,
        page: Int
    ): Result<GitHubSearchResponse> {
        return try {
            Result.success(
                client.service.searchRepositories(
                    language?.let { "language:$it" } ?: "q",
                    sort,
                    order,
                    page
                )
            )
        } catch (exception: Throwable) {
            Result.failure(exception)
        }
    }
}