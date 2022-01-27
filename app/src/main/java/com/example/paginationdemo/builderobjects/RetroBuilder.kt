package com.example.paginationdemo.builderobjects

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object RetroBuilder {
        fun AllDhaba(): Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://54.190.192.105:6123/api/v1/")
                .build()
        }

    }
