package com.example.lunchtray.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lunchtray.R

@Composable
fun StartOrderScreen(   /*terdapat fungsi StartOrderScreen
                        yang menampilkan layar awal dari aplikasi Lunch Try
                        dan dilama fungsi ini terdapat column
                        */
    onStartOrderButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column( /*berikut adalah column yang dimaksud
            dimana di dalam colum ini terdapat button*/

        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button( /*ini adalah button yg dimaksud
                dimana pada column ini, adalah clum
                untuk mulai melakukan pemesanan.
                dan terdapat parameter onclick*/

            onClick = onStartOrderButtonClicked,    /*ini adalah parameter onclick
                                                    yang jika tombol mulai memesan di klik
                                                    maka akan terjadi aksi navigation.
                                                    dan akan mengarah pada halaman EntreemenuScreen.kt*/
            Modifier.widthIn(min = 250.dp)
        ) {
            Text(stringResource(R.string.start_order))
        }
    }
}

@Preview
@Composable
fun StartOrderPreview(){
    StartOrderScreen(
        onStartOrderButtonClicked = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxSize()
    )
}
