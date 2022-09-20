package com.kweku.catapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kweku.catapp.domain.model.ImageModel
import com.kweku.catapp.domain.model.SimpleImageModel

@Composable
fun CatImageItem(
    modifier: Modifier = Modifier,
    imageModel: SimpleImageModel
    ){
    Card(elevation = 4.dp) {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            with(imageModel){
                CatImage(modifier = modifier
                    .height(height.dp)
                    .width(width.dp),
                    url = url )
                Text(categories.joinToString { category -> category.name  },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .paddingFromBaseline(bottom = 8.dp))
            }


        }
    }
}

@Composable
fun CatImage(
    modifier: Modifier,
    url: String){
    AsyncImage(model = url, contentDescription = null , modifier = modifier)
}