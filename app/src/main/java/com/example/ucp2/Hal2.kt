package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Hal2(
    dosenpembimbing1: List<String>,
    dosenpembimbing2: List<String>,
    onSelectionChanged1: (String) -> Unit,
    onSelectionChanged2: (String) -> Unit,
    onSubmitClicked: (MutableList<String>) -> Unit
) {
    var nama by rememberSaveable {
        mutableStateOf("")
    }
    var nim by rememberSaveable {
        mutableStateOf("")
    }
    var kons by rememberSaveable {
        mutableStateOf("")
    }
    var judul by remember {
        mutableStateOf("")
    }
    var dospem1 by remember {
        mutableStateOf("")
    }
    var dospem2 by remember {
        mutableStateOf("")
    }
    var listData: MutableList<String> = mutableListOf(nama, nim, kons, judul)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(
                    stringResource(id = R.string.judul),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = { Text(stringResource(id = R.string.nama)) },
                )
                OutlinedTextField(
                    value = nim,
                    onValueChange = { nim = it },
                    label = { Text(stringResource(id = R.string.nim)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
                OutlinedTextField(
                    value = kons,
                    onValueChange = { kons = it },
                    label = { Text(stringResource(id = R.string.kons)) }
                )
                OutlinedTextField(
                    value = judul,
                    onValueChange = { judul = it },
                    label = { Text(stringResource(id = R.string.jdl)) }
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(stringResource(id = R.string.dospem_1))
                    Text(stringResource(id = R.string.dospem_2))
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column {
                        dosenpembimbing1.forEach { item ->
                            Row(
                                modifier = Modifier.selectable(
                                    selected = dospem1 == item,
                                    onClick = {
                                        dospem1 = item
                                        onSelectionChanged1(item)
                                    }
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(selected = dospem1 == item, onClick = {
                                    dospem1 = item
                                    onSelectionChanged1(item)
                                }
                                )
                                Text(item)
                            }
                        }
                    }
                    Column {
                        dosenpembimbing2.forEach { item ->
                            Row(
                                modifier = Modifier.selectable(
                                    selected = dospem2 == item,
                                    onClick = {
                                        dospem2 = item
                                        onSelectionChanged2(item)
                                    }
                                ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(selected = dospem2 == item, onClick = {
                                    dospem2 = item
                                    onSelectionChanged2(item)
                                }
                                )
                                Text(item)
                            }
                        }
                    }
                }
                Button(
                    onClick = { onSubmitClicked(listData) },
                    enabled = nama.isNotEmpty() && nim.isNotEmpty() && kons.isNotEmpty() && judul.isNotEmpty() && dospem1.isNotEmpty() && dospem2.isNotEmpty(),

                    ) {
                    Text(stringResource(id = R.string.btn_submit))
                }
            }
        }
    }
}