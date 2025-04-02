package com.ashur.github.githubviewer.services

import com.ashur.github.githubviewer.models.GitHubSearchResponse
import com.ashur.github.githubviewer.models.ViewerOAuthRequest
import com.ashur.github.githubviewer.models.ViewerOAuthResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ViewerService {
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") language: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("page") page: Int = 1
    ): GitHubSearchResponse

    @POST("login/oauth/access_token")
    @Headers("Accept:application/json")
    suspend fun oAuthLogin(
        @Body request: ViewerOAuthRequest
    ): ViewerOAuthResponse
}