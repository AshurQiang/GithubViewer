package com.ashur.github.githubviewer.network

import com.ashur.github.githubviewer.services.ViewerService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewerRetrofitClient @Inject constructor() {
    companion object {
        private const val BASE_URL = "https://api.github.com/"
        private const val OAUTH_BASE_URL = "https://github.com/"
    }

    private val client: OkHttpClient by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    val service: ViewerService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ViewerService::class.java)
    }

    val oAuthService: ViewerService by lazy {
        Retrofit.Builder()
            .baseUrl(OAUTH_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ViewerService::class.java)
    }
}