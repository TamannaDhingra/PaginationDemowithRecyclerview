package com.example.paginationdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.paginationdemo.repo.Repostries


class GetAllDhabasFactory(repo: Repostries) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GetAllDhabas() as T
    }
}
