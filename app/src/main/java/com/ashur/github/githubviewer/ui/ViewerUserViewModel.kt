package com.ashur.github.githubviewer.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashur.github.githubviewer.models.ErrorCode
import com.ashur.github.githubviewer.models.GitHubSearchModel
import com.ashur.github.githubviewer.network.ViewerRepositoryImpl
import com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewerUserViewModel @Inject constructor(
    private val repository: ViewerRepositoryImpl,
    private val sharedPreferenceHelper: ViewerSharedPreferenceHelper
) : ViewModel() {
    private var userToken: String? = null
    private val _errorState: MutableSharedFlow<ErrorCode?> = MutableSharedFlow()
    val apiError = _errorState

    private val _userRepos: MutableStateFlow<List<GitHubSearchModel>> = MutableStateFlow(
        mutableListOf()
    )
    val userRepos = _userRepos.asStateFlow()
    fun getUserRepos(context: Context) {
        userToken = sharedPreferenceHelper.loadAccessToken(context)
        userToken?.let {
            viewModelScope.launch {
                repository.getUserRepos(it).apply {
                    onSuccess {
                        _userRepos.value = it
                    }
                    onFailure {
                        handleServiceError(it)
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
}