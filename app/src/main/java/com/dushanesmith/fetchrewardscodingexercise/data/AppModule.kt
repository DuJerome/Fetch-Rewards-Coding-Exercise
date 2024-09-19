package com.dushanesmith.fetchrewardscodingexercise.data

import com.dushanesmith.fetchrewardscodingexercise.data.api.remote.FetchRewardsApi
import com.dushanesmith.fetchrewardscodingexercise.data.api.remote.ItemsPagingSource
import com.dushanesmith.fetchrewardscodingexercise.data.repository.ItemsRepository
import com.dushanesmith.fetchrewardscodingexercise.data.repository.ItemsRepositoryImpl
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.util.Constants.baseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFetchRewardsApi(): FetchRewardsApi{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FetchRewardsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesItemsPagingSource(
        fetchRewardsApi: FetchRewardsApi
    ): ItemsPagingSource{
        return ItemsPagingSource(fetchRewardsApi)
    }

    @Provides
    @Singleton
    fun provideItemsRepository(
        fetchRewardsApi: FetchRewardsApi
    ): ItemsRepository{
        return ItemsRepositoryImpl(fetchRewardsApi)
    }
}