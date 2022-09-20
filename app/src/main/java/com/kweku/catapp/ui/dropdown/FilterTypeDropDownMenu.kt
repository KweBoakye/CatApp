package com.kweku.catapp.ui.dropdown

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kweku.catapp.R
import com.kweku.catapp.data.requstparams.AllMimeTypes
import com.kweku.catapp.data.requstparams.GifMimeType
import com.kweku.catapp.data.requstparams.JpgMimeType
import com.kweku.catapp.data.requstparams.MimeType
import com.kweku.catapp.data.requstparams.PngMimeType

@Composable
fun FilterTypeDropDownMenu(
    options: List<FilterTypeDropDownMenuItemType>,
    onOptionsSelected: (FilterTypeDropDownMenuItemType) -> Unit,
    modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }
    var selectedItem: FilterTypeDropDownMenuItemType by remember { mutableStateOf(AllFilter) }
    //var checked by rememberSaveable { mutableStateOf(AllFilter) }
    Box(modifier = modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopStart)){
        FilterTypeDropDownButton(buttonText = stringResource(id = R.string.filter_mime_type)) {
            expanded = !expanded
        }
        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                FilterTypeDropDownMenuItem(onClick = { onOptionsSelected(option)
                    selectedItem = option
                    expanded = false},
                    option = option,
                    isSelected = (option == selectedItem)
                    )
            }
        }
    }
}

@Composable
fun FilterTypeDropDownMenuItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    option: FilterTypeDropDownMenuItemType,
    isSelected: Boolean
){
    DropdownMenuItem(onClick = onClick) {
        Checkbox(checked = isSelected,
            onCheckedChange = {onClick() })
        Text(option.typeName)
    }
}

fun filterTypeToMimeType(
    filterTypeDropDownMenuItemType: FilterTypeDropDownMenuItemType
):MimeType{
    return when(filterTypeDropDownMenuItemType){
        is GifFilter -> GifMimeType
        is JpgFilter -> JpgMimeType
        is PngFilter -> PngMimeType
        is AllFilter -> AllMimeTypes
    }
}



@Composable
fun FilterTypeDropDownButton(
    buttonText: String,
    onClick: () -> Unit
    ){
    Button(onClick = onClick) {
        Text(buttonText)
        Icon(imageVector = Icons.Filled.ArrowDropDown,
        contentDescription = null
            )
    }
}

@Preview(showBackground = true)
@Composable
fun FilterTypeDropDownButtonPreview(){
    FilterTypeDropDownButton(buttonText = "Filter") {
        
    }
}