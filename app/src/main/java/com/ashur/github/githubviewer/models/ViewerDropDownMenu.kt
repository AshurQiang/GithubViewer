package com.ashur.github.githubviewer.models

import androidx.annotation.StringRes

data class ViewerDropDownMenu(
    @StringRes val label: Int,
    val options: List<String>
)