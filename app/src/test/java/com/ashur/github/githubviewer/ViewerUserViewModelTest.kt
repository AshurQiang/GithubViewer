package com.ashur.github.githubviewer

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Config.OLDEST_SDK])
class ViewerUserViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @MockK
    private lateinit var mockRepository: ViewerRepositoryImpl

    @MockK
    private lateinit var mockSharedPreferenceHelper: ViewerSharedPreferenceHelper

    private lateinit var viewModel: ViewerUserViewModel
    private val testContext = ApplicationProvider.getApplicationContext<android.content.Context>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)

        viewModel = ViewerUserViewModel(mockRepository, mockSharedPreferenceHelper)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun `getUserRepos should update loading state when token exists`() = runTest {
        // Given
        val testToken = "test_token"
        every { mockSharedPreferenceHelper.loadAccessToken(testContext) } returns testToken
        coEvery { mockRepository.getUserRepos(testToken) } returns Result.success(emptyList())

        // When
        viewModel.getUserRepos(testContext)
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        viewModel.loadingState.first { !it } // Wait for loading to complete
        assert(viewModel.loadingState.value == false)
    }

    @Test
    fun `getUserRepos should not call repository when token is null`() = runTest {
        // Given
        every { mockSharedPreferenceHelper.loadAccessToken(testContext) } returns null

        // When
        viewModel.getUserRepos(testContext)
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        coVerify(exactly = 0) { mockRepository.getUserRepos(any()) }
    }

    @Test
    fun `getUserRepos should update userRepos on success`() = runTest {
        // Given
        val testToken = "test_token"
        val testRepos = listOf(
            GitHubSearchModel(id = 1, name = "repo1"),
            GitHubSearchModel(id = 2, name = "repo2")
        )
        every { mockSharedPreferenceHelper.loadAccessToken(testContext) } returns testToken
        coEvery { mockRepository.getUserRepos(testToken) } returns Result.success(testRepos)

        // When
        viewModel.getUserRepos(testContext)
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        assert(viewModel.userRepos.value == testRepos)
    }

    @Test
    fun `getUserRepos should emit error on failure`() = runTest {
        // Given
        val testToken = "test_token"
        val testError = RuntimeException("Network error")
        every { mockSharedPreferenceHelper.loadAccessToken(testContext) } returns testToken
        coEvery { mockRepository.getUserRepos(testToken) } returns Result.failure(testError)

        // When
        viewModel.getUserRepos(testContext)
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        val error = viewModel.apiError.first()
        assert(error == ErrorCode.NETWORK_DISCONNECT)
    }

    @Test
    fun `loading state should be true during repository call`() = runTest {
        // Given
        val testToken = "test_token"
        every { mockSharedPreferenceHelper.loadAccessToken(testContext) } returns testToken

        // Use a CompletableDeferred to control when the repository call completes
        val deferred = CompletableDeferred<Result<List<GitHubSearchModel>>>()
        coEvery { mockRepository.getUserRepos(testToken) } returns deferred

        // When
        viewModel.getUserRepos(testContext)
        testDispatcher.scheduler.advanceUntilIdle()

        // Then - loading should be true during the call
        assert(viewModel.loadingState.value == true)

        // Complete the call
        deferred.complete(Result.success(emptyList()))
        testDispatcher.scheduler.advanceUntilIdle()

        // Now loading should be false
        assert(viewModel.loadingState.value == false)
    }
}