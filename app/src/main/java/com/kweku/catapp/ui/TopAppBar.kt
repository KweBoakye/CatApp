package com.kweku.catapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kweku.catapp.R

@Composable
fun AppBar(
    content: @Composable () -> Unit
){
    TopAppBar(backgroundColor = MaterialTheme.colors.secondary,) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextForTopAppBar()
            Spacer(modifier = Modifier.weight(1f))
            content()
        }
    }
}

@Composable
fun TextForTopAppBar(){
    Text(
        text = stringResource(id = R.string.app_name),
        style = MaterialTheme.typography.h4,
        color = MaterialTheme.colors.onSecondary
    )
}
