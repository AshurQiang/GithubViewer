package com.ashur.github.githubviewer.network

import com.ashur.github.githubviewer.models.GitHubSearchModel
import com.ashur.github.githubviewer.models.GitHubSearchResponse
import com.ashur.github.githubviewer.models.ViewerGithubIssue
import com.ashur.github.githubviewer.models.ViewerGithubUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewerRepositoryImpl @Inject constructor(
    private val client: ViewerRetrofitClient
) : ViewerRepository {
    override suspend fun searchRepositories(
        language: String?, sort: String, order: String, page: Int
    ): Result<GitHubSearchResponse> {
        return try {
            Result.success(
                client.service.searchRepositories(language?.let { "language:$it" }
                    ?: "q", sort, order, page))
        } catch (exception: Throwable) {
            Result.failure(exception)
        }
    }

    override suspend fun getUserInformation(token: String): Result<ViewerGithubUser> {
        return try {
            Result.success(
                client.service.getUserInformation("Bearer $token")
            )
        } catch (exception: Throwable) {
            Result.failure(exception)
        }
    }

    override suspend fun getUserRepos(token: String): Result<List<GitHubSearchModel>> {
        return try {
            Result.success(
                client.service.getUserRepos("Bearer $token")
            )
        } catch (exception: Throwable) {
            Result.failure(exception)
        }
    }

    override suspend fun getRepoIssues(
        owner: String, repo: String
    ): Result<List<ViewerGithubIssue>> {
        return try {
            Result.success(
                client.service.getRepoIssues(owner, repo)
            )
        } catch (exception: Throwable) {
            Result.failure(exception)
        }
    }
}