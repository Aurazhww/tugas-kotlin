package com.infinitelearning.infiniteapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.infinitelearning.infiniteapp.Navigation.Screen
import com.infinitelearning.infiniteapp.data.DummyData
import com.infinitelearning.infiniteapp.model.Explore
import com.infinitelearning.infiniteapp.presentation.component.ExploreItem

@Composable
fun ExploreScreen(
    explores : List<Explore> = DummyData.allKorea,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(explores) {
            ExploreItem(explore = it)
        }
    }
}