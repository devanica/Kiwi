package kiwi.app.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Base(
    val position: Int,
    val base: String,
    var isSelected: Boolean) : Parcelable {
}