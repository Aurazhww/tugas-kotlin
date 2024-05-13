package com.infinitelearning.infiniteapp.model

import android.provider.ContactsContract.CommonDataKinds.Photo

data class Explore (
    val id: Int,
    val poster: Int,
    val name: String,
    val genre: String,
    val synopsis: String
)