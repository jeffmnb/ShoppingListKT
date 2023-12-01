package com.shoppinglistapp.ui.Components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shoppinglistapp.model.ItemData

@Composable
fun CardListSection(
    list: List<ItemData>, onRemoveItem: (ItemData) -> Unit, onItemChecked: (ItemData) -> Unit
) {
    LazyColumn(
        Modifier.fillMaxSize(), contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(list.size) { index ->
            CardItem(list[index], onRemoveItem = onRemoveItem, onItemChecked = onItemChecked)
        }
    }
}