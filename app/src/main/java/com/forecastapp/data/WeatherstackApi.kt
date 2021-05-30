package com.forecastapp.data

import com.forecastapp.network.apiresponse.CurrentWeaterResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "http://api.weatherstack.com/"
const val API_KEY = "b09475dccadd3147bc8c1fb879db1795"

// http://api.weatherstack.com/current?access_key=b09475dccadd3147bc8c1fb879db1795&query=New%20York

interface WeatherstackApi {

    @GET("current")
    fun getCurrentWeater(
        @Query("query") location: String
    ): Deferred<CurrentWeaterResponse>

    companion object {

        operator fun invoke(): WeatherstackApi {
            val mRequestInterceptor = Interceptor { chain ->
                val mRequestUrl = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()

                val mRequest = chain.request()
                    .newBuilder()
                    .url(mRequestUrl)
                    .build()

                return@Interceptor chain.proceed(mRequest)
            }

            val mOkHttpClient = OkHttpClient.Builder()
                .addInterceptor(mRequestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherstackApi::class.java)
        }
    }
}