package com.ashur.github.githubviewer.ui;

import com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class ViewerOAuthActivity_MembersInjector implements MembersInjector<ViewerOAuthActivity> {
  private final Provider<ViewerSharedPreferenceHelper> sharedPreferenceHelperProvider;

  public ViewerOAuthActivity_MembersInjector(
      Provider<ViewerSharedPreferenceHelper> sharedPreferenceHelperProvider) {
    this.sharedPreferenceHelperProvider = sharedPreferenceHelperProvider;
  }

  public static MembersInjector<ViewerOAuthActivity> create(
      Provider<ViewerSharedPreferenceHelper> sharedPreferenceHelperProvider) {
    return new ViewerOAuthActivity_MembersInjector(sharedPreferenceHelperProvider);
  }

  @Override
  public void injectMembers(ViewerOAuthActivity instance) {
    injectSharedPreferenceHelper(instance, sharedPreferenceHelperProvider.get());
  }

  @InjectedFieldSignature("com.ashur.github.githubviewer.ui.ViewerOAuthActivity.sharedPreferenceHelper")
  public static void injectSharedPreferenceHelper(ViewerOAuthActivity instance,
      ViewerSharedPreferenceHelper sharedPreferenceHelper) {
    instance.sharedPreferenceHelper = sharedPreferenceHelper;
  }
}
