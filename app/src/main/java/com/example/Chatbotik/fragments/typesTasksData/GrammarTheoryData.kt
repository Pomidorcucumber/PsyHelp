package com.example.Chatbotik.fragments.typesTasksData

import android.os.Parcel
import android.os.Parcelable

data class GrammarTheoryData(
    val title: Int,
    val task: List<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        mutableListOf<String>().apply {
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

    companion object CREATOR : Parcelable.Creator<GrammarTheoryData> {
        override fun createFromParcel(parcel: Parcel): GrammarTheoryData {
            return GrammarTheoryData(parcel)
        }

        override fun newArray(size: Int): Array<GrammarTheoryData?> {
            return arrayOfNulls(size)
        }
    }
}
