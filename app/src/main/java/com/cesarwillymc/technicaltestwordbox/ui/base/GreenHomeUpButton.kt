package com.cesarwillymc.technicaltestwordbox.ui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.cesarwillymc.technicaltestwordbox.R
import com.cesarwillymc.technicaltestwordbox.ui.theme.Cultured
import com.cesarwillymc.technicaltestwordbox.ui.theme.Large100
import com.cesarwillymc.technicaltestwordbox.ui.theme.OnyxBlack
import com.cesarwillymc.technicaltestwordbox.ui.theme.Small100

@Composable
fun GreenHomeUpButton(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit
) {
    IconButton(
        onClick = onNavigateUp,
        modifier = modifier
            .padding(start = Small100)
            .size(Large100)
            .clip(CircleShape)
            .background(color = Cultured)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            tint = OnyxBlack
        )
    }
}
