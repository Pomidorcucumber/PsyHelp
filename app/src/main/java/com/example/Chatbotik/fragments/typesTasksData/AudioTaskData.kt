package com.example.Chatbotik.fragments.typesTasksData

import android.os.Parcel
import android.os.Parcelable

data class AudioTaskData(
    val title: Int,
    val task: List<Pair<Int, Pair<String, Pair<List<String>, String>>>>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        mutableListOf<Pair<Int, Pair<String, Pair<List<String>, String>>>>().apply {
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

    companion object CREATOR : Parcelable.Creator<AudioTaskData> {
        override fun createFromParcel(parcel: Parcel): AudioTaskData {
            return AudioTaskData(parcel)
        }

        override fun newArray(size: Int): Array<AudioTaskData?> {
            return arrayOfNulls(size)
        }
    }
}
