package com.kweku.catapp.ui.dropdown

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class FilterTypeDropDownMenuItemType {
    abstract val id: Int
    abstract val typeName: String
    abstract val checked: MutableState<Boolean>
}

object GifFilter: FilterTypeDropDownMenuItemType() {
    override val id: Int
        get() = 0
    override val typeName: String
        get() = "Gif"
    override val checked: MutableState<Boolean>
        get() = mutableStateOf(false)
}

object JpgFilter: FilterTypeDropDownMenuItemType() {
    override val id: Int
        get() = 1
    override val typeName: String
        get() = "Jpg"
    override val checked: MutableState<Boolean>
        get() = mutableStateOf(false)
}

object PngFilter: FilterTypeDropDownMenuItemType() {
    override val id: Int
        get() = 2
    override val typeName: String
        get() = "Png"
    override val checked: MutableState<Boolean>
        get() = mutableStateOf(false)
}

object AllFilter: FilterTypeDropDownMenuItemType(){
    override val id: Int
        get() = 3
    override val typeName: String
        get() = "All"
    override val checked: MutableState<Boolean>
        get() = mutableStateOf(false)
}
