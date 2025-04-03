package com.ashur.github.githubviewer.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashur.github.githubviewer.models.ErrorCode
import com.ashur.github.githubviewer.models.ViewerGithubIssue
import com.ashur.github.githubviewer.network.ViewerRepositoryImpl
import com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewerIssueViewModel @Inject constructor(
    private val repository: ViewerRepositoryImpl,
    private val sharedPreferenceHelper: ViewerSharedPreferenceHelper
) : ViewModel() {
    private val _loadingState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loadingState = _loadingState.asStateFlow()

    private val _errorState: MutableSharedFlow<ErrorCode?> = MutableSharedFlow()
    val apiError = _errorState

    private val _repoIssues: MutableStateFlow<List<ViewerGithubIssue>> = MutableStateFlow(
        mutableListOf()
    )
    val repoIssues = _repoIssues.asStateFlow()

    fun getIssues(owner: String, repo: String) {
        viewModelScope.launch {
            _loadingState.value = true
            repository.getRepoIssues(owner, repo).apply {
                onSuccess {
                    _repoIssues.value = it
                    _loadingState.value = false
                }
                onFailure {
                    handleServiceError(it)
                    _loadingState.value = false
                }
            }
        }
    }

    private fun handleServiceError(error: Throwable) {
        viewModelScope.launch {
            _errorState.emit(ErrorCode.NETWORK_DISCONNECT)
        }
    }
}