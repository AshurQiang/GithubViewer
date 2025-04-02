package com.ashur.github.githubviewer.ui;

import com.ashur.github.githubviewer.network.ViewerRepositoryImpl;
import com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper;
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
public final class ViewerViewModel_Factory implements Factory<ViewerViewModel> {
  private final Provider<ViewerRepositoryImpl> repositoryProvider;

  private final Provider<ViewerSharedPreferenceHelper> sharedPreferenceHelperProvider;

  public ViewerViewModel_Factory(Provider<ViewerRepositoryImpl> repositoryProvider,
      Provider<ViewerSharedPreferenceHelper> sharedPreferenceHelperProvider) {
    this.repositoryProvider = repositoryProvider;
    this.sharedPreferenceHelperProvider = sharedPreferenceHelperProvider;
  }

  @Override
  public ViewerViewModel get() {
    return newInstance(repositoryProvider.get(), sharedPreferenceHelperProvider.get());
  }

  public static ViewerViewModel_Factory create(Provider<ViewerRepositoryImpl> repositoryProvider,
      Provider<ViewerSharedPreferenceHelper> sharedPreferenceHelperProvider) {
    return new ViewerViewModel_Factory(repositoryProvider, sharedPreferenceHelperProvider);
  }

  public static ViewerViewModel newInstance(ViewerRepositoryImpl repository,
      ViewerSharedPreferenceHelper sharedPreferenceHelper) {
    return new ViewerViewModel(repository, sharedPreferenceHelper);
  }
}
