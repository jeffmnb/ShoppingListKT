package com.shoppinglistapp.Components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.shoppinglistapp.ItemData

@Composable
fun CardItem(
    item: ItemData, onItemChecked: (ItemData) -> Unit, onRemoveItem: (ItemData) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .graphicsLayer(shape = MaterialTheme.shapes.medium, shadowElevation = 8F)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = item.checked,
                onCheckedChange = { onItemChecked(item) },
                modifier = Modifier.padding(end = 16.dp)
            )

            Text(
                text = item.title,
                modifier = Modifier.weight(1F),
                textDecoration = if (item.checked) TextDecoration.LineThrough else TextDecoration.None
            )

            IconButton(onClick = { onRemoveItem(item) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "deleteIcon")
            }
        }
    }
}