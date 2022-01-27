package com.example.paginationdemo.retroapi

import com.example.paginationdemo.builderobjects.RetroBuilder


object NetworkAdapter {

    fun getRetrofitInstanceAll(): ApiService {
        return RetroBuilder.AllDhaba().create(ApiService::class.java)
    }


}