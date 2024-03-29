package ru.apteka.choosing_city.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.apteka.choosing_city.data.repository.new_repository.ICitiesApi


@Module
@InstallIn(SingletonComponent::class)
class ChoosingCityApiModule {
    /**
     * Предоставляет экземпляр [ICitiesApi].
     */
    @Provides
    fun provideCitiesApi(retrofitClient: Retrofit): ICitiesApi =
        retrofitClient.create(ICitiesApi::class.java)

}