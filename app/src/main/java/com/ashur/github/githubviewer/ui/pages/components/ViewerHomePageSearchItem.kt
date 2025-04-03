package com.ashur.github.githubviewer.ui.pages.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ashur.github.githubviewer.R
import com.ashur.github.githubviewer.models.GitHubSearchModel
import com.ashur.github.githubviewer.ui.theme.DodgerBlue
import com.ashur.github.githubviewer.ui.theme.labelSmall
import com.ashur.github.githubviewer.ui.theme.subtitle

@Composable
fun ViewerHomePageSearchItem(
    item: () -> GitHubSearchModel,
    onItemClicked: (item: GitHubSearchModel) -> Unit
) {
    val itemModel = item.invoke()
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        onClick = {
            onItemClicked(itemModel)
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp)
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Column(
                Modifier
                    .weight(5f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = itemModel.name,
                    style = subtitle,
                    color = DodgerBlue
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
                        text = itemModel.language
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
                        text = itemModel.stargazersCount.toString(),
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
                        text = itemModel.forksCount.toString(),
                        style = labelSmall,
                        color = Color.Gray
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    text = itemModel.description ?: "",
                    style = labelSmall,
                    color = Color.Gray
                )
            }
            AsyncImage(
                model = itemModel.owner.avatarUrl,
                modifier = Modifier
                    .size(50.dp)
                    .weight(1f),
                placeholder = painterResource(R.drawable.default_avatar),
                contentDescription = "user avatar"
            )
        }
    }
}

