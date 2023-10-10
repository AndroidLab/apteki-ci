package ru.apteka.social.domain.login.entity


/**
 * Представляет результат запроса на новый кода.
 * @param success Флаг успеха.
 */
data class NewCodeResult(
    val success: Boolean
)