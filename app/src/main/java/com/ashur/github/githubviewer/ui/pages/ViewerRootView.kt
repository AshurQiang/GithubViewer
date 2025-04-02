package com.ashur.github.githubviewer.ui.pages

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashur.github.githubviewer.constants.ViewerUIConfiguration
import com.ashur.github.githubviewer.models.Route
import com.ashur.github.githubviewer.models.ScreenPage
import com.ashur.github.githubviewer.ui.ViewerViewModel
import com.ashur.github.githubviewer.ui.pages.components.ViewerLoadingView
import kotlinx.coroutines.launch

@Composable
fun GitHubRootView(viewModel: ViewerViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    val selectedTab = remember { mutableStateOf(ScreenPage.ScreenHome.route) }
    val pagerState = rememberPagerState { ViewerUIConfiguration.TAB_LIST.size }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 1.dp
            ) {
                ViewerUIConfiguration.TAB_LIST.forEachIndexed { index, screenPage ->
                    BottomNavigationItem(
                        modifier = Modifier,
                        label = { Text(stringResource(screenPage.pageName)) },
                        selected = selectedTab.value == screenPage.route,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(page = index)
                            }
                            selectedTab.value = screenPage.route
                        },
                        alwaysShowLabel = true,
                        icon = {}
                    )
                    if (index != ViewerUIConfiguration.TAB_LIST.size - 1)
                        Spacer(
                            Modifier
                                .align(Alignment.CenterVertically)
                                .height(20.dp)
                                .width(1.dp)
                                .background(Color.Gray)
                        )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = Route.ROOT.type,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }
            ) {
                composable(Route.ROOT.type) {
                    HorizontalPager(
                        state = pagerState
                    ) { index ->
                        val page = ViewerUIConfiguration.TAB_LIST[index]
                        when (page.route) {
                            ScreenPage.ScreenHome.route -> ViewerHomePage(viewModel)
                            ScreenPage.ScreenMe.route -> ViewerMePage(viewModel)
                        }
                    }
                }
            }

            if (viewModel.loadingState.collectAsState().value) {
                ViewerLoadingView()
            }
        }
    }
}