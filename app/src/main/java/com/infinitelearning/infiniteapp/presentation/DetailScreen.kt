package com.infinitelearning.infiniteapp.presentation

import android.adservices.adid.AdId
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.data.DummyData
import com.infinitelearning.infiniteapp.model.Cinema
import com.infinitelearning.infiniteapp.model.Explore
import com.infinitelearning.infiniteapp.model.TopCinema
import com.infinitelearning.infiniteapp.ui.theme.InfiniteAppTheme

@Composable
fun DetailScreen(
    modifier: Modifier,
    navController: NavController,
    detailsId: Int?,
) {
    val newDetailsList = DummyData.posterCinema.filter { cinema ->
        cinema.id == detailsId
    }
    Column(
        modifier = modifier
    ) {
        DetailContent(newDetailsList = newDetailsList)
    }
}

@Composable
fun DetailContent(
    newDetailsList: List<Cinema>,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(8.dp)
                .size(width = 100.dp, height = 120.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(
                        data = newDetailsList[0].poster
                    )
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = "gambar untuk Card"
            )
        }
        Spacer(modifier = Modifier.height(1.dp))
        Column {
            Text(
                text = "(${newDetailsList[0].name})",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = "(${newDetailsList[0].genre})",
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = "(${newDetailsList[0].synopsis})",
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Light),
                modifier = Modifier.padding(start = 10.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun DetailContentPreview() {
    DetailContent(newDetailsList = DummyData.posterCinema)
}


