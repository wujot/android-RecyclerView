package com.hemmersbach.android.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("address") var address: String,
    @SerializedName("email") var email: String,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("rating") var rating: Int,
    @SerializedName("imageUrl") var imageUrl: String): Parcelable