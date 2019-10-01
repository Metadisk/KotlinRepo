package firatveral.com.kotlinrepo.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Commit(`in`: Parcel) : Parcelable {


    @SerializedName("author")
    @Expose
    var author: AuthorList? = null
    @SerializedName("commit")
    @Expose
    var commit: CommitList? = null

    init {
        `in`.readString()
        `in`.readString()

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(author.toString())
        parcel.writeString(commit.toString())
    }

    companion object {

        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<Commit> = object : Parcelable.Creator<Commit> {
            override fun createFromParcel(`in`: Parcel): Commit {
                return Commit(`in`)
            }

            override fun newArray(size: Int): Array<Commit?> {
                return arrayOfNulls(size)
            }
        }
    }

}
