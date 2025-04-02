package com.ashur.github.githubviewer.ui;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.ashur.github.githubviewer.models.ErrorCode;
import com.ashur.github.githubviewer.models.GitHubSearchModel;
import com.ashur.github.githubviewer.network.ViewerRepositoryImpl;
import com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/ashur/github/githubviewer/ui/ViewerUserViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/ashur/github/githubviewer/network/ViewerRepositoryImpl;", "sharedPreferenceHelper", "Lcom/ashur/github/githubviewer/utils/ViewerSharedPreferenceHelper;", "(Lcom/ashur/github/githubviewer/network/ViewerRepositoryImpl;Lcom/ashur/github/githubviewer/utils/ViewerSharedPreferenceHelper;)V", "_errorState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ashur/github/githubviewer/models/ErrorCode;", "_loadingState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_userRepos", "", "Lcom/ashur/github/githubviewer/models/GitHubSearchModel;", "apiError", "getApiError", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "loadingState", "Lkotlinx/coroutines/flow/StateFlow;", "getLoadingState", "()Lkotlinx/coroutines/flow/StateFlow;", "userRepos", "getUserRepos", "userToken", "", "", "context", "Landroid/content/Context;", "handleServiceError", "error", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ViewerUserViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ashur.github.githubviewer.network.ViewerRepositoryImpl repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper sharedPreferenceHelper = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String userToken;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _loadingState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> loadingState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.ashur.github.githubviewer.models.ErrorCode> _errorState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.ashur.github.githubviewer.models.ErrorCode> apiError = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.ashur.github.githubviewer.models.GitHubSearchModel>> _userRepos = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ashur.github.githubviewer.models.GitHubSearchModel>> userRepos = null;
    
    @javax.inject.Inject()
    public ViewerUserViewModel(@org.jetbrains.annotations.NotNull()
    com.ashur.github.githubviewer.network.ViewerRepositoryImpl repository, @org.jetbrains.annotations.NotNull()
    com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper sharedPreferenceHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLoadingState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableSharedFlow<com.ashur.github.githubviewer.models.ErrorCode> getApiError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ashur.github.githubviewer.models.GitHubSearchModel>> getUserRepos() {
        return null;
    }
    
    public final void getUserRepos(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void handleServiceError(java.lang.Throwable error) {
    }
}