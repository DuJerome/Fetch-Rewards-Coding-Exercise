package com.dushanesmith.fetchrewardscodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.dushanesmith.fetchrewardscodingexercise.data.model.ListItem
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.FetchRewardsCodingExerciseTheme
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.common.EmptyScreen
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.common.ItemView
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.util.dimens.smallPadding2
import com.dushanesmith.fetchrewardscodingexercise.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchRewardsCodingExerciseTheme {
                ItemList(itemsList = mainViewModel.getItemsList().collectAsLazyPagingItems())
            }
        }
    }
}

@Composable
fun ItemList(itemsList: LazyPagingItems<ListItem>, modifier: Modifier = Modifier.fillMaxSize()) {
    val items = remember { itemsList }
    if (items.itemCount == 0) {
        EmptyScreen()
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(smallPadding2)
        ) {
            items(items.itemCount) {
                items[it]?.let {
                    ItemView(it)
                }
            }
        }
    }
}