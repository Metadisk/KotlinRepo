package firatveral.com.kotlinrepo.adapter

import firatveral.com.kotlinrepo.model.KotlinList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RestApiService {

    @GET("/search/commits")
    fun getUserList(
        @Header("Content-Type") content_type: String, @Header("Accept") accept: String, @Query(
            "q"
        ) filter: String
    ): Call<KotlinList>

}
