/*
saya nanda hidayat dengan nim 215410010, saya mengerjakan Praktikum Pemrograman Berbasis Mobile
pada pertemuan 11 menggunakan code solusi dari Project:Aplikasi Lunch Tray
pada android developer. namun tidak semata saya copas begitu saja. akna tetapi saya
membedah kodelab berikut dan mencoba memahami sesuai pemahaman saya dan melakukan beberapa
modifikasi.
 */
package com.example.lunchtray

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lunchtray.ui.theme.LunchTrayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {    // setContent adalah fungsi yang
                        // digunakan untuk menetapkan tata letak antarmuka.

            LunchTrayTheme {
                LunchTrayApp()  //LunchTrayTheme dan LunchTrayApp adalah komponen
                                //yang berkaitan dengan tampilan dari aplikasi LunchTry berikut
                                // selanjutnya akan beralih ke- StartOrderScreen.kt
            }
        }
    }
}
