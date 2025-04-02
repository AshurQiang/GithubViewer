package com.ashur.github.githubviewer.ui.pages

import android.widget.Space
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.ashur.github.githubviewer.R
import com.ashur.github.githubviewer.constants.ViewerGithubOAuth
import com.ashur.github.githubviewer.ui.ViewerUserViewModel
import com.ashur.github.githubviewer.ui.ViewerViewModel
import com.ashur.github.githubviewer.ui.pages.components.ViewerLoadingView
import com.ashur.github.githubviewer.ui.theme.DodgerBlue
import com.ashur.github.githubviewer.ui.theme.LightGray
import com.ashur.github.githubviewer.ui.theme.PurpleGrey80
import com.ashur.github.githubviewer.ui.theme.labelSmall
import com.ashur.github.githubviewer.ui.theme.subtitle
import com.ashur.github.githubviewer.ui.theme.title
import com.ashur.github.githubviewer.utils.ViewerDateFormater

@Composable
fun ViewerUserPage(viewModel: ViewerViewModel) {
    val userInfo = viewModel.loginState.collectAsState().value
    userInfo.userInformation?.let {
        val userViewModel: ViewerUserViewModel = hiltViewModel()
        val context = LocalContext.current
        LaunchedEffect(Unit) {
            userViewModel.getUserRepos(context)
        }
        val userRepos = userViewModel.userRepos.collectAsState().value
        Box {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                item {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 100.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = it.avatarUrl,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape),
                                placeholder = painterResource(R.drawable.default_avatar),
                                contentDescription = "user avatar"
                            )
                            Spacer(Modifier.width(16.dp))
                            Column {
                                Text(
                                    it.login,
                                    style = title.copy(fontWeight = FontWeight.Black),
                                )
                                Text(
                                    it.name ?: it.id.toString(),
                                    style = subtitle,
                                    color = Color.Gray
                                )
                                Spacer(Modifier.height(20.dp))
                                Row {
                                    Image(
                                        painter = painterResource(R.drawable.people_alt),
                                        modifier = Modifier.size(12.dp),
                                        contentDescription = "followers",
                                        colorFilter = ColorFilter.tint(Color.Gray)
                                    )
                                    Spacer(Modifier.width(4.dp))
                                    Text(
                                        text = stringResource(
                                            R.string.user_followers_and_following,
                                            it.followers,
                                            it.following
                                        ),
                                        style = labelSmall,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                }

                if (userRepos.isNotEmpty()) {
                    item {
                        Text(
                            stringResource(R.string.user_repos),
                            style = title,
                        )
                        Spacer(Modifier.height(8.dp))
                    }
                }
                items(userRepos) {
                    Column {
                        Row {
                            Column {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        it.name,
                                        style = subtitle.copy(fontWeight = FontWeight.Medium),
                                        color = DodgerBlue
                                    )
                                    Spacer(Modifier.width(8.dp))
                                    Text(
                                        stringResource(if (it.private) R.string.user_repo_private else R.string.user_repo_public),
                                        style = labelSmall,
                                        modifier = Modifier
                                            .background(
                                                PurpleGrey80,
                                                shape = RoundedCornerShape(4.dp)
                                            )
                                            .padding(
                                                start = 8.dp,
                                                end = 8.dp,
                                                top = 3.dp,
                                                bottom = 3.dp
                                            )
                                    )
                                }
                                Spacer(Modifier.height(8.dp))
                                Text(
                                    text = it.description ?: "No repository description",
                                    style = labelSmall,
                                    color = Color.Gray
                                )
                                Spacer(Modifier.height(8.dp))
                                Text(
                                    text = stringResource(
                                        R.string.user_repo_update_at_time,
                                        ViewerDateFormater.dateFormat(it.updatedAt)
                                    ),
                                    style = labelSmall,
                                    color = Color.Gray
                                )
                                Spacer(Modifier.height(8.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = ColorPainter(Color.Blue),
                                        contentDescription = "language",
                                        modifier = Modifier
                                            .size(12.dp)
                                            .clip(CircleShape)
                                    )
                                    Text(
                                        text = it.language
                                            ?: stringResource(R.string.repository_search_unknown_label),
                                        style = labelSmall,
                                        color = Color.Gray
                                    )
                                    Spacer(Modifier.width(15.dp))
                                    Image(
                                        painter = painterResource(R.drawable.star_border),
                                        modifier = Modifier.size(12.dp),
                                        contentDescription = "stars count",
                                        colorFilter = ColorFilter.tint(Color.Gray)
                                    )
                                    Text(
                                        text = it.stargazersCount.toString(),
                                        style = labelSmall,
                                        color = Color.Gray
                                    )

                                    Spacer(Modifier.width(15.dp))
                                    Image(
                                        painter = painterResource(R.drawable.fork_right),
                                        modifier = Modifier.size(12.dp),
                                        contentDescription = "forks count",
                                        colorFilter = ColorFilter.tint(Color.Gray)
                                    )
                                    Text(
                                        text = it.forksCount.toString(),
                                        style = labelSmall,
                                        color = Color.Gray
                                    )
                                }
                            }
                        }
                        Spacer(
                            Modifier
                                .padding(top = 8.dp, bottom = 8.dp)
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(LightGray)
                        )
                    }
                }
                item {
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = {
                            viewModel.logoffUser(context)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Text(stringResource(R.string.logoff_button))
                    }
                }
            }
            if (userViewModel.loadingState.collectAsState().value) {
                ViewerLoadingView()
            }
        }
    }
}
