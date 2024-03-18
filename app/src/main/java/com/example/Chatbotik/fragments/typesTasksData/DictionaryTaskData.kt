package com.example.Chatbotik.fragments.typesTasksData

import android.os.Parcel
import android.os.Parcelable

data class DictionaryTaskData(
    val title: Int,
    val task: List<Pair<String, String>>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        mutableListOf<Pair<String, String>>().apply {
            parcel.readList(this, Pair::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(title)
        parcel.writeList(task)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DictionaryTaskData> {
        override fun createFromParcel(parcel: Parcel): DictionaryTaskData {
            return DictionaryTaskData(parcel)
        }

        override fun newArray(size: Int): Array<DictionaryTaskData?> {
            return arrayOfNulls(size)
        }
    }
}
