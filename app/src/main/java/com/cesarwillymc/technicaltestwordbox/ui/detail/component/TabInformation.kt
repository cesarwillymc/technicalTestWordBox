package com.cesarwillymc.technicaltestwordbox.ui.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cesarwillymc.technicaltestwordbox.ui.theme.Normal100
import com.cesarwillymc.technicaltestwordbox.ui.theme.OnyxBlack
import com.cesarwillymc.technicaltestwordbox.ui.theme.Small100
import com.cesarwillymc.technicaltestwordbox.ui.theme.TextLarge

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@Composable
fun TabInformation(title: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1.copy(fontSize = TextLarge),
            color = OnyxBlack,
            modifier = Modifier.padding(vertical = Normal100)
        )
        Spacer(modifier = Modifier.height(Small100))
        Text(
            text = value,
            style = MaterialTheme.typography.body1,
            color = OnyxBlack,
            modifier = Modifier.padding(vertical = Normal100)
        )

    }
}