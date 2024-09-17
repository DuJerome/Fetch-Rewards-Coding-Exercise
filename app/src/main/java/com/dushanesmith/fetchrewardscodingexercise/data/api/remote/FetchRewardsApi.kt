package com.dushanesmith.fetchrewardscodingexercise.data.api.remote

import com.dushanesmith.fetchrewardscodingexercise.data.model.Items
import retrofit2.http.GET

interface FetchRewardsApi {

    @GET("hiring.json")
    fun getItems(): Items
}