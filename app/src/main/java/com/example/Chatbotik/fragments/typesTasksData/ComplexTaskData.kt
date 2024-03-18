package com.example.Chatbotik.fragments.typesTasksData

import android.os.Parcel
import android.os.Parcelable

data class ComplexTaskData(
    val listTask: List<Int>,
    val audioTask: AudioTaskData,
    val dictionaryTask: DictionaryTaskData,
    val grammarTask: GrammarTaskData,
    val grammarTheoryTask: GrammarTheoryData,
    val textTask: TextTaskData,
    val writingTask: WritingTaskData
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createIntArray()?.toList()!!,
        parcel.readParcelable(AudioTaskData::class.java.classLoader)!!,
        parcel.readParcelable(DictionaryTaskData::class.java.classLoader)!!,
        parcel.readParcelable(GrammarTaskData::class.java.classLoader)!!,
        parcel.readParcelable(GrammarTheoryData::class.java.classLoader)!!,
        parcel.readParcelable(TextTaskData::class.java.classLoader)!!,
        parcel.readParcelable(WritingTaskData::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeIntArray(listTask.toIntArray())
        parcel.writeParcelable(audioTask, flags)
        parcel.writeParcelable(dictionaryTask, flags)
        parcel.writeParcelable(grammarTask, flags)
        parcel.writeParcelable(grammarTheoryTask, flags)
        parcel.writeParcelable(textTask, flags)
        parcel.writeParcelable(writingTask, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ComplexTaskData> {
        override fun createFromParcel(parcel: Parcel): ComplexTaskData {
            return ComplexTaskData(parcel)
        }

        override fun newArray(size: Int): Array<ComplexTaskData?> {
            return arrayOfNulls(size)
        }
    }
}
