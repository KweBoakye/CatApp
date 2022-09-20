package com.kweku.catapp.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kweku.catapp.data.requstparams.AllMimeTypes
import com.kweku.catapp.data.requstparams.AscendingOrder
import com.kweku.catapp.data.requstparams.ImageSearchParameters
import com.kweku.catapp.data.requstparams.PngMimeType
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApiTest {

    val catApi: CatApi = CatApi()

    @Test
    fun testApiCall(){
        runBlocking {
            catApi
                .searchImagesSimple(
                    ImageSearchParameters(PngMimeType, AscendingOrder, 10, page = 1))
                .forEach { imageModel -> println(imageModel)  }
        }
    }

}