package firatveral.com.kotlinrepo.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Author {

    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

}
