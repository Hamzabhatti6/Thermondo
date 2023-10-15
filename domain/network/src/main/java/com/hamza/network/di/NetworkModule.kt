package com.hamza.network.di

import com.hamza.network.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}