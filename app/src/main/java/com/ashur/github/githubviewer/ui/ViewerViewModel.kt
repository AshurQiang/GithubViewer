package com.ashur.github.githubviewer.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashur.github.githubviewer.constants.ViewerUIConfiguration
import com.ashur.github.githubviewer.models.ErrorCode
import com.ashur.github.githubviewer.models.GitHubSearchResponse
import com.ashur.github.githubviewer.network.ViewerRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewerViewModel @Inject constructor(private val repository: ViewerRepositoryImpl) :
    ViewModel() {
    private val _searchResult: MutableStateFlow<GitHubSearchResponse?> = MutableStateFlow(null)
    val searchResult = _searchResult.asStateFlow()

    private val _errorState: MutableStateFlow<ErrorCode?> = MutableStateFlow(null)
    val apiError = _errorState.asStateFlow()

    private val _loadingState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loadingState = _loadingState.asStateFlow()

    private var selectedLanguage: String? =
        ViewerUIConfiguration.LANGUAGE_DROP_DOWN.options.first().toLowerCase()
            .takeIf { it != "all" }
    private var selectedSort: String =
        ViewerUIConfiguration.SORT_DROP_DOWN.options.first().toLowerCase()


    fun searchRepositories(
        language: String? = null,
        sort: String? = null,
        forceRefresh: Boolean = true
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
        _errorState.value = ErrorCode.NETWORK_DISCONNECT
    }
}