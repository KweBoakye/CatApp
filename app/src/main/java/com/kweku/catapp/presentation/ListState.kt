package com.kweku.catapp.presentation

import com.kweku.catapp.domain.model.SimpleImageModel

sealed class ListState

object ListIsLoading: ListState()

data class LoadedList(val imageModels: List<SimpleImageModel>): ListState()

data class ListError(val error: String): ListState()
