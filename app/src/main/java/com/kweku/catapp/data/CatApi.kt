package com.kweku.catapp.data

import com.kweku.catapp.BuildConfig
import com.kweku.catapp.data.requstparams.ImageSearchParameters
import com.kweku.catapp.domain.model.ImageModel
import com.kweku.catapp.domain.model.ResultOrError
import com.kweku.catapp.domain.model.SimpleImageModel
import com.kweku.catapp.domain.model.toResultOrErrorFailure
import com.kweku.catapp.domain.model.toResultOrErrorSuccess
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.HttpResponseData
import io.ktor.client.request.get
import io.ktor.client.request.invoke
import io.ktor.client.statement.HttpResponse
import io.ktor.client.utils.EmptyContent.headers
import io.ktor.http.append
import io.ktor.http.appendEncodedPathSegments
import io.ktor.serialization.kotlinx.json.json


class CatApi {
    private val baseUrl = "https://api.thecatapi.com/v1/"
    private val apiKey = BuildConfig.API_KEY
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation){
            json()
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level =LogLevel.ALL
        }
        defaultRequest {
            url(baseUrl)
        headers.append("x-api-key",apiKey)
        }
        expectSuccess = true
    }

    fun buildSearchImagesUrl(imageSearchParameters: ImageSearchParameters):HttpRequestBuilder{
        return HttpRequestBuilder.invoke {
            appendEncodedPathSegments("images/search")
            parameters.apply {
                append("limit", imageSearchParameters.limit.toString())
                append("page", imageSearchParameters.page.toString())
                append("order", imageSearchParameters.order.orderName)
                imageSearchParameters.mimeType?.let { mimeType ->
                    append("mime_types", mimeType.mimeTypeName)
                }
            }
        }
    }

    suspend fun searchImages(imageSearchParameters: ImageSearchParameters):
            List<ImageModel> {

        return  client
            .get(buildSearchImagesUrl(imageSearchParameters))
            .body()

    }

    suspend fun searchImagesSimple(imageSearchParameters: ImageSearchParameters):
            List<SimpleImageModel> {

        return  client
            .get(buildSearchImagesUrl(imageSearchParameters))
            .body()

    }
}