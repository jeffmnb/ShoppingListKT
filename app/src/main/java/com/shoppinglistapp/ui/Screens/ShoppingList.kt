package com.shoppinglistapp.ui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.shoppinglistapp.ui.Components.CardListSection
import com.shoppinglistapp.ui.Components.InputSection
import com.shoppinglistapp.model.ItemData

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ShoppingList() {

    var shoppingList = remember {
        mutableStateListOf<ItemData>()
    }

    var inputValue by remember {
        mutableStateOf("")
    }

    val focusInput = LocalFocusManager.current

    val keyboardManager = LocalSoftwareKeyboardController.current

    fun handleAddNewItem() {
        if (inputValue.isBlank()) return
        shoppingList.add(ItemData(inputValue, false, shoppingList.size))
        shoppingList.reverse()
        inputValue = ""

        if (keyboardManager !== null) keyboardManager.hide()
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

    Column(Modifier.fillMaxSize().padding(16.dp).pointerInput(Unit) {
        detectTapGestures { offset ->
            focusInput.clearFocus()
        }
    }) {
        TopAppBar(modifier = Modifier.background(Color.White), title = {
            Text(text = "Lista de Compras")
        })

        Spacer(modifier = Modifier.height(16.dp))

        InputSection(newValue = inputValue,
            onAddItemClick = { handleAddNewItem() },
            onNewItemChange = { inputValue = it })

        Spacer(modifier = Modifier.height(16.dp))

        if (shoppingList.isEmpty()) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Todas as tarefas foram feitas : )")
            }
        }

        CardListSection(list = shoppingList,
            onItemChecked = { handleCheckItem(it) },
            onRemoveItem = { shoppingList.remove(it) })
    }
}

