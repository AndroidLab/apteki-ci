package ru.apteka.profile.data.models

import java.util.UUID

/**
 * Представляет модель комментария.
 */
data class CommentModel(
    val image: String,
    val title: String,
    val text: String,
    val answers: List<String>,
    val id: UUID = UUID.randomUUID()
)
