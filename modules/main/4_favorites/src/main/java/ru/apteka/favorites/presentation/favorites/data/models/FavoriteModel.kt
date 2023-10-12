package ru.apteka.favorites.presentation.favorites.data.models

import ru.apteka.components.data.models.LabelModel
import java.util.UUID


/**
 * Представляет модель для карточки избранного.
 */
data class FavoriteModel(
    val id: UUID,
    val imageSrc: String,
    val title: String,
    val description: String,
    val labels: List<LabelModel> = emptyList(),
    val price: String? = null,
    val oldPrice: String? = null,
    val discount: String? = null
)