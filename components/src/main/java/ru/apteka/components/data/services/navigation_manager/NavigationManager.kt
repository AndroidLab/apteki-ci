package ru.apteka.components.data.services.navigation_manager

import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
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
     * Возвращает или устанавливает идентификаторы пунктов назначения основного экрана.
     */
    var topLevelMainDestinationIds: Set<Int> by Delegates.notNull()

    /**
     * Устанавливает или возвращает главный навигационный контроллер.
     */
    var generalNavController: NavController by Delegates.notNull()

    /**
     * Возвращает или устанавливает навигационный контроллер для нижней панели навигации.
     */
    var currentBottomNavControllerLiveData: LiveData<NavController> by Delegates.notNull()

    /**
     * Возвращает или устанавливает нижний бар навигации.
     */
    var bottomNavBar: BottomNavigationView by Delegates.notNull()


    /**
     * Возвращает или устанавливает выбранную вкладку при переходе на внешние destination, для последующего востановления, при возвращении назад.
     * null если находимся на главном экране.
     */
    var selectedMainDestinationId: Int? = null

    /**
     * Возвращает событие необходимости установить конфигурацию для нижнего навигационного бара.
     */
    val isBottomNavigationBarNeedUpdateSingleEvent = SingleLiveEvent<Unit>()

    /**
     * Навигирует к экрану авторизации.
     */
    var navigateToAuthActivity: () -> Unit by Delegates.notNull()

    /**
     * Показывает меню приложения.
     */
    var showAppMenu: () -> Unit by Delegates.notNull()

}