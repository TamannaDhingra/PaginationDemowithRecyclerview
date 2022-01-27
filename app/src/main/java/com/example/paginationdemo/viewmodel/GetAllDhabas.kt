package com.example.paginationdemo.viewmodel

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.paginationdemo.R
import com.example.paginationdemo.model.ApiResponseModel
import com.example.paginationdemo.model.DhabaLocationResponse
import com.example.paginationdemo.retroapi.NetworkAdapter
import retrofit2.Call
import retrofit2.Response
import java.util.logging.Handler


class GetAllDhabas:ViewModel() {
    val data3= MutableLiveData<ApiResponseModel<List<DhabaLocationResponse>?>>()
    val datatemp: LiveData<ApiResponseModel<List<DhabaLocationResponse>?>>
        get() = data3


    fun getDhaba( context:Activity,lat:String,lang:String,radii:String,count:String,page:String){
        val progress=context.findViewById<ProgressBar>(R.id.progressbar2)

    NetworkAdapter.getRetrofitInstanceAll().getDhabasByLocation(lat,lang,radii,count,page).enqueue(object : retrofit2.Callback<ApiResponseModel<List<DhabaLocationResponse>?>> {
        override fun onResponse(
            call: Call<ApiResponseModel<List<DhabaLocationResponse>?>>,
            response: Response<ApiResponseModel<List<DhabaLocationResponse>?>>
        ) {
            if(response.isSuccessful){
               // progress.visibility= View.VISIBLE
                Log.d("TAG", "onResponse: Success DhabaDetail")
                data3.postValue(response.body())
               // progress.visibility= View.GONE
            }
            else{
                Toast.makeText(context, response.body().toString(), Toast.LENGTH_SHORT)
                    .show()
             //  progress.visibility=View.GONE
            }

           // Log.d("TAG", "onResponse: Success DhabaDetail"+response.body()?.data?.get(0)?.dhaba?.name)


        }

        override fun onFailure(
            call: Call<ApiResponseModel<List<DhabaLocationResponse>?>>,
            t: Throwable
        ) {
            Log.d("TAG", "onFailure: Failure DhabaDetail")

            progress.visibility=View.GONE

        }
    })

}


}