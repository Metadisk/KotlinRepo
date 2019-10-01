package firatveral.com.kotlinrepo.adapter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiBuilder {

    private val retrofit: Retrofit

    val service: RestApiService
        get() = retrofit.create<RestApiService>(RestApiService::class.java!!)

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {

        val BASE_URL = "https://api.github.com"
    }
}