package com.cesarwillymc.technicaltestwordbox.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter
import com.cesarwillymc.technicaltestwordbox.R
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person
import com.cesarwillymc.technicaltestwordbox.extension.setUrl
import com.cesarwillymc.technicaltestwordbox.ui.theme.DangerRed
import com.cesarwillymc.technicaltestwordbox.ui.theme.Gray
import com.cesarwillymc.technicaltestwordbox.ui.theme.ImageMini
import com.cesarwillymc.technicaltestwordbox.ui.theme.Normal100
import com.cesarwillymc.technicaltestwordbox.ui.theme.OnyxBlack
import com.cesarwillymc.technicaltestwordbox.ui.theme.Platinum
import com.cesarwillymc.technicaltestwordbox.ui.theme.Small100
import com.cesarwillymc.technicaltestwordbox.ui.theme.Small120
import com.cesarwillymc.technicaltestwordbox.ui.theme.White

/**
 * Created by Willy on 9/12/2021.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 *
 * Is the view that showed each person of the list
 */

@SuppressWarnings("LongMethod")
@Composable
fun CardPersonItem(
    person: Person,
    onClick: (Person) -> Unit
) {

    Column {
        ConstraintLayout(
            modifier = Modifier
                .background(White)
                .fillMaxWidth()
                .padding(horizontal = Normal100, vertical = Small120)
                .clickable(onClick = {
                    onClick(person)
                })
        ) {
            val (icon, column, favorite) = createRefs()
            Image(
                painter = rememberImagePainter(person.photo.setUrl()),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(icon) {
                        top.linkTo(column.top)
                        bottom.linkTo(column.bottom)
                        start.linkTo(parent.start)
                    }
                    .size(ImageMini)
            )
            Column(
                modifier = Modifier.constrainAs(column) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(icon.end, margin = Small100)
                    end.linkTo(favorite.start)
                    width = Dimension.fillToConstraints
                }
            ) {
                Text(
                    text = person.gender,
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Normal),
                    color = Gray,
                )
                Text(
                    text = person.name,
                    style = MaterialTheme.typography.subtitle1,
                    color = OnyxBlack,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_fav),
                contentDescription = null,
                tint = DangerRed,
                modifier = Modifier.constrainAs(favorite) {
                    top.linkTo(column.top)
                    bottom.linkTo(column.bottom)
                    end.linkTo(parent.end)
                }
            )
        }
        Divider(color = Platinum, modifier = Modifier.padding(horizontal = Normal100))
    }
}
