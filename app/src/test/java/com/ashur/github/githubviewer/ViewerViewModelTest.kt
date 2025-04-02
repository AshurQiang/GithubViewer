package com.ashur.github.githubviewer

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class ViewerViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: ViewerViewModel
    private val mockRepository: ViewerRepositoryImpl = mockk()
    private val mockSharedPreferenceHelper: ViewerSharedPreferenceHelper = mockk()
    private val testContext = ApplicationProvider.getApplicationContext<android.content.Context>()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = ViewerViewModel(mockRepository, mockSharedPreferenceHelper)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `checkUserState should update loginState to logged in when token exists and API succeeds`() = runTest {
        // Given
        val testToken = "test_token"
        val testUserInfo = GitHubUserInformation(login = "testUser")
        every { mockSharedPreferenceHelper.loadAccessToken(testContext) } returns testToken
        coEvery { mockRepository.getUserInformation(testToken) } returns Result.success(testUserInfo)

        // When
        viewModel.checkUserState(testContext)
        advanceUntilIdle()

        // Then
        val loginState = viewModel.loginState.first { it.isLoggedIn }
        assertTrue(loginState.isLoggedIn)
        assertEquals(testUserInfo, loginState.userInformation)
    }

    @Test
    fun `checkUserState should update loginState to logged out when token exists but API fails`() = runTest {
        // Given
        val testToken = "test_token"
        every { mockSharedPreferenceHelper.loadAccessToken(testContext) } returns testToken
        coEvery { mockRepository.getUserInformation(testToken) } returns Result.failure(RuntimeException())

        // When
        viewModel.checkUserState(testContext)
        advanceUntilIdle()

        // Then
        val loginState = viewModel.loginState.first { !it.isLoggedIn }
        assertFalse(loginState.isLoggedIn)
        assertNull(loginState.userInformation)
    }

    @Test
    fun `checkUserState should update loginState to logged out when token is null`() = runTest {
        // Given
        every { mockSharedPreferenceHelper.loadAccessToken(testContext) } returns null

        // When
        viewModel.checkUserState(testContext)
        advanceUntilIdle()

        // Then
        val loginState = viewModel.loginState.first { !it.isLoggedIn }
        assertFalse(loginState.isLoggedIn)
        assertNull(loginState.userInformation)
    }

    @Test
    fun `searchRepositories should update searchResult when API succeeds`() = runTest {
        // Given
        val testResponse = GitHubSearchResponse(totalCount = 1, items = emptyList())
        coEvery { mockRepository.searchRepositories(any(), any()) } returns Result.success(testResponse)

        // When
        viewModel.searchRepositories(forceRefresh = true)
        advanceUntilIdle()

        // Then
        assertEquals(testResponse, viewModel.searchResult.value)
        assertFalse(viewModel.loadingState.value)
    }

    @Test
    fun `searchRepositories should update errorState when API fails`() = runTest {
        // Given
        coEvery { mockRepository.searchRepositories(any(), any()) } returns Result.failure(RuntimeException())

        // When
        viewModel.searchRepositories(forceRefresh = true)
        advanceUntilIdle()

        // Then
        assertEquals(ErrorCode.NETWORK_DISCONNECT, viewModel.apiError.first())
        assertFalse(viewModel.loadingState.value)
    }

    @Test
    fun `searchRepositories should not call API when forceRefresh is false and result exists`() = runTest {
        // Given
        val initialResponse = GitHubSearchResponse(totalCount = 1, items = emptyList())
        viewModel.searchRepositories(forceRefresh = true) // First call to set initial value
        advanceUntilIdle()
        coEvery { mockRepository.searchRepositories(any(), any()) } returns Result.success(initialResponse)

        // When
        viewModel.searchRepositories(forceRefresh = false)
        advanceUntilIdle()

        // Then
        coVerify(exactly = 1) { mockRepository.searchRepositories(any(), any()) } // Only called once
    }

    @Test
    fun `searchRepositories should update language and sort parameters`() = runTest {
        // Given
        val testLanguage = "kotlin"
        val testSort = "stars"
        val testResponse = GitHubSearchResponse(totalCount = 1, items = emptyList())
        coEvery { mockRepository.searchRepositories(testLanguage, testSort) } returns Result.success(testResponse)

        // When
        viewModel.searchRepositories(language = testLanguage, sort = testSort, forceRefresh = true)
        advanceUntilIdle()

        // Then
        coVerify { mockRepository.searchRepositories(testLanguage, testSort) }
    }

    @Test
    fun `logoffUser should update loginState and remove token`() = runTest {
        // Given
        val testToken = "test_token"
        every { mockSharedPreferenceHelper.loadAccessToken(testContext) } returns testToken
        coEvery { mockRepository.getUserInformation(testToken) } returns Result.success(mockk())
        viewModel.checkUserState(testContext)
        advanceUntilIdle()

        // When
        viewModel.logoffUser(testContext)
        advanceUntilIdle()

        // Then
        val loginState = viewModel.loginState.first { !it.isLoggedIn }
        assertFalse(loginState.isLoggedIn)
        assertNull(loginState.userInformation)
        verify { mockSharedPreferenceHelper.removeAccessToken(testContext) }
    }

    @Test
    fun `searchRepositories should handle language 'all' as null`() = runTest {
        // Given
        val testResponse = GitHubSearchResponse(totalCount = 1, items = emptyList())
        coEvery { mockRepository.searchRepositories(null, any()) } returns Result.success(testResponse)

        // When
        viewModel.searchRepositories(language = "all", forceRefresh = true)
        advanceUntilIdle()

        // Then
        coVerify { mockRepository.searchRepositories(null, any()) }
    }
}