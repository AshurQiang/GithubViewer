package com.ashur.github.githubviewer.services;

import com.ashur.github.githubviewer.models.GitHubSearchModel;
import com.ashur.github.githubviewer.models.GitHubSearchResponse;
import com.ashur.github.githubviewer.models.ViewerGithubUser;
import com.ashur.github.githubviewer.models.ViewerOAuthRequest;
import com.ashur.github.githubviewer.models.ViewerOAuthResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ6\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00052\b\b\u0003\u0010\u0012\u001a\u00020\u00052\b\b\u0003\u0010\u0013\u001a\u00020\u00052\b\b\u0003\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/ashur/github/githubviewer/services/ViewerService;", "", "getUserInformation", "Lcom/ashur/github/githubviewer/models/ViewerGithubUser;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserRepos", "", "Lcom/ashur/github/githubviewer/models/GitHubSearchModel;", "oAuthLogin", "Lcom/ashur/github/githubviewer/models/ViewerOAuthResponse;", "request", "Lcom/ashur/github/githubviewer/models/ViewerOAuthRequest;", "(Lcom/ashur/github/githubviewer/models/ViewerOAuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRepositories", "Lcom/ashur/github/githubviewer/models/GitHubSearchResponse;", "language", "sort", "order", "page", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ViewerService {
    
    @retrofit2.http.GET(value = "search/repositories")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchRepositories(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @retrofit2.http.Query(value = "sort")
    @org.jetbrains.annotations.NotNull()
    java.lang.String sort, @retrofit2.http.Query(value = "order")
    @org.jetbrains.annotations.NotNull()
    java.lang.String order, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ashur.github.githubviewer.models.GitHubSearchResponse> $completion);
    
    @retrofit2.http.POST(value = "login/oauth/access_token")
    @retrofit2.http.Headers(value = {"Accept:application/json"})
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object oAuthLogin(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.ashur.github.githubviewer.models.ViewerOAuthRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ashur.github.githubviewer.models.ViewerOAuthResponse> $completion);
    
    @retrofit2.http.GET(value = "user")
    @retrofit2.http.Headers(value = {"Accept:application/json"})
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserInformation(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ashur.github.githubviewer.models.ViewerGithubUser> $completion);
    
    @retrofit2.http.GET(value = "user/repos?visibility=all")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserRepos(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ashur.github.githubviewer.models.GitHubSearchModel>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}