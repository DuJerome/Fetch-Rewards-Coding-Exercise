package com.dushanesmith.fetchrewardscodingexercise.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dushanesmith.fetchrewardscodingexercise.data.model.Items
import com.dushanesmith.fetchrewardscodingexercise.data.model.ListItem
import com.dushanesmith.fetchrewardscodingexercise.data.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemsRepository: ItemsRepository
) : ViewModel() {
    fun getItemsList(): Flow<PagingData<ListItem>> =
        itemsRepository.getItemsList().cachedIn(viewModelScope)
}