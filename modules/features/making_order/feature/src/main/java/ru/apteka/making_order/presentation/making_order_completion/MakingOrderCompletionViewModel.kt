package ru.apteka.making_order.presentation.making_order_completion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.apteka.components.data.models.ProductModel
import ru.apteka.components.data.services.message_notice_service.MessageNoticeService
import ru.apteka.components.data.services.navigation_manager.NavigationManager
import ru.apteka.components.ui.BaseViewModel
import ru.apteka.making_order.data.model.CompletionDataModel
import ru.apteka.making_order_api.api.MAKING_ORDER_ARGUMENT_COMPLETION
import javax.inject.Inject


/**
 * Представляет модель представления "Оформление заказа, завершение".
 */
@HiltViewModel
class MakingOrderCompletionViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    navigationManager: NavigationManager,
    messageNoticeService: MessageNoticeService
) : BaseViewModel(
    navigationManager,
    messageNoticeService
) {

    /**
     * Возвращает или устанавливает данные завершения заказа.
     */
    val completionData = MutableLiveData(
        savedStateHandle.get<CompletionDataModel>(MAKING_ORDER_ARGUMENT_COMPLETION)!!
    )

    init {

    }

}