package com.dushanesmith.fetchrewardscodingexercise.data

import com.dushanesmith.fetchrewardscodingexercise.data.api.remote.FetchRewardsApi
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.Constants.baseUrl
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
}