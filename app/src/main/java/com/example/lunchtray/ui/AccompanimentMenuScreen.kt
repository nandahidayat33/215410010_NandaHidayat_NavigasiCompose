
package com.example.lunchtray.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.AccompanimentItem

@Composable
fun AccompanimentMenuScreen(   /*pada halaman ini, hampir sama seperti pada
                                halaman EntreeMenuScreen.kt, dan AccompanimentMenuScreen.kt
                                yang memiliki logika yang sama seperti 2 halaman sebelumnya.
                                pada halaman ini terdapat juga item-item menu AccompanimentMenuScreen
                                dan juga pada function ini terdapat beberapa fungsi tombol
                                seperti memilih makanan utaman (oneSelectionChanged)
                                yang berbentuk seperti radio button,
                                onCancelButtonClicked (tombol cancel), kemudian
                                onNextButtonClicked (tombol next) seperti 2 halaman sebelumnya
                                dan selanjutnya beralih ke halaman CheckoutScreen.kt*/

    options: List<AccompanimentItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (AccompanimentItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit,
        modifier = modifier
    )
}

@Preview
@Composable
fun AccompanimentMenuPreview(){
    AccompanimentMenuScreen(
        options = DataSource.accompanimentMenuItems,
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        onSelectionChanged = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
}
