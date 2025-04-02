package com.ashur.github.githubviewer

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.test.assertEquals
import kotlin.test.assertNull

@RunWith(RobolectricTestRunner::class)
class ViewerSharedPreferenceHelperTest {

    private lateinit var sharedPreferenceHelper: ViewerSharedPreferenceHelper
    private val mockContext: Context = mockk()
    private val mockSharedPreferences: SharedPreferences = mockk()
    private val mockEditor: Editor = mockk(relaxed = true)

    @Before
    fun setUp() {
        // Mock SharedPreferences behavior
        every { mockContext.getSharedPreferences(any(), any()) } returns mockSharedPreferences
        every { mockSharedPreferences.edit() } returns mockEditor
        every { mockEditor.apply() } returns Unit

        sharedPreferenceHelper = ViewerSharedPreferenceHelper()
    }

    @Test
    fun `loadAccessToken should return null when no token is stored`() {
        // Given
        every { mockSharedPreferences.getString(any(), any()) } returns null

        // When
        val result = sharedPreferenceHelper.loadAccessToken(mockContext)

        // Then
        assertNull(result)
        verify { mockSharedPreferences.getString("access_token", null) }
    }

    @Test
    fun `loadAccessToken should return stored token when available`() {
        // Given
        val testToken = "test_token_123"
        every { mockSharedPreferences.getString(any(), any()) } returns testToken

        // When
        val result = sharedPreferenceHelper.loadAccessToken(mockContext)

        // Then
        assertEquals(testToken, result)
        verify { mockSharedPreferences.getString("access_token", null) }
    }

    @Test
    fun `saveAccessToken should store token correctly`() {
        // Given
        val testToken = "test_token_456"

        // When
        sharedPreferenceHelper.saveAccessToken(mockContext, testToken)

        // Then
        verify {
            mockEditor.putString("access_token", testToken)
            mockEditor.apply()
        }
    }

    @Test
    fun `removeAccessToken should delete token correctly`() {
        // When
        sharedPreferenceHelper.removeAccessToken(mockContext)

        // Then
        verify {
            mockEditor.remove("access_token")
            mockEditor.apply()
        }
    }

    @Test
    fun `save and load should work together correctly`() {
        // Given
        val testToken = "test_token_789"
        every { mockSharedPreferences.getString(any(), any()) } returns testToken

        // When
        sharedPreferenceHelper.saveAccessToken(mockContext, testToken)
        val loadedToken = sharedPreferenceHelper.loadAccessToken(mockContext)

        // Then
        assertEquals(testToken, loadedToken)
        verify {
            mockEditor.putString("access_token", testToken)
            mockEditor.apply()
            mockSharedPreferences.getString("access_token", null)
        }
    }

    @Test
    fun `remove and load should return null after removal`() {
        // Given
        every { mockSharedPreferences.getString(any(), any()) } returns null

        // When
        sharedPreferenceHelper.removeAccessToken(mockContext)
        val loadedToken = sharedPreferenceHelper.loadAccessToken(mockContext)

        // Then
        assertNull(loadedToken)
        verify {
            mockEditor.remove("access_token")
            mockEditor.apply()
            mockSharedPreferences.getString("access_token", null)
        }
    }
}