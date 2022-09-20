package com.kweku.catapp.di

import com.kweku.catapp.data.CatApi
import com.kweku.catapp.data.CatRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {


    @Provides
    @Singleton
    fun providesCatApi(): CatApi {
        return CatApi()
    }

    @Provides
    @Singleton
    fun providesCatRepository(catApi: CatApi):CatRepository {
        return  CatRepository(catApi)
    }



}