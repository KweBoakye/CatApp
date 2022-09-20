package com.kweku.catapp

import com.kweku.catapp.data.CatRepository
import com.kweku.catapp.data.requstparams.AscendingOrder
import com.kweku.catapp.data.requstparams.MimeType
import com.kweku.catapp.data.requstparams.Order
import com.kweku.catapp.domain.interactors.removeItemsWithHatCategory
import com.kweku.catapp.domain.model.ResultOrError
import com.kweku.catapp.domain.model.SimpleImageModel
import com.kweku.catapp.presentation.CatSearchPresenterInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CatSearchController(
    private val catRepository: CatRepository,
    private val catSearchPresenterInterface: CatSearchPresenterInterface
) {

    private val job: Job = SupervisorJob()
    private val context: CoroutineContext = Dispatchers.Main + job
    private val catSearchControllerCoroutineScope: CoroutineScope = CoroutineScope(context)

    fun searchAndDisplayCatImages(
        mimeType: MimeType,
        limit: Int = 10,
        page: Int = 1,
        order: Order = AscendingOrder
        ) = catSearchControllerCoroutineScope.launch {
        catSearchPresenterInterface.setLoading()
            catRepository.searchImagesSimple(mimeType, order, limit, page)
                .run {
                    when(this){
                        is ResultOrError.Success ->
                            value.run{ removeItemsWithHatCategory()}
                                .run(catSearchPresenterInterface::displayCatImages)
                        is ResultOrError.Failure ->
                            errors.run(catSearchPresenterInterface::displayErrors)
                    }
                }
    }
}