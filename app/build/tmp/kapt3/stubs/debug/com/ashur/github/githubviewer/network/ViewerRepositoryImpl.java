package com.ashur.github.githubviewer.network;

import com.ashur.github.githubviewer.models.GitHubSearchModel;
import com.ashur.github.githubviewer.models.GitHubSearchResponse;
import com.ashur.github.githubviewer.models.ViewerGithubUser;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000f\u0010\u000bJ>\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0019"}, d2 = {"Lcom/ashur/github/githubviewer/network/ViewerRepositoryImpl;", "Lcom/ashur/github/githubviewer/network/ViewerRepository;", "client", "Lcom/ashur/github/githubviewer/network/ViewerRetrofitClient;", "(Lcom/ashur/github/githubviewer/network/ViewerRetrofitClient;)V", "getUserInformation", "Lkotlin/Result;", "Lcom/ashur/github/githubviewer/models/ViewerGithubUser;", "token", "", "getUserInformation-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserRepos", "", "Lcom/ashur/github/githubviewer/models/GitHubSearchModel;", "getUserRepos-gIAlu-s", "searchRepositories", "Lcom/ashur/github/githubviewer/models/GitHubSearchResponse;", "language", "sort", "order", "page", "", "searchRepositories-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ViewerRepositoryImpl implements com.ashur.github.githubviewer.network.ViewerRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.ashur.github.githubviewer.network.ViewerRetrofitClient client = null;
    
    @javax.inject.Inject()
    public ViewerRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.ashur.github.githubviewer.network.ViewerRetrofitClient client) {
        super();
    }
}