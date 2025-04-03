package com.ashur.github.githubviewer.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashur.github.githubviewer.constants.ViewerUIConfiguration
import com.ashur.github.githubviewer.models.ErrorCode
import com.ashur.github.githubviewer.models.GitHubSearchResponse
import com.ashur.github.githubviewer.models.ViewerGithubUserState
import com.ashur.github.githubviewer.network.ViewerRepositoryImpl
import com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewerViewModel @Inject constructor(
    private val repository: ViewerRepositoryImpl,
    private val sharedPreferenceHelper: ViewerSharedPreferenceHelper
) : ViewModel() {
    private val _searchResult: MutableStateFlow<GitHubSearchResponse?> = MutableStateFlow(null)
    val searchResult = _searchResult.asStateFlow()

    private val _errorState: MutableSharedFlow<ErrorCode?> = MutableSharedFlow()
    val apiError = _errorState

    private val _loadingState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loadingState = _loadingState.asStateFlow()

    private val _loginState: MutableStateFlow<ViewerGithubUserState> =
        MutableStateFlow(ViewerGithubUserState())
    val loginState = _loginState.asStateFlow()

    private var selectedLanguage: String? =
        ViewerUIConfiguration.LANGUAGE_DROP_DOWN.options.first().toLowerCase()
            .takeIf { it != "all" }
    private var selectedSort: String =
        ViewerUIConfiguration.SORT_DROP_DOWN.options.first().toLowerCase()

    fun checkUserState(context: Context) {
        val accessToken = sharedPreferenceHelper.loadAccessToken(context)
        accessToken?.let {
            viewModelScope.launch {
                repository.getUserInformation(it).apply {
                    onSuccess {
                        _loginState.value = _loginState.value.copy(
                            isLoggedIn = true, userInformation = it
                        )
                    }
                    onFailure {
                        _loginState.value = _loginState.value.copy(isLoggedIn = false)
                    }
                }
            }
        } ?: run {
            _loginState.value = _loginState.value.copy(isLoggedIn = false)
        }
    }


    fun searchRepositories(
        language: String? = null, sort: String? = null, forceRefresh: Boolean = true
    ) {
        if (forceRefresh.not() && _searchResult.value != null) {
            return
        }
        language?.let {
            selectedLanguage = it.toLowerCase().takeIf { it != "all" }
        }
        sort?.let {
            selectedSort = it.toLowerCase()
        }
        viewModelScope.launch {
            _loadingState.value = true
            repository.searchRepositories(language = selectedLanguage, sort = selectedSort).let {
                it.apply {
                    onSuccess { result ->
                        _searchResult.value = result
                        _loadingState.value = false
                    }
                    onFailure { exception ->
                        _loadingState.value = false
                        handleServiceError(exception)
                    }
                }
            }
        }
    }

    private fun handleServiceError(error: Throwable) {
        viewModelScope.launch {
            _errorState.emit(ErrorCode.NETWORK_DISCONNECT)
        }
    }

    fun logoffUser(context: Context) {
        sharedPreferenceHelper.removeAccessToken(context)
        _loginState.value = _loginState.value.copy(isLoggedIn = false, userInformation = null)
    }
}