package com.ashur.github.githubviewer;

import android.app.Application;
import coil3.PlatformContext;
import coil3.SingletonImageLoader;
import dagger.hilt.android.HiltAndroidApp;

@dagger.hilt.android.HiltAndroidApp()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/ashur/github/githubviewer/ViewerApplication;", "Landroid/app/Application;", "Lcoil3/SingletonImageLoader$Factory;", "()V", "newImageLoader", "Lcoil3/ImageLoader;", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "app_debug"})
public final class ViewerApplication extends android.app.Application implements coil3.SingletonImageLoader.Factory {
    
    public ViewerApplication() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public coil3.ImageLoader newImageLoader(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}