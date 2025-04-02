package com.ashur.github.githubviewer.network;

import com.ashur.github.githubviewer.services.ViewerService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/ashur/github/githubviewer/network/ViewerRetrofitClient;", "", "()V", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "oAuthService", "Lcom/ashur/github/githubviewer/services/ViewerService;", "getOAuthService", "()Lcom/ashur/github/githubviewer/services/ViewerService;", "oAuthService$delegate", "service", "getService", "service$delegate", "Companion", "app_debug"})
public final class ViewerRetrofitClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "https://api.github.com/";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String OAUTH_BASE_URL = "https://github.com/";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy client$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy service$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy oAuthService$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ashur.github.githubviewer.network.ViewerRetrofitClient.Companion Companion = null;
    
    @javax.inject.Inject()
    public ViewerRetrofitClient() {
        super();
    }
    
    private final okhttp3.OkHttpClient getClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ashur.github.githubviewer.services.ViewerService getService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ashur.github.githubviewer.services.ViewerService getOAuthService() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/ashur/github/githubviewer/network/ViewerRetrofitClient$Companion;", "", "()V", "BASE_URL", "", "OAUTH_BASE_URL", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}