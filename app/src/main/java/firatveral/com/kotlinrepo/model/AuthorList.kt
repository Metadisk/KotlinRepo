package firatveral.com.kotlinrepo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthorList {

    @SerializedName("login")
    @Expose
    var login: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null
    @SerializedName("gravatar_id")
    @Expose
    var gravatarId: String? = null
}
