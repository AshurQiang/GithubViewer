package com.ashur.github.githubviewer.ui

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashur.github.githubviewer.R
import com.ashur.github.githubviewer.constants.ViewerGithubOAuth
import com.ashur.github.githubviewer.ui.pages.components.ViewerLoadingView
import com.ashur.github.githubviewer.ui.theme.GitHubViewerTheme
import com.ashur.github.githubviewer.ui.viewmodels.ViewerOAuthViewModel
import com.ashur.github.githubviewer.utils.ViewerSharedPreferenceHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ViewerOAuthActivity : ComponentActivity() {
    @Inject
    lateinit var sharedPreferenceHelper: ViewerSharedPreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubViewerTheme {
                val viewModel: ViewerOAuthViewModel = hiltViewModel()
                val uri: Uri? = intent?.data
                uri?.let {
                    if (it.toString().startsWith(ViewerGithubOAuth.OAUTH_CALLBACK_URI)) {
                        val code = it.getQueryParameter("code")
                        if (code != null) {
                            viewModel.loadAccessToken(code = code, success = { token ->
                                sharedPreferenceHelper.saveAccessToken(
                                    this@ViewerOAuthActivity, token
                                )
                                finish()
                            }, failure = {
                                Toast.makeText(
                                    this,
                                    getString(R.string.api_logon_error),
                                    Toast.LENGTH_SHORT
                                ).show()
                                finish()
                            })
                        } else {
                            Toast.makeText(
                                this, getString(R.string.api_logon_error), Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }
                    }
                }
                ViewerLoadingView()
            }
        }

    }
}