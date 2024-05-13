package com.infinitelearning.infiniteapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.model.Explore
import com.infinitelearning.infiniteapp.ui.theme.InfiniteAppTheme

@Composable
fun ExploreItem(
    explore: Explore,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = modifier.fillMaxWidth()   
    ) {
        Image(
            painter = painterResource(id = explore.poster), 
            contentDescription = explore.name,
            modifier = Modifier.fillMaxWidth()
                .size(width = 150.dp, height = 200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = explore.name,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = explore.genre,
            textAlign = TextAlign.Center,
            color = when(explore.genre) {
                "Action" -> Color.Red
                "RomCom" -> Color.Magenta
                else -> MaterialTheme.colorScheme.primary
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun ExploreItemPreview() {
    InfiniteAppTheme {
        ExploreItem(
            explore = Explore(
                id = 1,
                name = "Vagabond",
                genre = "Action",
                poster = R.drawable.vagabond,
                synopsis = "Sinopsis. Sebuah kecelakaan pesawat misterius menewaskan lebih dari 200 warga sipil termasuk keponakan Cha Dal-gun (Lee Seung-gi). Bertekad untuk mencari tahu kebenaran di balik kecelakaan itu, Cha Dal-gun melakukan penyelidikan yang membawanya ke jaringan korupsi yang rumit."
            )
        )
    }
}