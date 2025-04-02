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
public final class ViewerUserViewModel_Factory implements Factory<ViewerUserViewModel> {
  private final Provider<ViewerRepositoryImpl> repositoryProvider;

  private final Provider<ViewerSharedPreferenceHelper> sharedPreferenceHelperProvider;

  public ViewerUserViewModel_Factory(Provider<ViewerRepositoryImpl> repositoryProvider,
      Provider<ViewerSharedPreferenceHelper> sharedPreferenceHelperProvider) {
    this.repositoryProvider = repositoryProvider;
    this.sharedPreferenceHelperProvider = sharedPreferenceHelperProvider;
  }

  @Override
  public ViewerUserViewModel get() {
    return newInstance(repositoryProvider.get(), sharedPreferenceHelperProvider.get());
  }

  public static ViewerUserViewModel_Factory create(
      Provider<ViewerRepositoryImpl> repositoryProvider,
      Provider<ViewerSharedPreferenceHelper> sharedPreferenceHelperProvider) {
    return new ViewerUserViewModel_Factory(repositoryProvider, sharedPreferenceHelperProvider);
  }

  public static ViewerUserViewModel newInstance(ViewerRepositoryImpl repository,
      ViewerSharedPreferenceHelper sharedPreferenceHelper) {
    return new ViewerUserViewModel(repository, sharedPreferenceHelper);
  }
}
