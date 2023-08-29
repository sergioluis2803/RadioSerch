package com.example.radioserch.features.navigation.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.YoutubeSearchedFor
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.radioserch.R

sealed class ItemsMenu(
    val icon: ImageVector,
    val title: Int,
    val route: String
) {
    object ItemHome : ItemsMenu(Icons.Default.Home, R.string.item_home, "ITEM_HOME")
    object ItemSearch :
        ItemsMenu(Icons.Default.YoutubeSearchedFor, R.string.item_search, "ITEM_SEARCH")
    object ItemLibraryMusic :
        ItemsMenu(Icons.Default.LibraryMusic, R.string.item_library_music, "ITEM_LIBRARY")
}