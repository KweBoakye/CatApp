package com.kweku.catapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kweku.catapp.domain.model.SimpleImageModel

class CatSearchViewModel(): ViewModel(), CatSearchPresenterInterface {

    private val listState: MutableLiveData<ListState> = MutableLiveData(ListIsLoading)
    val listStatesImmutable: LiveData<ListState> = listState
    override fun displayCatImages(imageModels: List<SimpleImageModel>) {
        listState.value = LoadedList(imageModels)
    }

    override fun setLoading(){
        listState.value = ListIsLoading
    }

    override fun displayErrors(errors: List<Exception>) {
        listState.value = ListError(errors.toString())
    }
}