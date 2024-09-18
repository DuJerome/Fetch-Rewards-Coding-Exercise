package com.dushanesmith.fetchrewardscodingexercise.data.api.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dushanesmith.fetchrewardscodingexercise.data.model.ListItem

class ItemsPagingSource(
    private val fetchRewardsApi: FetchRewardsApi
): PagingSource<Int, ListItem>() {
    override fun getRefreshKey(state: PagingState<Int, ListItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListItem> {
        return try {
            val itemsResponse = fetchRewardsApi.getItems()

            var itemList: List<ListItem> = itemsResponse.filter { !it.name.isNullOrEmpty() }
            itemList = itemList.sortedWith(compareBy<ListItem> { it.listId }.thenBy { it.name })

            LoadResult.Page(
                data = itemList,
                nextKey = null,
                prevKey = null
            )
        }catch (e: Exception){
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}