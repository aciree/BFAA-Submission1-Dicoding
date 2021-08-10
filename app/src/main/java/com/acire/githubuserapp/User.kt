package com.acire.githubuserapp

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class User(
    val photo: Int = 0,
    val name: String? = "",
    val username: String? = "",
    val location: String? = "",
    val company: String? = "",
    val repository: String? = "",
    val followers: String? = "",
    val following: String? = ""
) : Parcelable