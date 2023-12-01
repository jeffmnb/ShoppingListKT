package com.shoppinglistapp.ui.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputSection(newValue: String, onAddItemClick: () -> Unit, onNewItemChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShoppingListInput(value = newValue, onValueChange = { onNewItemChange(it) })


        Button(modifier = Modifier .height(55.dp), shape = MaterialTheme.shapes.small,onClick = { onAddItemClick() }) {
            Text(text = "Add")
        }
    }
}