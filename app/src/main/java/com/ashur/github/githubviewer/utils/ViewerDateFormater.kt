package com.ashur.github.githubviewer.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object ViewerDateFormater {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    fun dateFormat(dateStr: String): String {
        val zonedDateTime = ZonedDateTime.parse(dateStr)
        return try {
            zonedDateTime.format(formatter)
        } catch (ex: Exception) {
            dateStr
        }
    }
}