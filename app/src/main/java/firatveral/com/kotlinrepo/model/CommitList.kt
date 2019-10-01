package firatveral.com.kotlinrepo.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class CommitList protected constructor(`in`: Parcel) : Parcelable {

    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("author")
    @Expose
    var author: Author? = null
    @SerializedName("message")
    @Expose
    var message: String? = null

    init {
        message = `in`.readString()
        url = `in`.readString()

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(author.toString())
        parcel.writeString(message)
    }

    companion object {


        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<Commit> = object : Parcelable.Creator<Commit> {
            override fun createFromParcel(`in`: Parcel): Commit {
                return Commit(`in`)
            }

            override fun newArray(size: Int): Array<Commit?> {
                return arrayOfNulls<Commit>(size)
            }
        }
    }
}
