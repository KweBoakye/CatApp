package com.kweku.catapp.data.requstparams

sealed class MimeType {
    abstract val mimeTypeName: String
}

object GifMimeType :MimeType() {
    override val mimeTypeName: String
        get() = "gif"
}

object JpgMimeType :MimeType() {
    override val mimeTypeName: String
        get() = "jpg"
}

object PngMimeType :MimeType() {
    override val mimeTypeName: String
        get() = "png"
}

object GifAndJpgMimeType :MimeType() {
    override val mimeTypeName: String
        get() = "gif,jpg"
}

object GifAndPngMimeType :MimeType() {
    override val mimeTypeName: String
        get() = "gif,png"
}

object JpgAndPngMimeType :MimeType() {
    override val mimeTypeName: String
        get() = "jpg,png"
}

object AllMimeTypes :MimeType() {
    override val mimeTypeName: String
        get() = "gif,jpg,png"
}