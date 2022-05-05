package com.cesarwillymc.technicaltestwordbox.ui.detail.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.technicaltestwordbox.R
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person
import com.cesarwillymc.technicaltestwordbox.extension.setUrl
import com.cesarwillymc.technicaltestwordbox.ui.base.GreenCrossSimpleScaffold
import com.cesarwillymc.technicaltestwordbox.ui.theme.ImageLarge
import com.cesarwillymc.technicaltestwordbox.ui.theme.Small100

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@ExperimentalComposeUiApi
@Composable
fun DetailContent(
    onNavigateUp: () -> Unit,
    person: Person?
) {
    GreenCrossSimpleScaffold(
        navigateUp = onNavigateUp,
        toolbarTitle = stringResource(R.string.lbl_personal_information)
    ) {
        person?.apply {
            LazyColumn(
                contentPadding = PaddingValues(Small100),
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    ZoomImage(
                        imageUrl = photo.setUrl(),
                        height = ImageLarge,
                    )
                }
                item {
                    TabInformation(
                        stringResource(R.string.til_fullname),
                        name
                    )
                }
                item {
                    TabInformation(
                        stringResource(R.string.til_email),
                        email
                    )
                }
                item {
                    TabInformation(
                        stringResource(R.string.til_gender),
                        gender
                    )
                }
                item {
                    TabInformation(
                        stringResource(R.string.til_age),
                        age.toString()
                    )
                }
                item {
                    TabInformation(
                        stringResource(R.string.til_country),
                        country
                    )
                }
            }
        }

    }
}