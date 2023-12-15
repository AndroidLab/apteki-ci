package ru.apteka.profile.presentation.profile_personal_data_phone

import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.apteka.components.data.models.ConfirmationCodeModel
import ru.apteka.components.data.models.PhoneInputModel
import ru.apteka.components.data.repository.kogin.LoginRepository
import ru.apteka.components.data.services.RequestHandler
import ru.apteka.components.data.services.account.AccountsPreferences
import ru.apteka.components.data.services.message_notice_service.IMessageNoticeService
import ru.apteka.components.data.services.navigation_manager.NavigationManager
import ru.apteka.components.data.utils.launchIO
import ru.apteka.components.ui.BaseViewModel
import javax.inject.Inject


/**
 * Представляет модель представления "Персональные данные, изменить почту".
 */
@HiltViewModel
class PersonalDataPhoneViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    requestHandler: RequestHandler,
    messageNoticeService: IMessageNoticeService,
    navigationManager: NavigationManager,
    accountsPreferences: AccountsPreferences
) : BaseViewModel(
    navigationManager,
    messageNoticeService
) {
    /**
     * Возвращает модель поля ввода номера телефона.
     */
    val phoneInput = PhoneInputModel().apply {
        phone.postValue(accountsPreferences.account?.phoneNumber)
    }

    /**
     * Возвращает флаг изменения номер телефона.
     */
    val isPhoneNumberChanged = phoneInput.phone.map {
        phoneInput.getPhoneRaw().length == 10 && phoneInput.getPhoneRaw() != accountsPreferences.account?.phoneNumber
    }

    /**
     * Возвращает модель подтверждения кода.
     */
    val confirmationCode = ConfirmationCodeModel(
        loginRepository = loginRepository,
        requestHandler = requestHandler,
        scope = viewModelScope,
        getPhoneRaw = {
            phoneInput.getPhoneRaw()
        },
    )

    /**
     * Сохраняет персональные данные.
     */
    fun savePersonalData(success: () -> Unit) {
        viewModelScope.launchIO {
            confirmationCode.confirmCode(
                request = { code ->
                    loginRepository.savePersonalDataPhone(
                        phoneInput.getPhoneRaw()
                    )
                },
                success = success
            )
        }
    }
}