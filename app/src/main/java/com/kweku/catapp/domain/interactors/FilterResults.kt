package com.kweku.catapp.domain.interactors

import com.kweku.catapp.domain.model.Category
import com.kweku.catapp.domain.model.ImageModel
import com.kweku.catapp.domain.model.SimpleImageModel

fun Category.checkName(categoryNameToCompare: String): Boolean{
    return name == categoryNameToCompare
}

fun filterResultsByCategory(imageModels: List<SimpleImageModel>, categoryName: String):List<SimpleImageModel>{
 return imageModels
     .filterNot { imageModel ->
         imageModel
             .categories
             .any{ category -> category.checkName(categoryName)
             }
     }
}

fun List<SimpleImageModel>.filterByCategory(categoryName: String):List<SimpleImageModel>{
    return filterResultsByCategory(this,categoryName)
}



fun List<SimpleImageModel>.removeItemsWithHatCategory(): List<SimpleImageModel>{
    return filterByCategory("hats")
}

