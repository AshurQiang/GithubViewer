package com.ashur.github.githubviewer

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class ViewerOAuthViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: ViewerOAuthViewModel
    private val mockClient: ViewerRetrofitClient = mockk(relaxed = true)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = ViewerOAuthViewModel(mockClient)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadAccessToken should call success callback when request succeeds`() = runTest {
        // Given
        val testCode = "test_code"
        val testToken = "test_token"
        val mockResponse = ViewerOAuthResponse(accessToken = testToken)

        coEvery { mockClient.oAuthService.oAuthLogin(any()) } returns mockResponse

        var successCalled = false
        var receivedToken = ""
        val success: (String) -> Unit = { token ->
            successCalled = true
            receivedToken = token
        }
        val failure: () -> Unit = {}

        // When
        viewModel.loadAccessToken(testCode, success, failure)
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertEquals(true, successCalled)
        assertEquals(testToken, receivedToken)
        coVerify(exactly = 1) { mockClient.oAuthService.oAuthLogin(ViewerOAuthRequest(code = testCode)) }
    }

    @Test
    fun `loadAccessToken should call failure callback when request fails`() = runTest {
        // Given
        val testCode = "test_code"
        val exception = RuntimeException("Network error")

        coEvery { mockClient.oAuthService.oAuthLogin(any()) } throws exception

        var failureCalled = false
        val success: (String) -> Unit = {}
        val failure: () -> Unit = { failureCalled = true }

        // When
        viewModel.loadAccessToken(testCode, success, failure)
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assertEquals(true, failureCalled)
        coVerify(exactly = 1) { mockClient.oAuthService.oAuthLogin(ViewerOAuthRequest(code = testCode)) }
    }

    @Test
    fun `loadAccessToken should not call callbacks when coroutine is cancelled`() = runTest {
        // Given
        val testCode = "test_code"
        val testToken = "test_token"
        val mockResponse = ViewerOAuthResponse(accessToken = testToken)

        coEvery { mockClient.oAuthService.oAuthLogin(any()) } coAnswers {
            // Simulate long-running operation
            kotlinx.coroutines.delay(1000)
            mockResponse
        }

        var successCalled = false
        var failureCalled = false
        val success: (String) -> Unit = { successCalled = true }
        val failure: () -> Unit = { failureCalled = true }

        // When
        viewModel.loadAccessToken(testCode, success, failure)
        // Don't advance time - simulate immediate cancellation
        viewModel.onCleared()

        // Then
        assertEquals(false, successCalled)
        assertEquals(false, failureCalled)
    }
}