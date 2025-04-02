package com.ashur.github.githubviewer.ui.pages.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ashur.github.githubviewer.models.ViewerDropDownMenu

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ViewerDropDownMenu(
    modifier: Modifier = Modifier,
    dropDownModel: ViewerDropDownMenu,
    onResult: (label: String) -> Unit
) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    val selectedOption = remember { mutableStateOf(dropDownModel.options.first()) }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            readOnly = true,
            value = selectedOption.value,
            label = {
                Text(stringResource(dropDownModel.label))
            },
            onValueChange = {},
            trailingIcon = {
                TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth().background(Color.White)
        )
        ExposedDropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            dropDownModel.options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedOption.value = option
                        expanded = false
                        onResult(option)
                    }
                ) {
                    Text(option)
                }
            }
        }
    }
}