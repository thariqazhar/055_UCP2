package com.example.ucp2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun Hal1(
    onNextButtonClicked: () -> Unit
) {
    val image = painterResource(id = R.drawable.d95)
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier,
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.btn_next))
            }
        }
    }
}