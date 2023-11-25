/*file dataSource ada file yang berisikan text dari setiap layer yang akan dijalankan
* dimuali dari EntreeMenuScreen yang berisikan menu-menu makanan
* kemudian SideDishMenu yang dimodifikasi menjadi daftar minuman
* serta Accompaniment bersisikan menu tambahan, seperti rokok
* */
package com.example.lunchtray.datasource

import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.model.MenuItem.EntreeItem
import com.example.lunchtray.model.MenuItem.SideDishItem

/**
 * Map of available menu items to be displayed in the menu fragments.
 */
object DataSource {

    val entreeMenuItems = listOf(
        EntreeItem(
            name = "Nasi Padang",
            description =   "Nasi putih,rendang sapi, " +
                            "sambal pedas, dan beragam hidangan Padang",
            price = 10.00,
        ),
        EntreeItem(
            name = "Gudeg Jogja",
            description = "Nasi, nangka muda santan, ayam, telur, dan areh (santan kental).",
            price = 7.00,
        ),
        EntreeItem(
            name = "Sate Klatak",
            description = "Daging kambing muda tanpa tusuk, dipanggang dengan bumbu khas.",
            price = 5.50,
        ),
        EntreeItem(
            name = "Gogos Sulawesi",
            description = "Nasi ketan yang dibungkus daun pisang, diisi dengan kelapa parut, " +
                    "ikan asin, dan santan.",
            price = 5.50,
        )
    )

    val sideDishMenuItems = listOf(
        SideDishItem(
            name = "Es Teh",
            description = "",
            price = 3.00,
        ),
        SideDishItem(
            name = "Es Jeruk",
            description = "",
            price = 3.00,
        ),
        SideDishItem(
            name = "Kopi Hitam Manis",
            description = "",
            price = 3.00,
        ),
        SideDishItem(
            name = "Kopi Susu",
            description = "",
            price = 3.50,
        )
    )

    val accompanimentMenuItems = listOf(
        AccompanimentItem(
            name = "Rokok Surya",
            description = "",
            price = 1.00,
        ),
        AccompanimentItem(
            name = "Rokok Sampoerna",
            description = "",
            price = 1.00,
        ),
        AccompanimentItem(
            name = "Rokok Marlboro",
            description = "",
            price = 1.00,
        ),
        AccompanimentItem(
            name = "Tanpa Rokok",
            description = "",
            price = 0.00,
        )
    )
}
