package com.example.paginationdemo.model


 data class DhabaLocationResponse (
        var dhaba:Dhaba,
        var owner:Owner
    )



    data class Dhaba (
        val _id: String? = null,
        var name: String? = null,
        val landmark: String? = null,
        val highway: String? = null,
        val pincode: String? = null,
        val address: String? = null,
        val area: String? = null,
        val state: String? = null,
        val city: String? = null,
        val mobile: String? = null,
        val propertyStatus: String? = null,
        val status: String? = null,
        val dhabaCategory: String? = null,
        val images: String? = null,
        val videos: String? = null,
        val isOpen247: Boolean? = null,
        val longitude: Double? = null,
        val latitude: Double? = null

    )

  data class Owner(
       val _id: String? = null,
       val fname: String? = null,
       val email: String? = null,
       val profileImage: String? = null,
       val mobile: String? = null,
       val panNumber: String? = null,
       val aadharNumber: String? = null,
       val idproofFront: String? = null,
       val idproofBack: String? = null,
       val mobilePrefix: String? = null


  )


