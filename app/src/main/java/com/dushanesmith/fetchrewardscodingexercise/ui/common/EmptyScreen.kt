package com.dushanesmith.fetchrewardscodingexercise.ui.theme.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dushanesmith.fetchrewardscodingexercise.R
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.FetchRewardsCodingExerciseTheme
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.util.dimens.emptyListIconSize
import com.dushanesmith.fetchrewardscodingexercise.ui.theme.util.dimens.mediumPadding1

@Composable
fun EmptyScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(emptyListIconSize),
            painter = painterResource(R.drawable.ic_list),
            contentDescription = "Empty List Icon"
        )
        Text(
            text = "No Items to View",
            modifier = Modifier
                .padding(mediumPadding1)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun previewEmptyScreen() {
    FetchRewardsCodingExerciseTheme {
        EmptyScreen()
    }
}