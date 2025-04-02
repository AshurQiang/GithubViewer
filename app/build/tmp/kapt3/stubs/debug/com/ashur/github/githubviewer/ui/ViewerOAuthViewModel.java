package com.ashur.github.githubviewer.ui;

import androidx.lifecycle.ViewModel;
import com.ashur.github.githubviewer.models.ViewerOAuthRequest;
import com.ashur.github.githubviewer.network.ViewerRetrofitClient;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J?\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/ashur/github/githubviewer/ui/ViewerOAuthViewModel;", "Landroidx/lifecycle/ViewModel;", "client", "Lcom/ashur/github/githubviewer/network/ViewerRetrofitClient;", "(Lcom/ashur/github/githubviewer/network/ViewerRetrofitClient;)V", "loadAccessToken", "", "code", "", "success", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "token", "failure", "Lkotlin/Function0;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ViewerOAuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ashur.github.githubviewer.network.ViewerRetrofitClient client = null;
    
    @javax.inject.Inject()
    public ViewerOAuthViewModel(@org.jetbrains.annotations.NotNull()
    com.ashur.github.githubviewer.network.ViewerRetrofitClient client) {
        super();
    }
    
    public final void loadAccessToken(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> success, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> failure) {
    }
}