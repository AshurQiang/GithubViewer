package com.ashur.github.githubviewer.utils

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewerSharedPreferenceHelper @Inject constructor() {
    companion object {
        private const val ACCESS_TOKEN_KEY = "access_token"
        private const val SPACE = "GithubViewer"
    }

    fun loadAccessToken(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences(SPACE, Context.MODE_PRIVATE)
        return sharedPreferences.getString(ACCESS_TOKEN_KEY, null)
    }

    fun saveAccessToken(context: Context, token: String) {
        val sharedPreferences = context.getSharedPreferences(SPACE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(ACCESS_TOKEN_KEY, token)
        editor.apply()
    }

    fun removeAccessToken(context: Context) {
        val sharedPreferences = context.getSharedPreferences(SPACE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove(ACCESS_TOKEN_KEY)
        editor.apply()
    }
}