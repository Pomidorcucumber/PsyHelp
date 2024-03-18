package com.example.Chatbotik.fragments.typesTasksData

import android.os.Parcel
import android.os.Parcelable

data class TextTaskData(
    val title: Int,
    val text: String,
    val task: List<Pair<String, Pair<List<String>, String>>>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        mutableListOf<Pair<String, Pair<List<String>, String>>>().apply {
            parcel.readList(this, Pair::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(title)
        parcel.writeString(text)
        parcel.writeList(task)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TextTaskData> {
        override fun createFromParcel(parcel: Parcel): TextTaskData {
            return TextTaskData(parcel)
        }

        override fun newArray(size: Int): Array<TextTaskData?> {
            return arrayOfNulls(size)
        }
    }
}
