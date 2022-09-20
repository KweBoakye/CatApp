package com.kweku.catapp.presentation

import com.kweku.catapp.domain.model.SimpleImageModel

interface CatSearchPresenterInterface {

    fun displayCatImages(imageModels: List<SimpleImageModel>)
    fun setLoading()
    fun displayErrors(errors: List<Exception>)
}