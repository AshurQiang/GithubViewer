package com.ashur.github.githubviewer.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class ViewerRetrofitClient_Factory implements Factory<ViewerRetrofitClient> {
  @Override
  public ViewerRetrofitClient get() {
    return newInstance();
  }

  public static ViewerRetrofitClient_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ViewerRetrofitClient newInstance() {
    return new ViewerRetrofitClient();
  }

  private static final class InstanceHolder {
    private static final ViewerRetrofitClient_Factory INSTANCE = new ViewerRetrofitClient_Factory();
  }
}
