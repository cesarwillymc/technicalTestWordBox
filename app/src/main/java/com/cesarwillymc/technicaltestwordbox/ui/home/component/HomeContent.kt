package com.cesarwillymc.technicaltestwordbox.ui.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.technicaltestwordbox.R
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person
import com.cesarwillymc.technicaltestwordbox.ui.base.GreenCrossTopAppBar
import com.cesarwillymc.technicaltestwordbox.ui.theme.MiniElevation
import com.cesarwillymc.technicaltestwordbox.ui.theme.Normal100
import com.cesarwillymc.technicaltestwordbox.ui.theme.OnyxBlack

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@Composable
fun HomeContent(onClickPerson: (Person) -> Unit, people: List<Person>) {
    Scaffold(modifier = Modifier, topBar = {
        GreenCrossTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.lbl_home),
                    style = MaterialTheme.typography.h2,
                    color = OnyxBlack
                )
            },
            elevation = MiniElevation
        )
    }) {
        LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(Normal100)) {
            items(people) {
                CardPersonItem(
                    person = it,
                    onClick = onClickPerson
                )
            }
        }
    }
}