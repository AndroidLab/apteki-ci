package ru.apteka.profile.presentation.pharmacies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.apteka.components.data.services.RequestHandler
import ru.apteka.components.data.services.message_notice_service.IMessageService
import ru.apteka.components.data.services.navigation_manager.NavigationManager
import ru.apteka.components.data.utils.launchIO
import ru.apteka.components.ui.BaseViewModel
import ru.apteka.profile.data.models.AptekaCardModel
import ru.apteka.profile.data.repository.apteki.AptekiRepository
import javax.inject.Inject


/**
 * Представляет модель представления "Аптеки".
 */
@HiltViewModel
class PharmaciesViewModel @Inject constructor(
    private val requestHandler: RequestHandler,
    private val aptekiRepository: AptekiRepository,
    navigationManager: NavigationManager,
    messageService: IMessageService
) : BaseViewModel(
    navigationManager,
    messageService
) {

    private val _pharmacies = MutableLiveData<List<AptekaCardModel>>(emptyList())

    /**
     * Возвращает список аптек.
     */
    val pharmacies: LiveData<List<AptekaCardModel>> = _pharmacies

    init {
        viewModelScope.launchIO {
            requestHandler.handleApiRequest(
                onRequest = { aptekiRepository.getApteki() },
                onSuccess = { pharmacies ->
                    /*mainThread {
                        _pharmacies.value = pharmacies.map { apteka ->
                            AptekaCardModel(
                                apteka = apteka,
                                onFavoriteClick = {

                                }
                            )
                        }
                    }*/
                },
                isLoading = _isLoading
            )
        }
    }

}