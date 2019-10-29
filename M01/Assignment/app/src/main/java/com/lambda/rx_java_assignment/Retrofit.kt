package com.lambda.rx_java_assignment

import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.Retrofit.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroCalls{
    @GET("jsonI.php")
    fun randomNumbers(@Query("amount")amount: Int,
                      @Query("type")type: String): Single<Numbers>

}

object InitializeRetro{
    fun startRetroCalls(): RetroCalls {
        return Builder()
            .baseUrl("http://qrng.anu.edu.au/API/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RetroCalls::class.java)
    }
}