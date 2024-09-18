package com.dushanesmith.fetchrewardscodingexercise.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dushanesmith.fetchrewardscodingexercise.data.api.remote.FetchRewardsApi
import com.dushanesmith.fetchrewardscodingexercise.data.api.remote.ItemsPagingSource
import com.dushanesmith.fetchrewardscodingexercise.data.model.Items
import com.dushanesmith.fetchrewardscodingexercise.data.model.ListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val fetchRewardsApi: FetchRewardsApi
) : ItemsRepository {
    override fun getItemsList(): Flow<PagingData<ListItem>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                ItemsPagingSource(fetchRewardsApi = fetchRewardsApi)
            }
        ).flow
    }
}