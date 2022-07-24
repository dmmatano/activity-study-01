package com.example.activitystudyapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name: String?,
    val birthDeath: String?,
    val photo: Int?
) : Parcelable

/**
 * A biblioteca kotlinx possibilita a anotação @Parcelize, que faz tudo isso que está comentado nas
 * linhas abaixo. Bem mais fácil, não acha? rs
 */
//data class User(
//    val name: String?,
//    val birthDeath: String?,
//    val photo: Int?
//) : Parcelable{
//    constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readInt()
//    ) {
//    }
//
//    override fun describeContents(): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun writeToParcel(p0: Parcel?, p1: Int) {
//        TODO("Not yet implemented")
//    }
//
//    companion object CREATOR : Parcelable.Creator<User> {
//        override fun createFromParcel(parcel: Parcel): User {
//            return User(parcel)
//        }
//
//        override fun newArray(size: Int): Array<User?> {
//            return arrayOfNulls(size)
//        }
//    }
//
//}