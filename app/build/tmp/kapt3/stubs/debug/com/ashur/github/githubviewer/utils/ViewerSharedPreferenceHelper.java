package com.ashur.github.githubviewer.utils;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/ashur/github/githubviewer/utils/ViewerSharedPreferenceHelper;", "", "()V", "loadAccessToken", "", "context", "Landroid/content/Context;", "removeAccessToken", "", "saveAccessToken", "token", "Companion", "app_debug"})
public final class ViewerSharedPreferenceHelper {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ACCESS_TOKEN_KEY = "access_token";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SPACE = "GithubViewer";
    @org.jetbrains.annotations.NotNull()
    public static final com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper.Companion Companion = null;
    
    @javax.inject.Inject()
    public ViewerSharedPreferenceHelper() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String loadAccessToken(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final void saveAccessToken(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    public final void removeAccessToken(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/ashur/github/githubviewer/utils/ViewerSharedPreferenceHelper$Companion;", "", "()V", "ACCESS_TOKEN_KEY", "", "SPACE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}