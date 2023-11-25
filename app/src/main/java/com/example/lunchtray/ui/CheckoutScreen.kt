//berikut adalah kode yang membuat tampilan checkout (pembayaran)

package com.example.lunchtray.ui
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.R
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.OrderUiState

@Composable
fun CheckoutScreen( /*terdapat fungsi CheckoutScreen
                    yang mana pada fungsi ini terdapat orderUiState
                    yang berfungsi sebagai penyimpan informasi
                    mengenai pesanan dimulai dari
                    Entree, SideDish, dan Accompaniment*/

    orderUiState: OrderUiState,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column( /*pada tampilan layar check out terdapat
            nota pesanan yang sudah dipesan (Order Summary)
            */
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        Text(   /*ini adalah bagian yang menampilkan text Order Summary
                yang dimana text nya di ambil dari file
                string.xml pada baris ke 12*/
            text = stringResource(R.string.order_summary),
            fontWeight = FontWeight.Bold
        )

        /*pada bagian ini dari baris ke-51 sampai ke-53
        * terdapat fungsi ItemSummary yang digunakan untuk
        * menampilkan informasi mengenai pesanan.*/
        ItemSummary(item = orderUiState.entree, modifier = Modifier.fillMaxWidth())
        ItemSummary(item = orderUiState.sideDish, modifier = Modifier.fillMaxWidth())
        ItemSummary(item = orderUiState.accompaniment, modifier = Modifier.fillMaxWidth())

        Divider(    /*pada bagian ini mengatur
                    1. ketebalan garis putih/pemisah antara
                        Catatan Pemesanan dan total pemesanan
                        (terdapat pada baris-66)
                    2. jarak antara sepasi atas bawah di setiap text
                        (terdapat pada baris ke-67)*/
            thickness = dimensionResource(R.dimen.thickness_divider),
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_small))
        ) /*untuk mengatur hal thickness_divider dan padding_small
            terdapat pada file dimens.xml tepatny apda baris 4 dan 5, */

        OrderSubCost( /*pada bagian ini menampilkan subtotal
                        yaitu, jumlah harga dari menu yang dipilih
                        sebelum dikenakan biaya pajak*/
            resourceId = R.string.subtotal,
            price = orderUiState.itemTotalPrice.formatPrice(),
            Modifier.align(Alignment.End)
        )

        OrderSubCost( /*dan ini adalah bagian yang menampilkan
                        jumlah pajak yang dibayar setelah
                        memilih pesanan,
                        yang nanti  sutotal dan pajak akan di hitung
                        pada bagian total*/
            resourceId = R.string.tax,
            price = orderUiState.orderTax.formatPrice(),
            Modifier.align(Alignment.End)
        )

        Text(   /*berikut ini adalah bagian total, dimana pada bagian ini
                akan memberikan jumlah keseluruhan pesanan yang harus dibayar
                sudah termasuk pajak*/
            text = stringResource(R.string.total, orderUiState.orderTotalPrice.formatPrice()),
            modifier = Modifier.align(Alignment.End),
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth() /*pada bagian ini berfungsi untuk
                                menambah padding untuk disetiap sisi
                                dari tampilan layar checkout*/
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
        )
        {
            OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
                Text(stringResource(R.string.cancel).uppercase())
                /*berikut adalah bagian yang menampilkan tombol cancel
                * di layar checkout*/
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.submit).uppercase())
                /*berikut adalah bagian yang menampilkan tombol Submit
                * di layar checkout*/
            }
        }
    }
}

@Composable
fun ItemSummary(
    item: MenuItem?,
    modifier: Modifier = Modifier
) {
    Row(   /*dibagian ini dibuat baris
           untuk memisahkan antara text item pesanan
           dan harga dari pesanan*/
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(item?.name ?: "") //berikut adalah bagian yang menampilkan item pesanan
        Text(item?.getFormattedPrice() ?: "") //dan berikut adalah bagian yang menampilkan harga dari item yang dipesan
    }
}

@Composable
fun OrderSubCost( /*pada baris ini terdapat fungsi dengan
                    3 parameter didalamnya yaitu; resourceId
                    price dan modifier*/
    @StringRes resourceId: Int,
    price: String, //pada bagian ini, adalah bagian yang berisi nilai harga yang akan ditampilkan.
    modifier: Modifier = Modifier //dibagian ini, adalah bagian yang menyesuaikan tata letak dari komponen
) {
    Text(
        text = stringResource(resourceId, price),
        modifier = modifier
    )
}

@Preview
@Composable
fun CheckoutScreenPreview() {   /*terdapat fungsi CheckoutScreenPreview
                                yang berguna untuk menampilkan tampilan layar
                                checkout*/
    CheckoutScreen(
        orderUiState = OrderUiState(    /*seperti sebelumnya dimana OrderUiState
                                        berguna untuk menyimpan informasi pemesanan
                                        dimulai dari entreeMenuItems (baris164)
                                        sideDishMenuItems (baris 165)
                                        dan accompanimentMenuItems (baris 166)*/
            entree = DataSource.entreeMenuItems[0],
            sideDish = DataSource.sideDishMenuItems[0],
            accompaniment = DataSource.accompanimentMenuItems[0],
            //dan dibawah ini adalah simulai dari
            itemTotalPrice = 15.00,//total harga dari semua pesanan
            orderTax = 1.00,//biaya pajak yang harus dibayar pada pesanan
            orderTotalPrice = 16.00 //total harga pesanan secara keseluruhan dan termasuk pajak
        ),
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    )
}
