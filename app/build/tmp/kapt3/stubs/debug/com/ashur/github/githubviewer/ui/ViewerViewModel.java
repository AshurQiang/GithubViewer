package com.ashur.github.githubviewer.ui;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.ashur.github.githubviewer.constants.ViewerUIConfiguration;
import com.ashur.github.githubviewer.models.ErrorCode;
import com.ashur.github.githubviewer.models.GitHubSearchResponse;
import com.ashur.github.githubviewer.models.ViewerGithubUserState;
import com.ashur.github.githubviewer.network.ViewerRepositoryImpl;
import com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J(\u0010\'\u001a\u00020 2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010*\u001a\u00020\fR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/ashur/github/githubviewer/ui/ViewerViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/ashur/github/githubviewer/network/ViewerRepositoryImpl;", "sharedPreferenceHelper", "Lcom/ashur/github/githubviewer/utils/ViewerSharedPreferenceHelper;", "(Lcom/ashur/github/githubviewer/network/ViewerRepositoryImpl;Lcom/ashur/github/githubviewer/utils/ViewerSharedPreferenceHelper;)V", "_errorState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ashur/github/githubviewer/models/ErrorCode;", "_loadingState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_loginState", "Lcom/ashur/github/githubviewer/models/ViewerGithubUserState;", "_searchResult", "Lcom/ashur/github/githubviewer/models/GitHubSearchResponse;", "apiError", "getApiError", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "loadingState", "Lkotlinx/coroutines/flow/StateFlow;", "getLoadingState", "()Lkotlinx/coroutines/flow/StateFlow;", "loginState", "getLoginState", "searchResult", "getSearchResult", "selectedLanguage", "", "selectedSort", "checkUserState", "", "context", "Landroid/content/Context;", "handleServiceError", "error", "", "logoffUser", "searchRepositories", "language", "sort", "forceRefresh", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ViewerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ashur.github.githubviewer.network.ViewerRepositoryImpl repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper sharedPreferenceHelper = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ashur.github.githubviewer.models.GitHubSearchResponse> _searchResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ashur.github.githubviewer.models.GitHubSearchResponse> searchResult = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.ashur.github.githubviewer.models.ErrorCode> _errorState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.ashur.github.githubviewer.models.ErrorCode> apiError = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _loadingState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> loadingState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ashur.github.githubviewer.models.ViewerGithubUserState> _loginState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.ashur.github.githubviewer.models.ViewerGithubUserState> loginState = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedLanguage;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedSort;
    
    @javax.inject.Inject()
    public ViewerViewModel(@org.jetbrains.annotations.NotNull()
    com.ashur.github.githubviewer.network.ViewerRepositoryImpl repository, @org.jetbrains.annotations.NotNull()
    com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper sharedPreferenceHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.ashur.github.githubviewer.models.GitHubSearchResponse> getSearchResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableSharedFlow<com.ashur.github.githubviewer.models.ErrorCode> getApiError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLoadingState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.ashur.github.githubviewer.models.ViewerGithubUserState> getLoginState() {
        return null;
    }
    
    public final void checkUserState(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void searchRepositories(@org.jetbrains.annotations.Nullable()
    java.lang.String language, @org.jetbrains.annotations.Nullable()
    java.lang.String sort, boolean forceRefresh) {
    }
    
    private final void handleServiceError(java.lang.Throwable error) {
    }
    
    public final void logoffUser(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}