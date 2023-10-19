package ru.apteka.brands.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.apteka.components.data.services.RequestHandler
import ru.apteka.components.data.services.navigation_manager.INavigationManager
import ru.apteka.components.ui.BaseViewModel
import javax.inject.Inject


/**
 * Представляет модель представления "".
 */
@HiltViewModel
class BrandsViewModel @Inject constructor(
    private val requestHandler: RequestHandler,
    val navigationManager: INavigationManager
) : BaseViewModel() {


    init {

    }

}