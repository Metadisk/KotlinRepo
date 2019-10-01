package firatveral.com.kotlinrepo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Nsikak  Thompson on 3/11/2017.
 */

class KotlinList {

    @SerializedName("items")
    @Expose
    var items: List<Commit>? = null
}