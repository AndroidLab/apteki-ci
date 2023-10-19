package ru.apteka.components.data.services.user


import android.content.Context
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import ru.apteka.components.data.utils.PreferencesDelegate
import ru.apteka.components.data.services.user.models.CityModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Представляет предпочтения выбранного города.
 * @param context Контекст приложения.
 */
@Singleton
class UserPreferences @Inject constructor(
    @ApplicationContext context: Context
) {

    companion object {
        private const val CITY = "city"
        private const val ORDER_FILTERS = "order_filters"
    }

    private val userPref =
        context.getSharedPreferences(UserPreferences::class.java.simpleName, Context.MODE_PRIVATE)

    private val _cityFlow = MutableSharedFlow<CityModel?>(replay = 1)

    /**
     * Возвращает поток последнего времени проверки.
     */
    val cityFlow: SharedFlow<CityModel?> = _cityFlow

    /**
     * Возвращет или устанавливает текущий город.
     */
    var city: CityModel? by PreferencesDelegate(
        userPref,
        CITY,
        null, {
            it?.let { Gson().toJson(it) } ?: ""
        }, {
            if (it == "") null else Gson().fromJson(it, CityModel::class.java)
        },
        prefFlow = _cityFlow
    )


    /**
     * Возвращет или устанавливает выбранные фильтры заказов.
     */
    var disabledOrderFilters: Set<String> by PreferencesDelegate<Set<String>, Set<String>>(
        userPref,
        ORDER_FILTERS,
        setOf()
    )

}