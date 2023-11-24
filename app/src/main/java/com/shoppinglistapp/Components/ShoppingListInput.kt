package com.shoppinglistapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingListInput(value: String, onValueChange: (String) -> Unit) {

    var isFocusedState by remember {
        mutableStateOf<Boolean>(false)
    }

    Box(
        Modifier
            .fillMaxWidth(0.7f).padding(10.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(
                width = 2.dp,
                color = if (isFocusedState) MaterialTheme.colorScheme.primary else Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Done,
                autoCorrect = false,
                capitalization = KeyboardCapitalization.Words,
            )
        )

        if (value.isEmpty()) {
            Text(
                modifier = Modifier.padding(16.dp),
                color = Color.LightGray,
                text = "Adicione seus itens"
            )
        }
    }
}