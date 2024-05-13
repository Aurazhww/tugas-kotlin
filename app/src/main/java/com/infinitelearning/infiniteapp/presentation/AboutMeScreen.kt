package com.infinitelearning.infiniteapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.infinitelearning.infiniteapp.Navigation.Screen
import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.data.DummyData
import com.infinitelearning.infiniteapp.ui.theme.InfiniteAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutMeScreen (
    navController: NavController
) {
    Column (
        horizontalAlignment =Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)

        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "aura",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Aura Zahwa",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 10.dp),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "aura.zahwa12@gmail.com",
            fontSize = 10.sp,
            modifier = Modifier.padding(top = 10.dp),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Light)

        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "Politeknik Negeri Batam",
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 10.dp),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            text = "Teknik Informatika - Multimedia dan Jaringan",
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 10.dp),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}


