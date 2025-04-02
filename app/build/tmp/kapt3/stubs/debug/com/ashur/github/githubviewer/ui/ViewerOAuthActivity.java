package com.ashur.github.githubviewer.ui;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import com.ashur.github.githubviewer.R;
import com.ashur.github.githubviewer.constants.ViewerGithubOAuth;
import com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/ashur/github/githubviewer/ui/ViewerOAuthActivity;", "Landroidx/activity/ComponentActivity;", "()V", "sharedPreferenceHelper", "Lcom/ashur/github/githubviewer/utils/ViewerSharedPreferenceHelper;", "getSharedPreferenceHelper", "()Lcom/ashur/github/githubviewer/utils/ViewerSharedPreferenceHelper;", "setSharedPreferenceHelper", "(Lcom/ashur/github/githubviewer/utils/ViewerSharedPreferenceHelper;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ViewerOAuthActivity extends androidx.activity.ComponentActivity {
    @javax.inject.Inject()
    public com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper sharedPreferenceHelper;
    
    public ViewerOAuthActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper getSharedPreferenceHelper() {
        return null;
    }
    
    public final void setSharedPreferenceHelper(@org.jetbrains.annotations.NotNull()
    com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}