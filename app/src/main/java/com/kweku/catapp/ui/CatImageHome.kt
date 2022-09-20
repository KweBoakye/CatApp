package com.kweku.catapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kweku.catapp.CatSearchController
import com.kweku.catapp.data.requstparams.AllMimeTypes
import com.kweku.catapp.di.CatSearchControllerCreator
import com.kweku.catapp.presentation.CatSearchViewModel
import com.kweku.catapp.presentation.ListError
import com.kweku.catapp.presentation.ListIsLoading
import com.kweku.catapp.presentation.ListState
import com.kweku.catapp.presentation.LoadedList
import com.kweku.catapp.ui.dropdown.AllFilter
import com.kweku.catapp.ui.dropdown.FilterTypeDropDownMenu
import com.kweku.catapp.ui.dropdown.GifFilter
import com.kweku.catapp.ui.dropdown.JpgFilter
import com.kweku.catapp.ui.dropdown.PngFilter
import com.kweku.catapp.ui.dropdown.filterTypeToMimeType

@Composable
fun CatHome(
    catSearchViewModel: CatSearchViewModel = CatSearchViewModel(),
    catSearchControllerCreator: CatSearchControllerCreator,
    modifier: Modifier = Modifier
){
    val catSearchController: CatSearchController = catSearchControllerCreator(catSearchViewModel)
    val catImagesState : ListState? by catSearchViewModel.listStatesImmutable.observeAsState()
    val options by rememberSaveable { mutableStateOf(listOf(GifFilter,JpgFilter,PngFilter, AllFilter)) }
    SideEffect {
        catSearchController.searchAndDisplayCatImages(AllMimeTypes)
    }
    Scaffold(topBar = {
        AppBar {
            FilterTypeDropDownMenu(options = options,
            onOptionsSelected = { filterTypeDropDownMenuItemType ->
                filterTypeToMimeType(filterTypeDropDownMenuItemType).run {
                        catSearchController.searchAndDisplayCatImages(this)
                }
            })
    }
    }) {
        catImagesState?.let { RenderState(listState = it, modifier = modifier) }
            ?: RenderState(listState = ListIsLoading, modifier = modifier)
    }




}


@Composable
fun RenderState(listState: ListState, modifier: Modifier){
    when(listState){
        is ListIsLoading -> ListLoading()
        is LoadedList -> CatImageList(modifier = modifier, imageModels = listState.imageModels)
        is ListError -> RenderError(error = listState.error,modifier)
    }
}

@Composable
fun RenderError(error: String,modifier: Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = error, color = Color.Red)
    }
}

@Composable
fun ListLoading(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(Modifier.size(30.dp))
    }
}