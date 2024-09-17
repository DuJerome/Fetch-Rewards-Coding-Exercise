package com.dushanesmith.fetchrewardscodingexercise.ui.theme.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import com.dushanesmith.fetchrewardscodingexercise.data.model.ListItem
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.dimens.cornerRadius
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.dimens.largePadding1
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.dimens.shadowElevation
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.dimens.smallPadding1

@Composable
fun ItemView(listItem: ListItem, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(cornerRadius))
            .shadow(shadowElevation)
    ) {

        Text(text = "List ID:", modifier = Modifier.padding(start = largePadding1, smallPadding1))
        Text(text = listItem.listId.toString(), modifier = Modifier.padding(smallPadding1))

        Spacer(modifier = Modifier.padding(horizontal = largePadding1))
        Text(text = "ID:", modifier = Modifier.padding(smallPadding1))
        Text(text = listItem.id.toString(), modifier = Modifier.padding(smallPadding1))

        Spacer(modifier = Modifier.padding(horizontal = largePadding1))
        Text(text = "Name:", modifier = Modifier.padding(smallPadding1))
        Text(text = listItem.name, modifier = Modifier.padding(smallPadding1))
    }
}


@Preview(showBackground = true)
@Composable
fun ItemViewPreview() {
    ItemView(listItem = ListItem(645, 1, "Item808"))
}