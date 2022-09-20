package com.kweku.catapp.data.requstparams

data class ImageSearchParameters(
    val mimeType: MimeType?,
    val order: Order,
    val limit: Int,
    val page: Int
)
