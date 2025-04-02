package com.ashur.github.githubviewer

import org.junit.Test
import org.junit.Assert.assertEquals
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class ViewerDateFormatterTest {

    @Test
    fun `dateFormat should correctly format valid ISO date string`() {
        // Given
        val isoDateString = "2023-05-15T14:30:00Z"
        val expectedFormattedDate = "2023-05-15 14:30:00"

        // When
        val result = ViewerDateFormatter.dateFormat(isoDateString)

        // Then
        assertEquals(expectedFormattedDate, result)
    }

    @Test
    fun `dateFormat should handle different time zones correctly`() {
        // Given
        val isoDateString = "2023-05-15T14:30:00+02:00"
        val expectedFormattedDate = "2023-05-15 14:30:00"

        // When
        val result = ViewerDateFormatter.dateFormat(isoDateString)

        // Then
        assertEquals(expectedFormattedDate, result)
    }

    @Test
    fun `dateFormat should return original string when parsing fails`() {
        // Given
        val invalidDateString = "Not a date"

        // When
        val result = ViewerDateFormatter.dateFormat(invalidDateString)

        // Then
        assertEquals(invalidDateString, result)
    }

    @Test
    fun `dateFormat should handle edge case of empty string`() {
        // Given
        val emptyString = ""

        // When
        val result = ViewerDateFormatter.dateFormat(emptyString)

        // Then
        assertEquals(emptyString, result)
    }

    @Test
    fun `dateFormat should handle midnight time correctly`() {
        // Given
        val midnightDateString = "2023-05-16T00:00:00Z"
        val expectedFormattedDate = "2023-05-16 00:00:00"

        // When
        val result = ViewerDateFormatter.dateFormat(midnightDateString)

        // Then
        assertEquals(expectedFormattedDate, result)
    }

    @Test
    fun `dateFormat should handle different date formats gracefully`() {
        // Given
        val differentFormatDateString = "2023/05/15 14:30:00" // Not ISO format

        // When
        val result = ViewerDateFormatter.dateFormat(differentFormatDateString)

        // Then
        assertEquals(differentFormatDateString, result)
    }
}