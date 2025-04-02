package com.ashur.github.githubviewer.ui;

import com.ashur.github.githubviewer.network.ViewerRetrofitClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class ViewerOAuthViewModel_Factory implements Factory<ViewerOAuthViewModel> {
  private final Provider<ViewerRetrofitClient> clientProvider;

  public ViewerOAuthViewModel_Factory(Provider<ViewerRetrofitClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public ViewerOAuthViewModel get() {
    return newInstance(clientProvider.get());
  }

  public static ViewerOAuthViewModel_Factory create(Provider<ViewerRetrofitClient> clientProvider) {
    return new ViewerOAuthViewModel_Factory(clientProvider);
  }

  public static ViewerOAuthViewModel newInstance(ViewerRetrofitClient client) {
    return new ViewerOAuthViewModel(client);
  }
}
