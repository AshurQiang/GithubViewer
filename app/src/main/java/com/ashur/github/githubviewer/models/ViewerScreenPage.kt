package com.ashur.github.githubviewer.models

import androidx.annotation.StringRes
import com.ashur.github.githubviewer.R

sealed class ScreenPage(
    val route: String,
    @StringRes val pageName: Int
) {
    data object ScreenHome : ScreenPage(
        route = Route.HOME.type,
        pageName = R.string.tab_home
    )

    data object ScreenMe : ScreenPage(
        route = Route.ME.type,
        pageName = R.string.tab_me
    )
}

enum class Route(val type: String) {
    ROOT("root"),
    HOME("home"),
    ME("me")
}