package com.dushanesmith.fetchrewardscodingexercise.data.api.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dushanesmith.fetchrewardscodingexercise.data.model.ListItem
import javax.inject.Inject

class ItemsPagingSource @Inject constructor(
    private val fetchRewardsApi: FetchRewardsApi
): PagingSource<Int, ListItem>() {

    /*
    uses the state.anchorPosition to retrieve the closest visible item
    and returns the current page
     */
    override fun getRefreshKey(state: PagingState<Int, ListItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    /*
    Loads the data from fetchRewardsApi and the manipulates the data
    to filter out null and blank names then sorts the list by listId then name

    Note: When viewing the list you will notice Item 269 comes before 27, and
    this is because there is one less value in 27 and also 7 is greater than 6
    this is because we are sorting alphanumerically and so it looks wrong but is
    right
     */
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