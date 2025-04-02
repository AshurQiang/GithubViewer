package com.ashur.github.githubviewer.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class ViewerRepositoryImpl_Factory implements Factory<ViewerRepositoryImpl> {
  private final Provider<ViewerRetrofitClient> clientProvider;

  public ViewerRepositoryImpl_Factory(Provider<ViewerRetrofitClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public ViewerRepositoryImpl get() {
    return newInstance(clientProvider.get());
  }

  public static ViewerRepositoryImpl_Factory create(Provider<ViewerRetrofitClient> clientProvider) {
    return new ViewerRepositoryImpl_Factory(clientProvider);
  }

  public static ViewerRepositoryImpl newInstance(ViewerRetrofitClient client) {
    return new ViewerRepositoryImpl(client);
  }
}
