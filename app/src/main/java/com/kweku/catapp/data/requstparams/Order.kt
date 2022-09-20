package com.kweku.catapp.data.requstparams

sealed class Order {
    abstract val orderName: String
}

object RandomOrder: Order() {
    override val orderName: String
        get() = "RANDOM"
}

object AscendingOrder: Order() {
    override val orderName: String
        get() = "ASC"
}

object DescendingOrder: Order() {
    override val orderName: String
        get() = "DESC"
}