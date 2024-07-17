package br.com.apkdoandroid.mysearchbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mysearchbar(
    modifier : Modifier = Modifier,
    query : String = "",
    placeholder : String = "",
    onQueryChange : (String) -> Unit
) {
    var active by remember{ mutableStateOf(false) }
    SearchBar(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        query = query ,
        onQueryChange = {onQueryChange(it)},
        onSearch = {},
        active = false,
        onActiveChange = {
          //  active = !active
                         },
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .clickable {  },
                imageVector =  Icons.Rounded.Search,
                contentDescription = null)
                      },
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .clickable {
                        onQueryChange("")
                       // active = false
                               },
                imageVector = Icons.Rounded.Clear,
                contentDescription = null)
                       },
        placeholder = { Text(text = placeholder)},
        content = {
            repeat(10){
                Text(text = "Texto $it")
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun mysearchbarPreview() {
    var query by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        mysearchbar(
            query = query,
            placeholder = "Pesquisar",
            onQueryChange = {query = it}
        )
    }
}