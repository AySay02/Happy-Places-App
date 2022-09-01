package com.example.happyplaces.models

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class HappyPlaceModel(
    val id: Int,
    val title: String?,
    val image : String?,
    val description:String?,
    val date:String?,
    val location:String?,
    val longitude:Double,
    val latitude:Double
) : Serializable
//    : Parcelable {    // to let it pass through intent/ or use seriazable
//    constructor(parcel: Parcel) : this(
//        parcel.readInt(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readDouble(),
//        parcel.readDouble()
//    ) {
//    }
//
//    override fun describeContents(): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun writeToParcel(dest: Parcel?, flags: Int) {
//        TODO("Not yet implemented")
//    }
//
//    companion object CREATOR : Parcelable.Creator<HappyPlaceModel> {
//        override fun createFromParcel(parcel: Parcel): HappyPlaceModel {
//            return HappyPlaceModel(parcel)
//        }
//
//        override fun newArray(size: Int): Array<HappyPlaceModel?> {
//            return arrayOfNulls(size)
//        }
//    }
//}