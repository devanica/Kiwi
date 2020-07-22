package kiwi.app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ingredient(
    val position: Int,
    val smoothie: Int,
    var isSelected: Boolean) : Parcelable {
}