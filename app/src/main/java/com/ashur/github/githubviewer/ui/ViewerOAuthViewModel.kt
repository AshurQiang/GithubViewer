package com.ashur.github.githubviewer.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashur.github.githubviewer.models.ViewerOAuthRequest
import com.ashur.github.githubviewer.network.ViewerRetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewerOAuthViewModel @Inject constructor(
    private val client: ViewerRetrofitClient
) : ViewModel() {

    fun loadAccessToken(code: String, success: (token: String) -> Unit, failure: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = client.oAuthService.oAuthLogin(ViewerOAuthRequest(code = code))
                success(response.accessToken)
            } catch (exception: Throwable) {
                failure()
            }
        }
    }
}