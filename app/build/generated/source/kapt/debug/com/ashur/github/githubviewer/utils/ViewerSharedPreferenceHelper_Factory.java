package com.ashur.github.githubviewer.utils;

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
public final class ViewerSharedPreferenceHelper_Factory implements Factory<ViewerSharedPreferenceHelper> {
  @Override
  public ViewerSharedPreferenceHelper get() {
    return newInstance();
  }

  public static ViewerSharedPreferenceHelper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ViewerSharedPreferenceHelper newInstance() {
    return new ViewerSharedPreferenceHelper();
  }

  private static final class InstanceHolder {
    private static final ViewerSharedPreferenceHelper_Factory INSTANCE = new ViewerSharedPreferenceHelper_Factory();
  }
}
