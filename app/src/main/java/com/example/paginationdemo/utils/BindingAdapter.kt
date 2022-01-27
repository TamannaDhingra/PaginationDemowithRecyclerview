package com.example.paginationdemo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.gms.fido.fido2.api.common.RequestOptions


object BindingAdapter {
  @JvmStatic
    @BindingAdapter("dhabaimg")
  fun loadImage(view: ImageView, imageUrl: String?) {
      Glide.with(view.getContext())
          .load(imageUrl)
          .into(view)
  }
}

