package com.den.exercise2.ui.theme.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.den.exercise2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    pilihan: List<String>,
    onSelectionChanged: (String) -> Unit,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var namaTxt by remember {
        mutableStateOf("")
    }
    var nimTxt by remember {
        mutableStateOf("")
    }
    var konsTxt by remember {
        mutableStateOf("")
    }
    var judulTxt by remember {
        mutableStateOf("")
    }
    var pertamaygDipilih by rememberSaveable {
        mutableStateOf("")
    }
    var keduaygDipilih by rememberSaveable {
        mutableStateOf("")
    }

    var listData: MutableList<String> = mutableListOf(namaTxt, nimTxt, konsTxt, judulTxt)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Formulir Pengajuan Skripsi",
            modifier = Modifier.padding(20.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = namaTxt,
            onValueChange = { namaTxt = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.nama
                    )
                )
            }
        )
        OutlinedTextField(
            value = nimTxt,
            onValueChange = { nimTxt = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.nim
                    )
                )
            }
        )
        OutlinedTextField(
            value = konsTxt,
            onValueChange = { konsTxt = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.konsentrasi
                    )
                )
            }
        )
        OutlinedTextField(
            value = judulTxt,
            onValueChange = { judulTxt = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.judul
                    )
                )
            }
        )

        Row(modifier = Modifier) {
            pilihan.forEach { item ->
                Column(
                    modifier = Modifier.selectable(selected = pertamaygDipilih == item,
                        onClick = {
                            pertamaygDipilih = item
                            onSelectionChanged(item)
                        }
                    )
                ) {
                    RadioButton(
                        selected = pertamaygDipilih == item,
                        onClick = {
                            pertamaygDipilih = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }
        }
        Row(modifier = Modifier) {
            pilihan.forEach { item ->
                Column(
                    modifier = Modifier.selectable(selected = keduaygDipilih == item,
                        onClick = {
                            keduaygDipilih = item
                            onSelectionChanged(item)
                        }
                    )
                ) {
                    RadioButton(
                        selected = keduaygDipilih == item,
                        onClick = {
                            keduaygDipilih = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .weight(1f, false)
        ) {
            Button(
                onClick = { onSubmitButtonClicked(listData) },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForm() {
    
}