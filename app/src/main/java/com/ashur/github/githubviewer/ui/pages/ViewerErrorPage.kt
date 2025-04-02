package com.ashur.github.githubviewer.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ashur.github.githubviewer.R
import com.ashur.github.githubviewer.ui.theme.subtitle
import com.ashur.github.githubviewer.ui.theme.title

@Composable
fun ViewerErrorPage(
    popback: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.warning_amber),
            modifier = Modifier.size(96.dp),
            contentDescription = "error",
            colorFilter = ColorFilter.tint(Color.Red)
        )
        Text(
            stringResource(R.string.api_error_title),
            style = title,
        )
        Spacer(Modifier.height(10.dp))
        Text(
            stringResource(R.string.api_error_content),
            style = subtitle,
            color = Color.Gray
        )
        Spacer(Modifier.height(48.dp))
        Button(
            onClick = {
                popback()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(stringResource(R.string.api_error_button))
        }
    }

}