package com.kweku.catapp.data

import com.kweku.catapp.data.requstparams.ImageSearchParameters
import com.kweku.catapp.data.requstparams.MimeType
import com.kweku.catapp.data.requstparams.Order
import com.kweku.catapp.domain.model.ImageModel
import com.kweku.catapp.domain.model.ResultOrError
import com.kweku.catapp.domain.model.SimpleImageModel
import com.kweku.catapp.domain.model.toResultOrErrorFailure
import com.kweku.catapp.domain.model.toResultOrErrorSuccess
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

class CatRepository(private val catApi: CatApi) {

    suspend fun searchImages(
        mimeType: MimeType?,
        order: Order,
        limit: Int,
        page: Int
    ): ResultOrError<List<ImageModel>> {
        return ImageSearchParameters(
            mimeType, order, limit, page
        ).run {
            runCatching {
                catApi.searchImages(this)
                    .toResultOrErrorSuccess()
            }
                .getOrElse { exception: Throwable ->
                    (exception as Exception).toResultOrErrorFailure()
                }
        }
    }

    suspend fun searchImagesSimple(
        mimeType: MimeType?,
        order: Order,
        limit: Int,
        page: Int
    ): ResultOrError<List<SimpleImageModel>> {
        return ImageSearchParameters(
            mimeType, order, limit, page
        ).run {
            runCatching {
                catApi.searchImagesSimple(this)
                    .toResultOrErrorSuccess()
            }
                .getOrElse { exception: Throwable ->
                    (exception as Exception).toResultOrErrorFailure()
                }
        }
    }


}