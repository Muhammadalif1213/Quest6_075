package com.example.project8.ui.view.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project8.R
import com.example.project8.model.Mahasiswa
import com.example.project8.model.RencanaStudi

@Composable
fun TampilDetailMahasiswaView(
    mahasiswa: Mahasiswa,
    rencanaStudi: RencanaStudi,
    onBackButtonClicked: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "",
                Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    text = mahasiswa.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.White
                )
                Text(
                    text = mahasiswa.nim,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Box {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)
                )
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Detail Profil Mahasiswa",
                    fontWeight = FontWeight.Bold, fontSize = 16.sp
                )
                Spacer(modifier = Modifier.padding(8.dp))
                CardSection(judulParam = "Nama", isiParam = mahasiswa.nama)
                Spacer(modifier = Modifier.padding(4.dp))
                CardSection(judulParam = "NIM", isiParam = mahasiswa.nim)
                Spacer(modifier = Modifier.padding(4.dp))
                CardSection(judulParam = "Email", isiParam = mahasiswa.email)
                Spacer(modifier = Modifier.padding(4.dp))
                CardSection(judulParam = "Matakuliah", isiParam = rencanaStudi.mataKuliah)
                Spacer(modifier = Modifier.padding(4.dp))
                CardSection(judulParam = "Kelas", isiParam = rencanaStudi.kelas)
                Spacer(modifier = Modifier.padding(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { onBackButtonClicked() }
                    ) {
                        Text("Kembali ke Halaman Utama")
                    }
                }
            }
        }
    }
}

@Composable
fun CardSection(judulParam: String, isiParam: String) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Text(judulParam, modifier = Modifier.weight(0.8f))
            Text(":", modifier = Modifier.weight(0.2f))
            Text(isiParam, modifier = Modifier.weight(2f))
        }
    }
}