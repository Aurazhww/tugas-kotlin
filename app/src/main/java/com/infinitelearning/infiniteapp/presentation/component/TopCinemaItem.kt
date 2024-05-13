package com.infinitelearning.infiniteapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.model.Cinema
import com.infinitelearning.infiniteapp.model.TopCinema
//import com.infinitelearning.infiniteapp.presentation.TopCinemaItem
import com.infinitelearning.infiniteapp.ui.theme.InfiniteAppTheme

@Composable
fun TopCinemaItem(
    top : TopCinema,
    modifier: Modifier,
) {
    Row (
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier.fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = top.poster),
            contentDescription = top.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 15.dp, top = 5.dp,bottom = 5.dp)
                .size(80.dp)
                .border(2.dp, Color.LightGray, CircleShape)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(1.dp))
        Column {
            Text(
                text = top.name,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(start = 10.dp))
            Text(
                text = top.genre,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Normal),
                modifier = Modifier.padding(start = 10.dp))
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//private fun TopCinemaItemPreview() {
//    InfiniteAppTheme {
//        TopCinemaItem(
//            top = TopCinema(
//                1,
//                "20 Century Girl",
//                "RomCom",
//                R.drawable.centurygirl
//            ),
//            modifier = Modifier
//        )
//    }
//}