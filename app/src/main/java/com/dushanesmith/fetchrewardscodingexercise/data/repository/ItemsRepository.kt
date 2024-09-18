package com.dushanesmith.fetchrewardscodingexercise.data.repository

import androidx.paging.PagingData
import com.dushanesmith.fetchrewardscodingexercise.data.model.ListItem
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {

    fun getItemsList(): Flow<PagingData<ListItem>>
}