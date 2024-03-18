package com.example.Chatbotik.fragments.typesTasksData

import android.os.Parcel
import android.os.Parcelable

data class GrammarTaskData(
    val title: Int,
    val task: List<Pair<Pair<String, String>, Int>>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        mutableListOf<Pair<Pair<String, String>, Int>>().apply {
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

    companion object CREATOR : Parcelable.Creator<GrammarTaskData> {
        override fun createFromParcel(parcel: Parcel): GrammarTaskData {
            return GrammarTaskData(parcel)
        }

        override fun newArray(size: Int): Array<GrammarTaskData?> {
            return arrayOfNulls(size)
        }
    }
}
