package com.ashur.github.githubviewer.constants

import com.ashur.github.githubviewer.R
import com.ashur.github.githubviewer.models.ScreenPage
import com.ashur.github.githubviewer.models.ViewerDropDownMenu

object ViewerUIConfiguration {
    val TAB_LIST = listOf(
        ScreenPage.ScreenHome, ScreenPage.ScreenMe
    )

    val LANGUAGE_DROP_DOWN = ViewerDropDownMenu(
        label = R.string.repository_search_language_label, options = listOf(
            "All",
            "Batchfile",
            "C",
            "C++",
            "CSS",
            "Dart",
            "Dockerfile",
            "EJS",
            "Go",
            "Groovy",
            "HCL",
            "HTML",
            "Java",
            "Javascript",
            "Kotlin"
        )
    )

    val SORT_DROP_DOWN = ViewerDropDownMenu(
        label = R.string.repository_search_sort_label, options = listOf(
            "Stars",
            "Name"
        )
    )
}