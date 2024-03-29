package ru.apteka.components.data.services.navigation_manager

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import ru.apteka.components.data.models.BottomAppBarModel
import ru.apteka.components.data.utils.single_live_event.SingleLiveEvent
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.properties.Delegates


/**
 * Представляет менеджер навигации.
 */
@Singleton
class NavigationManager @Inject constructor() {

    /**
     * Возвращает обработчик завершения стартовой анимации.
     */
    var onStartAnimCompleted: () -> Unit by Delegates.notNull()

    /**
     * Устанавливает или возвращает обработчик прехода к авторизации.
     */
    var goToAuth: () -> Unit by Delegates.notNull()

    /**
     * Устанавливает или возвращает главный навигационный контроллер.
     */
    var generalNavController: NavController by Delegates.notNull()

    /**
     * Возвращает или устанавливает навигационный контроллер для нижней панели навигации.
     */
    var currentBottomNavControllerLiveData: LiveData<NavController> by Delegates.notNull()

    /**
     * Возвращает событие необходимости установить конфигурацию для нижнего навигационного бара.
     */
    val isBottomNavigationBarNeedUpdateSingleEvent = SingleLiveEvent<Unit>()

    /**
     * Показывает экран поиска продукции.
     */
    var showSearchProduct: () -> Unit by Delegates.notNull()

    /**
     * Возвращает модель нижнгей панели навигации.
     */
    var bottomAppBarModel = BottomAppBarModel()

    /**
     * Возвращает или устанавливает обработчик выбора пункта меню.
     */
    var onSelectItemMenu: (Int, Bundle) -> Unit by Delegates.notNull()

    /**
     * Возвращает или устанавливает обработчик показа/скрытия нижней панели.
     */
    var onBottomAppBarShowed: (Boolean) -> Unit by Delegates.notNull()

    /**
     * Возвращает или устанавливает флаг показа главного экрана или бонусной программы.
     */
    val isHomeFront = MutableLiveData(true)

    /**
     * Возвращает обработчик нажатия на FAB.
     */
    var onFabClick: () -> Unit by Delegates.notNull()
}