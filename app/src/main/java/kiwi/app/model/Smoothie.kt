package kiwi.app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Smoothie(
    val id: Int,
    val smoothie: String,
    val base: String,
    val source: String,
    val recipe: String,
    val ingredients: String) : Parcelable {

}