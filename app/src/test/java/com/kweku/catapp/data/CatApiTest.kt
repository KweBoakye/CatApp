package com.kweku.catapp.data

import com.kweku.catapp.data.requstparams.AscendingOrder
import com.kweku.catapp.data.requstparams.DescendingOrder
import com.kweku.catapp.data.requstparams.GifMimeType
import com.kweku.catapp.data.requstparams.ImageSearchParameters
import org.junit.Test
import kotlin.test.assertEquals

class CatApiTest {


    @Test
    fun testBuildSearchImagesUrl(){
       val url: String = CatApi().buildSearchImagesUrl(
            ImageSearchParameters(null, DescendingOrder, 5, 10)
        ).build().url.toString().removePrefix("http://localhost")
        val validUrl = "/images/search?limit=5&page=10&order=DESC"
        assertEquals(url, validUrl)
        println(url)
    }
}