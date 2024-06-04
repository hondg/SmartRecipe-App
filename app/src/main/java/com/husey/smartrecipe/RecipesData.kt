package com.husey.smartrecipe
import android.os.Parcel
import android.os.Parcelable



data class Recipe(
    val id: Int,
    val name: String,
    val instructions: String,
    val image: String,
    val ingredientsParts: String,
    val calories: String,
    //var isFavorite: Boolean = false
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(instructions)
        parcel.writeString(image)
        parcel.writeString(ingredientsParts)
        parcel.writeString(calories)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}




