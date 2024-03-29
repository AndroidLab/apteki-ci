package ru.apteka.components.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.apteka.components.R


/**
 * Представляет модель нижнего тул бара.
 */
class BottomAppBarModel {
    val item_1 = MenuItemModel(
        itemId = R.id.home_graph,
        icon = R.drawable.ic_home,
        title = R.string.menu_label_1
    )

    val item_2 = MenuItemModel(
        itemId = R.id.catalog_graph,
        icon = R.drawable.ic_catalog,
        title = R.string.menu_label_2
    )

    val item_3 = MenuItemModel(
        itemId = R.id.stocks_graph,
        icon = R.drawable.ic_stocks,
        title = R.string.menu_label_3
    )

    val item_4 = MenuItemModel(
        itemId = R.id.basket_graph,
        icon = R.drawable.ic_basket,
        title = R.string.menu_label_4,
    )

    val item_5 = MenuItemModel(
        itemId = R.id.menu_graph,
        icon = R.drawable.ic_menu,
        title = R.string.menu_label_5
    )

    /**
     * Обработчик клика по вкладке.
     */
    fun onItemSelected(itemId: Int) {
        _selectedItemId.value = itemId
        onItemSelectedListener?.onClick(itemId)
    }

    private var onItemSelectedListener: OnItemSelectedListener? = null

    private val _selectedItemId = MutableLiveData(R.id.home_graph)

    /**
     * Возвращает индентификатор выбранного пункта.
     */
    val selectedItemId: LiveData<Int> = _selectedItemId


    /**
     * Устанавливает слушатель выбора пункта меню.
     */
    fun setOnItemSelectedListener(l: OnItemSelectedListener) {
        onItemSelectedListener = l
    }


    fun interface OnItemSelectedListener {
        fun onClick(itemId: Int)
    }

    data class MenuItemModel(
        @IdRes val itemId: Int,
        @DrawableRes val icon: Int,
        @StringRes val title: Int
    )
}
