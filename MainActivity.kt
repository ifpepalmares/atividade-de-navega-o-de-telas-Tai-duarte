package com.example.taianemobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class ItemLoja(
    val id: Int,
    val nome: String,
    var comprado: Boolean = false,
)

@Composable
fun ListaComprasScreen(
    modifier: Modifier = Modifier,
) {
    val itens = remember {
        mutableStateListOf(
            ItemLoja(1, "Roupa"),
            ItemLoja(2, "Perfume"),
            ItemLoja(3, "Maquiagem"),
            ItemLoja(4, "Objetos pessoais"),
            ItemLoja(5, "Objetos domesticos"),
            ItemLoja(6, "Moveis"),
            ItemLoja(7, "Pet shop"),
            ItemLoja(8, "Higiene pessoal"),
            ItemLoja(9, "Bebidas"),
            ItemLoja(10, "Decoração"),
            ItemLoja(11, "Saúde"),
            ItemLoja(12, "Jardim"),
            ItemLoja(13, "Festa"),

        )
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            items = itens,
            key = { it.id },
        ) { item ->
            ItemCompraRow(
                item = item,
                onCompradoChange = { marcado -> item.comprado = marcado },
            )
        }
    }
}





@Composable
private fun ItemCompraRow(
    item: ItemLoja,
    modifier: Modifier = Modifier,
    onCompradoChange: (Boolean) -> Unit,
) {
    androidx.compose.foundation.layout.Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Checkbox(
            checked = item.comprado,
            onCheckedChange = onCompradoChange,
        )
        Text(
            text = item.nome,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ListaComprasScreenPreview() {
    MaterialTheme {
        ListaComprasScreen()
    }
}