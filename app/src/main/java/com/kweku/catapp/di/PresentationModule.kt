package com.kweku.catapp.di

import com.kweku.catapp.CatSearchController
import com.kweku.catapp.data.CatRepository
import com.kweku.catapp.presentation.CatSearchPresenterInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
object PresentationModule {

    @Provides
    fun providesCatSearchControllerCreator(
        catRepository: CatRepository): CatSearchControllerCreator{
        return CatSearchControllerCreator(catRepository)
    }
}

class CatSearchControllerCreator(private val catRepository: CatRepository){

    operator fun invoke(catSearchPresenterInterface: CatSearchPresenterInterface):CatSearchController{
        return CatSearchController(catRepository, catSearchPresenterInterface)
    }
}