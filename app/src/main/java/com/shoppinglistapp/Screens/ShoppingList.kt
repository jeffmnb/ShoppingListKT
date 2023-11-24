package com.shoppinglistapp.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shoppinglistapp.Components.CardListSection
import com.shoppinglistapp.Components.InputSection
import com.shoppinglistapp.ItemData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingList() {

    var shoppingList = remember {
        mutableStateListOf(
            ItemData(id = 0, title = "Banana", checked = false),
            ItemData(id = 1, title = "Maça", checked = false),
            ItemData(id = 2, title = "Leite", checked = false),
            ItemData(id = 3, title = "Feijão", checked = false),
            ItemData(id = 4, title = "Arroz", checked = false)
        )
    }


    var newItems by remember {
        mutableStateOf("")
    }

    fun handleAddNewItem() {
        if (newItems.isNotBlank()) {
            shoppingList.add(ItemData(newItems, false, shoppingList.size))
            newItems = ""
        }
    }


    fun handleCheckItem(item: ItemData) {
        val index = shoppingList.indexOf(item)

        if (index != -1) {
            val updatedList = shoppingList.toMutableList()
            updatedList[index].checked = !updatedList[index].checked
            shoppingList.clear()
            shoppingList.addAll(updatedList)
        }
    }



    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar(modifier = Modifier.background(Color.White), title = {
            Text(text = "Lista de Compras")
        })

        Spacer(modifier = Modifier.height(16.dp))

        InputSection(newValue = newItems,
            onAddItemClick = { handleAddNewItem() },
            onNewItemChange = { newItems = it })

        Spacer(modifier = Modifier.height(16.dp))

        CardListSection(list = shoppingList,
            onItemChecked = { handleCheckItem(it) },
            onRemoveItem = { shoppingList.remove(it) })
    }
}

