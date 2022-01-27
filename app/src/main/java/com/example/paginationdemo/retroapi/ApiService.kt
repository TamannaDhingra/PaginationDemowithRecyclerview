package com.example.paginationdemo.retroapi

import com.example.paginationdemo.model.ApiResponseModel
import com.example.paginationdemo.model.DhabaLocationResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("dhaba/getlocation")
    fun getDhabasByLocation(@Field("latitude") latitude: String?,
                            @Field("longitude") longitude: String?,
                            @Field("radius") radius: String?,
                            @Field("count") count: String?,
                            @Field("page") page: String?

    ): Call<ApiResponseModel<List<DhabaLocationResponse>?>>


}