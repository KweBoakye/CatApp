package com.kweku.catapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kweku.catapp.domain.model.SimpleImageModel

@Composable
fun CatImageList(
    modifier: Modifier,
    imageModels: List<SimpleImageModel>
    ){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding =  PaddingValues(8.dp),
        modifier = modifier
    ){ items(imageModels){ item ->  
        CatImageItem(imageModel = item)
    }
        
    }
}