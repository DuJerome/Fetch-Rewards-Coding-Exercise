package com.dushanesmith.fetchrewardscodingexercise.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dushanesmith.fetchrewardscodingexercise.data.model.ListItem
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.EerieBlack
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.common.ItemView
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.util.dimens.groupingHeight
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.util.dimens.mediumPadding1

/*
Takes the grouped items and displays them with a header and a lazy column of items
 */
@Composable
fun ItemGrouping(itemList: List<ListItem>) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            Modifier
                .background(EerieBlack)
                .fillMaxWidth()
                .height(groupingHeight)
                .align(Alignment.CenterHorizontally)
                .padding(vertical = mediumPadding1),
            contentAlignment = Alignment.Center
        ) {
            Text(color = Color.White, fontSize = 24.sp, text = "Group #${itemList[0].listId}")
        }
        LazyColumn(
            modifier = Modifier
                .height(550.dp)
                .padding(start = mediumPadding1, top = mediumPadding1, end = mediumPadding1),
            verticalArrangement = Arrangement.spacedBy(mediumPadding1)
        ) {
            items(itemList.size) {
                ItemView(itemList[it])
            }
        }
    }
}